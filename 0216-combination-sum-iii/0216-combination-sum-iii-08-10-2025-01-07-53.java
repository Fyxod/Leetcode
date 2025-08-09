class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(n, k, list, new ArrayList<>(), 0, 1);
        return list;
    }
    void helper(int n, int k, List<List<Integer>> list, List<Integer> curr, int sum, int start){
        if(k == 0){
            if(sum == n) list.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= 9; i++){
            curr.add(i);
            helper(n, k - 1, list, curr, sum + i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}