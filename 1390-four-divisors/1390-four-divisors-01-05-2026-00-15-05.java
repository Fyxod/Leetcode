class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            if(map.containsKey(a)){
                sum += map.get(a);
                continue;
            }
            int cnt = 0;
            int s = 0;
            for(int i = 1; i * i <= a; i++){
                if(a % i == 0){
                    cnt++;
                    s += i;

                    if(i * i != a){
                        cnt++;
                        s += a / i;
                    }
                    if(cnt > 4) break;
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