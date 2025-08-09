class Solution {
    public String getPermutation(int n, int k) {
        int arr[] = new int[n];

        for(int i = 1; i <= n; i++){
            arr[i - 1] = i;
        }
        for(int i = 1; i < k; i++){
            nextPerm(arr);
        }
        String str = "";
        for(int i = 0; i < arr.length; i++){
            str = str + Integer.toString(arr[i]);
        }
        return str;
    }
    void nextPerm(int nums[]){
        int n = nums.length;
        int index = n - 2;

        for(int i = n - 2; i >= 0 && nums[i] > nums[i + 1]; i--){
            index--;
        }
        if(index == -1){
            reverse(nums, 0, n - 1);
            return;
        }
        int swapI = index + 1;
        for(int i = index + 1; i < n; i++){
            if(nums[i] > nums[index] && nums[i] <= nums[swapI]) swapI = i;
        }
        int temp = nums[index];
        nums[index] = nums[swapI];
        nums[swapI] = temp;
        reverse(nums, index + 1, n - 1);
    }
    void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}