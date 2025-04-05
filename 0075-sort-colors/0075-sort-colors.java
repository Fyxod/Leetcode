class Solution {
    public void sortColors(int[] nums) {
        int size = nums.length;

        int index = 0;
        
        for(int i = index + 1; i < size; i++){
            boolean flag = false;
            while(nums[index] == 0){
                index++;
                if(index == size - 1){
                    flag = true;
                    break;
                }
                i = index + 1;
            }
            if(flag) break;

            if(nums[i] == 0){
                nums[i] = nums[index];
                nums[index] = 0;
                index++;
            }
        }

        System.out.println(index);

        for(int i = index + 1; i < size; i++){
            boolean flag = false;
            while(nums[index] == 1){
                index++;
                if(index == size - 1){
                    flag = true;
                    break;
                }
                i = index + 1;
            }
            if(flag) break;

            if(nums[i] == 1){
                nums[i] = nums[index];
                nums[index] = 1;
                index++;
            }
        }
    }
}