class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int height[] = new int[n];

        int max = 0;

        for(int r = 0; r < m; r++){
            for(int j = 0; j < n; j++){
                if(matrix[r][j] == '1') height[j] += 1;
                else height[j] = 0;
            }

            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i <= n; i++){
                int el = i == n ? 0 : height[i];
                while(!stack.isEmpty() && height[stack.peek()] >= el){
                    int h = height[stack.pop()];
                    int prev = stack.isEmpty() ? -1 : stack.peek();
                    int w = i - prev - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            }
        }

        return max;
    }
}