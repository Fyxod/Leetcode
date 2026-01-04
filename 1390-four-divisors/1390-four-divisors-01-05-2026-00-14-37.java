class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            if(map.containsKey(a)){
                sum += map.get(a);
                continue;
            }
            int cnt = 1;
            int s = a;
            for(int i = 1; i <= a / 2; i++){
                if(a % i == 0){
                    cnt++;
                    if(cnt > 4) break;
                    s += i;
                }
            }
            if(cnt == 4) {
                sum += s;
                map.put(a, s);
            }
            else map.put(a, 0);
        }
        return sum;
    }
}