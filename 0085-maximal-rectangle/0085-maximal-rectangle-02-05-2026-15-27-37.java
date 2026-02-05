class Solution {
    public int maximalRectangle(char[][] mat) {
        int arr[] = new int[mat[0].length];
        int n = mat.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < arr.length; j++){
                if(mat[i][j] == '1') arr[j]++;
                else arr[j] = 0;

                while(!stack.isEmpty() && arr[stack.peek()] >= arr[j]){
                    int el = arr[stack.pop()];
                    int prev = stack.isEmpty()? -1 : stack.peek();
                    ans = Math.max(ans, (j - prev - 1) * el);
                }
                stack.push(j);
            }
            while(!stack.isEmpty()){
                int el = arr[stack.pop()];
                int prev = stack.isEmpty()? -1 : stack.peek();
                ans = Math.max(ans, (arr.length - prev - 1) * el);
            }
        }
        return ans;
    }
}