class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ns[] = new int[n];
        int ps[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, (ns[i] - ps[i] - 1) * heights[i]);
        }

        return max;
    }
}