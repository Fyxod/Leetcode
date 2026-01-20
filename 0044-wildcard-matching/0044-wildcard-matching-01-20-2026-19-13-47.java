class Solution {
    int n1;
    int n2;
    int dp[][];
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
        dp = new int[n1][size];
        System.out.println(sb.toString());
        return f(n1 - 1, size - 1, s, sb.toString());
    }
    boolean f(int i, int j, String s, String p){
        if(i < 0){
            return j < 0 || (j == 0 && p.charAt(j) == '*');
        }
        if(j < 0) return false;
        if(dp[i][j] != 0) return dp[i][j] == 1;

        boolean res = false;
        char ch = p.charAt(j);
        if(ch == '*'){
            res = f(i - 1, j - 1, s, p) || f(i, j - 1, s, p) || f(i - 1, j, s, p);
        }
        else if(ch == '?') res = f(i - 1, j - 1, s, p);
        else if(ch == s.charAt(i)) res = f(i - 1, j - 1, s, p);

        dp[i][j] = res ? 1 : -1;
        return res;
    }
}