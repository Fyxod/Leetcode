class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double result = helper(x, Math.abs((long)n));
        if(n < 0) return 1 / result;
        return result;
    }
    double helper(double x, long n){
        if(n == 1) return x;
        if(n % 2 != 0) return x * helper(x*x, (n - 1) / 2);
        else return helper(x*x, n/2);
    }
}