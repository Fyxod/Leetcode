class Solution {
    public int makeConnected(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>();
        int extra = 0;
        int connected = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int edge[] : connections){
            int u = edge[0];
            int v = edge[1];
            if(ds.union(u, v)) connected++;
            else{
                extra++;
            }
        }
        int req = n - 1 - connected;
        return (req <= extra) ? req : -1;
    }
}
class DisjointSet{
    int[] size;
    int[] par;
    
    DisjointSet(int s){
        size = new int[s];
        par = new int[s];
        for(int i = 0; i < s; i++){
            par[i] = i;
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
        int sizeA = size[parA];
        int sizeB = size[parB];
        
        if(sizeA > sizeB){
            size[parA] = sizeA + sizeB;
            par[parA] = parB;
        }
        else{
            size[parB] = sizeA + sizeB;
            par[parB] = parA;
        }
        return true;
    }
}