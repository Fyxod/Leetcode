class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long odds = n / 2;
        long evens = n - odds;

        long t1 = pow(5, evens);
        long t2 = pow(4, odds);

        return (int)((t1 * t2) % MOD);
    }

    long pow(long x, long N){
        long result = 1;
        while(N > 0){
            if(N % 2 == 1) result  = (result * x) % MOD;
            x  = (x*x) % MOD;
            N = N  / 2;
        }

        return result % MOD;
    }
}