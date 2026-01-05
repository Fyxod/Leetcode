class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(dp, s, 0) - 1;
    }
    int helper(int[] dp, String s, int start){
        if(start == s.length()) return 0;
        
        if(dp[start] != -1) return dp[start];
        int min = Integer.MAX_VALUE;
        for(int end = start; end < s.length(); end++){
            if(isPal(s, start, end)){
                min = Math.min(min, helper(dp, s, end + 1));
            }
        }

        return dp[start] = 1 + min;
    }
    boolean isPal(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}