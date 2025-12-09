class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long N = n;
        if(N < 0){
            N = -N;
            x = 1 / x;
        }
        double result = 1;
        while(N > 0){
            if(N % 2 != 0) result *= x;
            N = N / 2;
            x*=x;
        }
        return result;
    }
}