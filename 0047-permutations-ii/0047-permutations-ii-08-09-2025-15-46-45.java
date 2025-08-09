class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        helper(nums, list, new ArrayList<>(), used);
        return list;
    }
    void helper(int nums[], List<List<Integer>> ans, List<Integer> curr, boolean[] used){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if(used[i]) continue;
            curr.add((nums[i]));
            used[i] = true;
            helper(nums, ans, curr, used);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}

// 0 1 1 1 1 2 3