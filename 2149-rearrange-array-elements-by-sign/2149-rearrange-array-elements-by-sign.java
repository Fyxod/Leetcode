// brute force(using extra space)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int neg = 0;
        int pos = 0;
        int flag = 1;
        int arr[] = new int[nums.length];
        int index = 0;
        while(pos < nums.length && nums[pos] < 0) pos++;
        while(neg < nums.length && nums[neg] > 0) neg++;
        while(index < nums.length){

            if(flag > 0){
                arr[index++] = nums[pos++];
                flag*=-1;
                while(pos < nums.length && nums[pos] < 0) pos++;
            }
            else{
                arr[index++] = nums[neg++];
                flag*=-1;
                while(neg < nums.length && nums[neg] > 0) neg++;
            }
        }
        return arr;
    }
}