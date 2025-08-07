class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[n];
        helper(n, k, ans, new ArrayList<>(), used, 1);
        return ans;
    }
    void helper(int n, int k, List<List<Integer>> ans, List<Integer> curr, boolean used[], int start){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i <= n; i++){
            if(!used[i - 1]){
                curr.add(i);
                used[i - 1] = true;
                helper(n, k, ans, curr, used, i + 1);
                curr.remove(curr.size() - 1);
                used[i - 1] = false;
            }
        }
    }
}
// 1 2 3 4 5 6 7 8 9