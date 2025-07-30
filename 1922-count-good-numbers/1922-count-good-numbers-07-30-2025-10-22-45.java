class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        int mod = 1000000007;
        long even = (n + 1) / 2;
        long odd = n / 2;
        long evenWays = pow(5, even);
        long oddWays = pow(4, odd);
        return (int)((evenWays * oddWays) % mod);
    }
    long pow(long base, long power){
        if(power == 1) return base;
        long result = 1;
        while(power > 0){
            if(power % 2 != 0){
                result = (base * result) % mod;
            }
            power = power / 2;
            base = base * base;
        }
        return result;
    }
}