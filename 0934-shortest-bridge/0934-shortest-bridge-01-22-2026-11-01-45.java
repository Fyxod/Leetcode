class Solution {
    int par[];
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int tot = n * n;
        par = new int[tot];
        for(int i = 0; i < tot; i++) par[i] = i;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                int id = i * n + j;

                for(int dir[] : DIR){
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    if(nr >= n || nc >= n || nc < 0 || nr < 0 || grid[nr][nc] == 0) continue;
                    int nid = nr * n + nc;

                    union(id, nid);
                }
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int a = -1;
        int b = -1;

        for(int i = 0; i < tot; i++){
            int r = i / n;
            int c = i % n;
            if(grid[r][c] == 0) continue;
            int x = find(i);
            if(a == -1){
                a = x;
                list1.add(i);
            }
            else if(a == x) list1.add(i);
            else if(b == -1){
                b = x;
                list2.add(i);
            }
            else list2.add(i);
        }

        int min = n * n;
        // System.out.println(list1);
        // System.out.println(list2);
        for(int x : list1){
            for(int y : list2){
                int r1 = x / n;
                int c1 = x % n;
                int r2 = y / n;
                int c2 = y % n;

                min = Math.min(min, Math.abs(r1 - r2) + Math.abs(c1 - c2));
            }
        }

        return min - 1;
    }
    int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    void union(int x, int y){
        int par1 = find(x);
        int par2 = find(y);
        if(par1 == par2) return;
        par[par2] = par1;
    }
}
