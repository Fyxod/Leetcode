class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        int  n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(list[val] == null) list[val] = new ArrayList<>();
            list[val].add(key);
        }
        int ind = k - 1;
        for(int i = n; i >= 0 && ind >= 0; i--){
            if(list[i] != null){
                for(int a : list[i]){
                    ans[ind--] = a;
                    if(ind < 0) break;
                }
            }
        }

        return ans;
    }
}