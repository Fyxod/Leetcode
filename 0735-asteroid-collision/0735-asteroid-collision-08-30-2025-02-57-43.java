class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int a : asteroids){
            if(stack.isEmpty() || a > 0 || stack.peek() < 0) stack.push(a);
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(a) > stack.peek()) stack.pop();
                if(stack.isEmpty() || stack.peek() < 0) stack.push(a);
                else if(stack.peek() == Math.abs(a)) stack.pop();
            }
        }
        int ans[]= new int[stack.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}