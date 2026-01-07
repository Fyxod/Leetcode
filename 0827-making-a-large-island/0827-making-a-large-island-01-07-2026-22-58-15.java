class Solution {
    public int largestIsland(int[][] grid) {
        int DIR[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int tot = n * n;
    
        DSU ds = new DSU(tot + 1);
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0) continue;
                int ind = r * n + c;

                for(int dir[] :DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if(grid[nr][nc] == 0) continue;
                    int ni = nr * n + nc;
                    ds.join(ni, ind);
                }
            }
        }
        int max = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1) continue;
                Set<Integer> set = new HashSet<>();
                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if(grid[nr][nc] == 0) continue;
                    int ind = nr * n + nc;
                    set.add(ds.findPar(ind));
                }
                int sum = 1;
                for(int a : set){
                    sum += ds.size[a];
                }
                max = Math.max(max, sum);
            }
        }
        for(int a : ds.size) max = Math.max(max, a);
        return max;
    }
}
class DSU{
    int par[];
    int size[];
    
    DSU(int n){
        par = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        Arrays.fill(size, 1);
    }
    
    int findPar(int x){
        if(x == par[x]) return x;
        
        return par[x] = findPar(par[x]);
    }
    
    boolean join(int a, int b){
        int par1 = findPar(a);
        int par2 = findPar(b);
        
        if(par1 == par2) return false;
        if(size[par1] > size[par2]){
            size[par1] += size[par2];
            par[par2] = par1;
        }
        else{
            size[par2] += size[par1];
            par[par1] = par2;
        }
        return true;
    }
}