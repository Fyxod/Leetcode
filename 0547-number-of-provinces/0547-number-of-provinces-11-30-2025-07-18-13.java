class Solution {
    public int findCircleNum(int[][] isConnected) {
        int prov = 0;
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1) ds.union(i, j);
            }
        }
        Set<Integer> un = new HashSet<>();
        for(int i = 0; i < n; i++) ds.findPar(i);
        for(int a : ds.par){
            un.add(a);
        }
        return un.size();
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