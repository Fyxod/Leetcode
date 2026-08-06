class Solution {
    public int[] asteroidCollision(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                int val = -arr[i];
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < val) stack.pop();
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(arr[i]);
                    continue;
                }
                if(val == stack.peek()) stack.pop();
            }
            else stack.push(arr[i]);
        }
        int size = stack.size();
        int ans[] = new int[size];
        for(int i = size - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }
}