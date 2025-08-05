class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }
    void helper(int cand[], int target, int index, int sum, List<List<Integer>> ans, List<Integer> curr){
        if(sum > target) return;
        else if(sum == target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(index == cand.length) return;
        curr.add(cand[index]);
        helper(cand, target, index, sum + cand[index], ans, curr);
        curr.remove(curr.size() - 1);
        helper(cand, target, index + 1, sum, ans, curr);
    }
}