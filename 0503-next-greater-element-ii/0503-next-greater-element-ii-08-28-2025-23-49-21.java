class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int largeI = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[largeI]) largeI = i;
        }
        int ans[] = new int[nums.length];
        int filled = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = largeI;
        while(filled < nums.length){
            if(i == -1) i = nums.length - 1;
            int el = nums[i];
            while(!stack.isEmpty() && el >= stack.peek()) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            filled++;
            i--;
            stack.push(el);
        }
        return ans;
    }
}