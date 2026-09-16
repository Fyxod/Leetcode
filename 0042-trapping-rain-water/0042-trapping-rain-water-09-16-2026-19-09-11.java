class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ng[] = new int[n];
        int pge[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i>= 0; i--){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]) stack.pop();
            ng[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) stack.pop();
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            if(ng[i] != -1 && pge[i] != -1){
                ans += (ng[i] - pge[i] - 1) * ((Math.min(height[ng[i]], height[pge[i]]) - height[i]));
            }
        }

        return ans;
    }
}