class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 1, 0, k, n);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int start, int sum, int k, int n){
        if(sum == n){
            if(list.size() == k) ans.add(new ArrayList<>(list));
            return;
        }
        if(list.size() == k) return;

        for(int i = start; i <= 9; i++){
            if(sum + i > n) break;
            list.add(i);
            helper(ans, list, i + 1, sum + i, k, n);
            list.remove(list.size() - 1);            
        }
    }
}