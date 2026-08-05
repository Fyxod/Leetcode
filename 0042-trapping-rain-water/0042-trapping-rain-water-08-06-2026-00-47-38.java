class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ng[] = new int[n];
        int pg[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) stack.pop();
            ng[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) stack.pop();
            pg[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            if(pg[i] != -1 && ng[i] != -1){
                ans += (ng[i] - pg[i] - 1) * (Math.min(height[ng[i]], height[pg[i]]) - height[i]);
            }
        }

        return ans;
    }
}