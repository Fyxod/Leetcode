class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    void helper(int cand[], int target, int start, List<List<Integer>> ans, List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < cand.length; i++){
            if(i > start && cand[i] == cand[i - 1]) continue;

            if(cand[i] <= target){
                curr.add(cand[i]);
                helper(cand, target - cand[i], i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}