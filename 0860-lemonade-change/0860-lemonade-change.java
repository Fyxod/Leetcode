class Solution {
    public boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(20, 0);
        map.put(10, 0);
        map.put(5, 0);

        for(int a : bills){
            map.put(a, map.get(a) + 1);
            a = a - 5;

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(a == 0) break;
                int count = entry.getValue();
                int denom = entry.getKey();
                if(denom > a || count == 0) continue;

                while(count != 0 && denom <= a){
                    a -= denom;
                    count--;
                    map.put(denom, map.get(denom) - 1);
                }
            }
            if(a != 0) return false;
        }

        return true;
    }
}