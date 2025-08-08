class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }
    void helper(int n, int k, List<List<Integer>> ans, List<Integer> curr, int start){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(curr.size() + n - start + 1 < k) return;

        for(int i = start; i <= n; i++){
                curr.add(i);
                helper(n, k, ans, curr, i + 1);
                curr.remove(curr.size() - 1);
        }
    }
}