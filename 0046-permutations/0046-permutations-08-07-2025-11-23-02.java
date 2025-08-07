class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), 0, 0);
        return ans;
    }
    void helper(int nums[], List<List<Integer>> ans, List<Integer> curr, int index, int length){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0, j = index; i < nums.length; i++, j++){
            if(!curr.contains(nums[(j + 1) % nums.length])){
                curr.add(nums[(j + 1) % nums.length]);
                helper(nums, ans, curr, j + 1, length + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
// index=0,length=0

// i=0,j=-1 [1]

// index=0,length=1

// i=2,j=1 [1,3]

// index=2,length=2

// i=2,j=2 [1,3,]
