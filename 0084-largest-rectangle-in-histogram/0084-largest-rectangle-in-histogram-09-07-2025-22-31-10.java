class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int el = heights[stack.pop()];
                int prev = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, el * (i - prev - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int el = heights[stack.pop()];
            int prev = stack.isEmpty()? -1 : stack.peek();
            max = Math.max(max, el * (n - prev - 1));
        }
        return max;
    }
}