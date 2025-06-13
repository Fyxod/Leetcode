class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length){
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    int temp = nums[j];
                    while(j < k && nums[j] == temp) j++;
                    temp = nums[k];
                    while(j < k && nums[k] == temp) k--;
                }
                else if(sum < 0){
                    int temp = nums[j];
                    while(j < k && nums[j] == temp) j++;
                }
                else if(sum > 0){
                    int temp = nums[k];
                    while(j < k && nums[k] == temp) k--;
                }
            }
                int tempi = nums[i];
                while(i < nums.length && nums[i] == tempi) i++;
        }
            return list;
    }
}




















// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> set = new HashSet<>();

//         for(int i = 0; i < nums.length; i++){
//             Set<Integer> list = new HashSet<>();

//             for(int j = i + 1; j < nums.length; j++){
//                 int third = -(nums[i] + nums[j]);
//                 if(list.contains(third)){
//                     List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
//                     Collections.sort(temp);
//                     set.add(temp);
//                 }
//                 list.add(nums[j]);
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
//     }
// }