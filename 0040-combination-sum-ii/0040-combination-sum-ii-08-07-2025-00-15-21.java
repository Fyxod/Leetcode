class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        helper(candidates, target, 0, set, new ArrayList<>());
        return new ArrayList<>(set);
    }
    void helper(int cand[], int target, int index, Set<List<Integer>> set, List<Integer> curr){
        if(target == 0){
            set.add(new ArrayList<>(curr));
            return;
        }
        if(index == cand.length || target < 0) return;
        curr.add(cand[index]);
        helper(cand, target - cand[index], index + 1, set, curr);
        curr.remove(curr.size() - 1);
        helper(cand, target, index + 1, set, curr);       
    }
}