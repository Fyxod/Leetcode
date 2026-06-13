class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int start, int nums[]){
        ans.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i] != nums[i - 1]){
                list.add(nums[i]);
                helper(ans, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}