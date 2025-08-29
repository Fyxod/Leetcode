class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int ans = 0;
        int ns[] = new int[n];
        int pse[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) ns[i] = n;
            else ns[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }

        for(int i = 0; i < n; i++){
            long left = i - pse[i];
            long right = ns[i] - i;
            long add = (left * right) % mod;
            add = (add * arr[i]) % mod;
            ans = (int)((ans + add) % mod);
        }
        return ans;
    }
}