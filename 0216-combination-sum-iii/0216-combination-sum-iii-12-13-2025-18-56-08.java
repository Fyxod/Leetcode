class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, k, n, new ArrayList<>(), 1);
        return list;
    }
    void helper(List<List<Integer>> list, int k, int sum, List<Integer> curr, int start){
        if(k == 0){
            if(sum == 0) list.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= 9; i++){
            if(i > sum) break;
            curr.add(i);
            helper(list, k - 1, sum - i, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}