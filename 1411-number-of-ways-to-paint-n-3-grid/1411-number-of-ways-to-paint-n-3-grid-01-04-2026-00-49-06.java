class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long A = 6;
        long B = 6;

        for(int i = 1; i < n; i++){
            long nA = (A * 3 + B * 2) % MOD;
            long nB = (A * 2 + B * 2) % MOD;
            A = nA;
            B = nB;
        }
        return (int)((A + B) % MOD);
    }
}