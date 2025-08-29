class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ng[] = new int[n];
        int pg[] = new int[n];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int ind = n - i - 1;
            while(!stack1.isEmpty() && height[ind] >= height[stack1.peek()]) stack1.pop();
            if(stack1.isEmpty()) ng[ind] = -1;
            else ng[ind] = stack1.peek();
            stack1.push(ind);

            while(!stack2.isEmpty() && height[i] >= height[stack2.peek()]) stack2.pop();
            if(stack2.isEmpty()) pg[i] = -1;
            else pg[i] = stack2.peek();
            stack2.push(i);
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