class Solution {
    public int maxProfit(int[] p) {
        Callable call = () -> d(p);
        FutureTask<Integer> f = new FutureTask<>(call);
        new Thread(f).start();
        try{
            return f.get();
        }
        catch(Exception E){
            return 0;
        }
    }

    int d(int p[]){
        int n = p.length;

        int dp[][][] = new int[n][2][2];
        for (int arr[][] : dp)
            for(int arr2[] : arr) Arrays.fill(arr2, -1);
        return f(p, dp, 0, 1, 0);
    }
    int f(int p[], int dp[][][], int i, int buy, int lim){
        if(i == p.length || lim == 2) return 0;

        if(dp[i][buy][lim] != -1) return dp[i][buy][lim];

        if(buy == 1) return dp[i][buy][lim] = Math.max(
            -p[i] + f(p, dp, i + 1, 0, lim),
            f(p, dp, i + 1, 1, lim)
        );
        else return dp[i][buy][lim] = Math.max(
            p[i] + f(p, dp, i + 1, 1, lim + 1),
            f(p, dp, i + 1, 0, lim)
        );
    }
}