class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> ans = new ArrayList<>();
        int n = cand.length;

        helper(cand, ans, 0, target, new ArrayList<>());
        return ans;
    }
    public void helper(int cand[], List<List<Integer>> ans, int start, int sum, List<Integer> list){
        if(sum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum < 0 || start == cand.length) return;

        for(int i = start; i < cand.length; i++){
            if(i == start || cand[i] != cand[i - 1]){
                list.add(cand[i]);
                helper(cand, ans, i + 1, sum - cand[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}