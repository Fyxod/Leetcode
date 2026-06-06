class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long N = n;
        if(n < 0){
            N = -N;
            x = 1 / x;
        }
        double result = 1;
        while(N > 0){   
            if(N % 2 == 1) result *= x;
            x *= x;
            N = N / 2;
        }

        return result;
    }
}