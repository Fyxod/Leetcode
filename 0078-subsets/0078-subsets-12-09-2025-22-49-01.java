class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0, new ArrayList<>());
        return list;
    }
    void helper(List<List<Integer>> list, int nums[], int i, List<Integer> curr){
        if(i == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(list, nums, i + 1, curr);
        curr.remove(curr.size() - 1);
        helper(list, nums, i + 1, curr);
    }
}