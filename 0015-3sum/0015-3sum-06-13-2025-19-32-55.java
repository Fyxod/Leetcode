class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            Set<Integer> list = new HashSet<>();

            for(int j = i + 1; j < nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if(list.contains(third)){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    Collections.sort(temp);
                    set.add(temp);
                }
                list.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}