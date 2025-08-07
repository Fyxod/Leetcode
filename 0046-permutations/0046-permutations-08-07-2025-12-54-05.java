class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>());
        return ans;
    }
    void helper(int nums[], List<List<Integer>> ans, List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                helper(nums, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}