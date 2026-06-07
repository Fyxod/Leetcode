class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 0, target, candidates);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int pos, int sum, int cand[]){
        if(sum < 0 || pos == cand.length) return;
        if(sum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        helper(ans, list, pos + 1, sum, cand);
        list.add(cand[pos]);
        helper(ans, list, pos, sum - cand[pos], cand);
        list.remove(list.size() - 1);
    }
}