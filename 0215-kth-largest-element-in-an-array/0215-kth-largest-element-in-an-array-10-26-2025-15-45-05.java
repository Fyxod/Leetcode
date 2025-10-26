class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int i = n/2 - 1;
        while(i >= 0){
            heapify(nums, i, n);
            i--;
        }
        int ans = -1;
        for(int j = 0; j < k; j++){
            ans = nums[0];
            swap(nums, 0, n - 1);
            n--;
            heapify(nums, 0, n);
        }
        return ans;
    }

    public void heapify(int nums[], int i, int n){
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;

        int left = leftIndex > n - 1 ? Integer.MIN_VALUE : nums[leftIndex];
        int right = rightIndex > n - 1 ? Integer.MIN_VALUE : nums[rightIndex];

        int largest = i;
        if(left > nums[largest]){
            largest = leftIndex;
        }
        if(right > nums[largest]){
            largest = rightIndex;
        }

        if(largest != i){
            swap(nums, largest, i);
            heapify(nums, largest, n);
        }
    }
    void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}