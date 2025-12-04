class Solution {
    public int largestIsland(int[][] grid) {
        int DIR[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int tot = n*n;
        DSU ds = new DSU(tot
        );

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                int id = i * n + j;
                for(int dir[] : DIR){
                    int nr = i + dir[0], nc = j + dir[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 0) continue;
                    int newId = nr * n + nc;
                    ds.union(id, newId);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) max = Math.max(ds.size[ds.findPar(i * n + j)], max);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) continue;
                for(int dir[] : DIR){
                    int nr = i + dir[0], nc = j + dir[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 0) continue;
                    int id = nr * n + nc;
                    set.add(ds.findPar(nr * n + nc));
                }
                int sum = 0;
                for(int a : set){
                    int s = ds.size[a];
                    sum += s;
                }
                max = Math.max(max,sum + 1);
                set.clear();
            }
        }
        return max;
    }
}
class DSU{
    int[] par;
    int size[];
    
    DSU(int s){
        par = new int[s];
        size = new int[s];
        for(int i = 0; i < s; i++){
            par[i] = i;
            size[i] = 1;
        }
    }

    int findPar(int node){
        if(node == par[node]) return node;
        par[node] = findPar(par[node]);
        return par[node];
    }
    boolean union(int a, int b){
        int parA = findPar(a);
        int parB = findPar(b);
        
        if(parA == parB) return false;
        
        if(size[parA] > size[parB]){
            par[parB] = parA;
            size[parA] += size[parB];
        }
        else{
            par[parA] = parB;
            size[parB] += size[parA];
        }
        return true;
    }
}