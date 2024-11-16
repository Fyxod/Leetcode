class Solution {
    public int differenceOfSums(int n, int m) {
            int limit = n / m;
            int sumD = (limit * (limit + 1) / 2) * m;
            return (n * (n+1)/2) - 2*sumD;
    }
}