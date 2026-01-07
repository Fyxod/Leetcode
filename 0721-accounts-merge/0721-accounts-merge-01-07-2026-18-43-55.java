class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailtoacc = new HashMap<>();
        int n = accounts.size();
        DSU ds = new DSU(n);
        for(int i = 0; i < n; i++){
            List<String> acc = accounts.get(i);
            for(int j = 1; j < acc.size(); j++){
                String str = acc.get(j);
                if(emailtoacc.containsKey(str)) ds.union(emailtoacc.get(str), i);
                else emailtoacc.put(str, i);
            }
        }

        Map<Integer, TreeSet<String>> map = new HashMap<>();
        for(String key : emailtoacc.keySet()){
            int root = ds.findPar(emailtoacc.get(key));
            if(!map.containsKey(root)) map.put(root, new TreeSet<>());
            map.get(root).add(key);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int key : map.keySet()){
            List<String> acc = new ArrayList<>();
            acc.add(accounts.get(key).get(0));
            acc.addAll(map.get(key));
            ans.add(acc);
        }
        return ans;
    }
}
class DSU{
    int par[];
    int size[];
    
    DSU(int n){
        par = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
    }
    
    int findPar(int x){
        if(x == par[x]) return x;
        
        return par[x] = findPar(par[x]);
    }
    
    boolean union(int a, int b){
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