class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            System.out.println(words[i].length());
            for(int j = 0; j < i; j++){
                if(words[i].length() == words[j].length() + 1 && check(words[j], words[i]) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    boolean check(String a, String b){
        int miss = 0;
        int n = a.length();
        int i = 0, j = 0;
        while(i < n){
            if(a.charAt(i) != b.charAt(j)){
                if(miss == 1) return false;
                miss++;
                i--;
            }
            j++;
            i++;
        }

        return miss <= 1;
    }
}