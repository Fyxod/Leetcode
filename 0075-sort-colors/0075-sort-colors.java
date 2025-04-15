class Solution {
    public void sortColors(int[] nums) {

        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while(j <= k){
            if(nums[j] == 0){
                nums[j] = nums[i];
                nums[i] = 0;
                i++;
                j++;
            }
            else if(nums[j] == 2){
                nums[j] = nums[k];
                nums[k] = 2;
                k--;
            }
            else{
                j++;
            }
        }
    }
}

//brute force - 2 passes
// class Solution {
//     public void sortColors(int[] nums) {
//         int size = nums.length;

//         int index = 0;
        
//         for(int i = index + 1; i < size; i++){
//             boolean flag = false;
//             while(nums[index] == 0){
//                 index++;
//                 if(index == size - 1){
//                     flag = true;
//                     break;
//                 }
//                 i = index + 1;
//             }
//             if(flag) break;

//             if(nums[i] == 0){
//                 nums[i] = nums[index];
//                 nums[index] = 0;
//                 index++;
//             }
//         }

//         System.out.println(index);

//         for(int i = index + 1; i < size; i++){
//             boolean flag = false;
//             while(nums[index] == 1){
//                 index++;
//                 if(index == size - 1){
//                     flag = true;
//                     break;
//                 }
//                 i = index + 1;
//             }
//             if(flag) break;

//             if(nums[i] == 1){
//                 nums[i] = nums[index];
//                 nums[index] = 1;
//                 index++;
//             }
//         }
//     }
// }