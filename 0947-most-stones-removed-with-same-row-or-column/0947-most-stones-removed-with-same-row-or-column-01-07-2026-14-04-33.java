class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Map<Integer, Integer> rmap = new HashMap<>();
        Map<Integer, Integer> cmap = new HashMap<>();
        int par[] = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        for(int i = 0; i < n; i++){
            int r = stones[i][0];
            int c = stones[i][1];
            if(rmap.containsKey(r)) join(i, rmap.get(r), par);
            else rmap.put(r, i);
            if(cmap.containsKey(c)) join(i, cmap.get(c), par);
            else cmap.put(c, i);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(findPar(par, i) == i) cnt++;
        }
        return n - cnt;
    }
    int findPar(int par[], int x){
        if(par[x] == x) return x;
        return par[x] = findPar(par, par[x]);
    }
    boolean join(int a, int b, int par[]){
        int par1 = findPar(par, a);
        int par2 = findPar(par, b);

        if(par1 == par2) return false;
        par[par1] = par2;
        return true;
    }
}