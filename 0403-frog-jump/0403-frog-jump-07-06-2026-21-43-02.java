class Solution {
    int n;
    int last;
    int dp[][];
    Set<Integer> set = new HashSet<>();
    Map<String, Boolean> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        if(stones.length == 1) return true;
        if(stones[1] != 1) return false;
        n = stones.length;
        last = stones[n - 1];
        for(int a : stones) set.add(a);

        return f(1, 1);
    }
    boolean f(int i, int k){
        if(i == last) return true;

        String key = i + "" + k;
        if(map.containsKey(key)) return map.get(key);
        boolean res = false;
        if(!res && set.contains(i + k + 1)) res = res || f(i + k + 1, k + 1);
        if(set.contains(i + k)) res = res || f(i + k, k);
        if(!res && k - 1 > 0 && set.contains(i + k - 1)) res = res || f(i + k - 1, k - 1);

        map.put(key, res);
        return res;
    }
}