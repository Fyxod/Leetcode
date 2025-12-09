class Solution {
    long mod = (long)(1e9 + 7);
    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n - odd;
        long e = myPow(5, even);
        long o = myPow(4, odd);

        return (int)((e*o) % mod);
    }
    public long myPow(long x, long n) {
        if(n == 0) return 1;
        long N = n;
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        long result = 1;
        while(N > 0){
            if(N % 2 == 1) result = (result * x) % mod;
            x = (x * x) % mod;
            N /= 2;
        }
        return result;
    }
}