class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int a : nums){
            int cnt = 1;
            int s = a;
            for(int i = 1; i <= a / 2; i++){
                if(a % i == 0){
                    cnt++;
                    if(cnt > 4) break;
                    s += i;
                }
            }
            if(cnt == 4) sum += s;
        }
        return sum;
    }
}