class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        helper(nums, new ArrayList<>(), list, 0);
        return list;
    }
    void helper(int nums[], List<Integer> temp, List<List<Integer>> ans, int index){
        if(nums.length < index + 1) return;
        temp.add(nums[index]);
        ans.add(new ArrayList<>(temp));
        helper(nums, temp, ans, index + 1);
        if(!temp.isEmpty()) temp.remove(temp.size() - 1);
        helper(nums, temp, ans, index + 1);
    }
}