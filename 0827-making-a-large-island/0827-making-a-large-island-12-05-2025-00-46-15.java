class Solution {
    public int largestIsland(int[][] grid) {
        int DIR[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int tot = n*n;

        boolean hasZero = false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    hasZero = true;

        if (!hasZero) return n * n;
        
        int id = 2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1) continue;
                int size = dfs(grid, DIR, id, i, j, n);
                map.put(id, size);
                id++;
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) continue;
                int sum = 1;
                Set<Integer> set = new HashSet<>();
                for(int[] dir : DIR){
                    int nr = i + dir[0], nc = j + dir[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] < 2) continue;
                    if(set.add(grid[nr][nc])) sum += map.get(grid[nr][nc]);
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    int dfs(int[][] grid, int DIR[][], int id, int r, int c, int n){
        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) return 0;
        grid[r][c] = id;
        int area = 1;

        for(int[] dir : DIR){
            int nr = r + dir[0], nc = c + dir[1];
            area += dfs(grid, DIR, id, nr, nc, n);
        }

        return area;
    }
}