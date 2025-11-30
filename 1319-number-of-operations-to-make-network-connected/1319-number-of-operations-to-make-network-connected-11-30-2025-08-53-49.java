class Solution {
    public int makeConnected(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>();
        int extra = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int edge[] : connections){
            int u = edge[0];
            int v = edge[1];
            if(ds.findPar(u) == ds.findPar(v)) extra++;
            else{
                ds.union(u, v);
            }
        }
        for(int i = 0; i < n; i++){
            set.add(ds.findPar(i));
        }
        int req = set.size() - 1;
        if(req <= extra) return req;
        else return -1;
    }
}
class DisjointSet{
    List<Integer> size;
    List<Integer> par;
    
    DisjointSet(int s){
        size = new ArrayList<>();
        par = new ArrayList<>();
        for(int i = 0; i < s; i++){
            par.add(i);
            size.add(1);
        }
    }

    int findPar(int node){
        if(node == par.get(node)) return node;
        par.set(node, findPar(par.get(node)));
        return par.get(node);
    }
    void union(int a, int b){
        int parA = findPar(a);
        int parB = findPar(b);
        
        if(parA == parB) return;
        int sizeA = size.get(parA);
        int sizeB = size.get(parB);
        
        if(sizeA > sizeB){
            size.set(parA, sizeA + sizeB);
            par.set(parB, parA);
        }
        else{
            size.set(parB, sizeB + sizeA);
            par.set(parA, parB);
        }
    }
}