class Solution {
    int n1;
    int n2;
    boolean dp[][];
    public boolean isMatch(String s, String p) {
        n1 = s.length();
        n2 = p.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < n2){
            char ch = p.charAt(i++);
            if(ch == '*'){
                while(i < n2 && p.charAt(i) == '*') i++;
            }
            sb.append(ch);
        }

        int size = sb.length();
        p = sb.toString();
        if(n1 == 0){
            if(size == 0) return true;
            if(size == 1 && p.charAt(0) == '*') return true;
        }
        if(size == 0) return false;


        dp = new boolean[n1 + 1][size + 1];
        
        dp[0][0] = true;
        if(p.charAt(0) == '*') dp[0][1] = true;
        
        for(i = 1; i <= n1; i++){
            for(int j = 1; j <= size; j++){
                boolean res = false;
                char ch = p.charAt(j - 1);
                if(ch == '*'){
                    res = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                }
                else if(ch == '?') res = dp[i - 1][j - 1];
                else if(ch == s.charAt(i - 1)) res = dp[i - 1][j - 1];

                dp[i][j] = res;
            }
        }
        return dp[n1][size];
    }
}