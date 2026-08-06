class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ps[] = new int[n];
        int nse[] = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            long left = i - ps[i];
            long right = nse[i] - i;
            long one = (left * right) % 1000000007;
            ans = (int)((ans + ((long)arr[i] * one) % 1000000007) % 1000000007);
        }

        return ans;
    }
}