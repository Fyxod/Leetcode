class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ns[] = getNextSmaller(heights);
        int ps[] = getPreviousSmaller(heights);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int bars = ns[i] - ps[i] - 1;
            max = Math.max(max, bars*heights[i]);
        }
        return max;
    }
    int[] getNextSmaller(int nums[]){
        Deque<Integer> stack = new ArrayDeque<>();
        int ns[] = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if(stack.isEmpty()) ns[i] = nums.length;
            else ns[i] = stack.peek();
            stack.push(i);
        }
        return ns;
    }
    int[] getPreviousSmaller(int nums[]){
        Deque<Integer> stack = new ArrayDeque<>();
        int ps[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if(stack.isEmpty()) ps[i] = -1;
            else ps[i] = stack.peek();
            stack.push(i);
        }
        return ps;
    }
}