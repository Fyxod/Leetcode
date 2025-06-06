class Solution {
    void reverse(int arr[], int a, int b){
        while(a < b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;b--;
        }
    }
    public void rotate(int[] nums, int k) {
        if(nums.length == 1) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
}