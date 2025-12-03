class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n);
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> list = accounts.get(i);
            for(int j = 1; j < list.size(); j++){
                String s = list.get(j);
                if(map.containsKey(s)) ds.union(i, map.get(s));
                else map.put(s, i);
            }
        }
        for(int i = 0; i < n; i++) ds.findPar(i);
        Map<Integer, Set<String>> map2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            int par = ds.par[i];
            List<String> account = accounts.get(i);
            map2.computeIfAbsent(par, k -> new HashSet<>()).addAll(account.subList(1, account.size()));
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer, Set<String>> entry: map2.entrySet()){
            int par = entry.getKey();
            List<String> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            list.addFirst(accounts.get(par).get(0));
            ans.add(list);
        }
        return ans;
    }
}
class DSU{
    int[] par;
    
    DSU(int s){
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
        
        par[parA] = parB;
        return true;
    }
}