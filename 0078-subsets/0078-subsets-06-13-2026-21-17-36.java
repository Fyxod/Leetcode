class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int pos, int nums[]){
        if(pos == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        helper(ans, list, pos + 1, nums);
        list.add(nums[pos]);
        helper(ans, list, pos + 1, nums);
        list.remove(list.size() - 1);
    }
}