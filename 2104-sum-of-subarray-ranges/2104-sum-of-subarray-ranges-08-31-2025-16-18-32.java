class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int ng[] = new int[n];
        int pge[] = new int[n];
        int ns[] = new int[n];
        int pse[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) stack.pop();
            if(stack.isEmpty()) pge[i] = -1;
            else pge[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) stack.pop();
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            if(stack.isEmpty()) ng[i] = n;
            else ng[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if(stack.isEmpty()) ns[i] = n;
            else ns[i] = stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for(int i = 0; i < n; i++){
            long large = (long)(i - pge[i]) * (ng[i] - i) * nums[i];
            long small = (long)(i - pse[i]) * (ns[i] - i) * nums[i];

            ans = ans + (large - small);
        }
        return ans;
    }
}