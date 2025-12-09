class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), candidates, target, 0, 0);
        return list;
    }
    void helper(List<List<Integer>> list, List<Integer> curr, int[] cand, int t, int start, int sum){
        if(sum > t) return;
        if(sum == t) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < cand.length; i++){
            curr.add(cand[i]);
            helper(list, curr, cand, t, i, sum + cand[i]);
            curr.remove(curr.size() - 1);
        }
    }
}