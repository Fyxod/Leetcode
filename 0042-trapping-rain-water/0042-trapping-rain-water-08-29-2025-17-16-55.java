class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ng[] = new int[n];
        int pg[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]) stack.pop();
            if(stack.isEmpty()) ng[i] = -1;
            else ng[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]) stack.pop();
            if(stack.isEmpty()) pg[i] = -1;
            else pg[i] = stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            if(map.get(pg[i]) != null && map.get(pg[i]) == ng[i]) continue;
            if(ng[i] != -1 && pg[i] != -1){
                int diff = ng[i] - pg[i] - 1;
                ans += diff*(Math.min(height[ng[i]], height[pg[i]]) - height[i]);
                map.put(pg[i], ng[i]);
            }
        }
        return ans;
    }
}
// 6 ind

// 5