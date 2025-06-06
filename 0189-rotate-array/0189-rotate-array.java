class Solution {
    void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        reverse(nums, 0, size - k - 1);
        reverse(nums, size - k, size - 1);
        reverse(nums, 0, size - 1);
        //trying system.gc for the first time
        System.gc();
    }
}