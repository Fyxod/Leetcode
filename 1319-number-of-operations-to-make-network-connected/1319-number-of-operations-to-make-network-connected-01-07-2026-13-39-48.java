class Solution {
    public int makeConnected(int n, int[][] connections) {
        int connected = 1;
        int extras = 0;
        DSU ds = new DSU(n);
        for(int c[] : connections){
            int u = c[0];
            int v = c[1];

            if(ds.join(u, v)) connected++;
            else extras++;
        }
        int left = n - connected;
        return extras >= left ? left : -1;
    }
}
class DSU{
    int par[];

    DSU(int n){
        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
    }
    int findPar(int x){
        if(par[x] == x) return x;
        return par[x] = findPar(par[x]);
    }
    boolean join(int a, int b){
        int par1 = findPar(a);
        int par2 = findPar(b);
        if(par1 == par2) return false;
        par[par1] = par2;
        return true;
    }
}