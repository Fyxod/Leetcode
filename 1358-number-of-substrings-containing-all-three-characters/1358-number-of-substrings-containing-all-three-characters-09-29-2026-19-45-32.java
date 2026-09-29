class Solution {
    public int numberOfSubstrings(String s) {
        int last[] = new int[3];
        Arrays.fill(last, -1);

        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
            int min = Math.min(last[0], Math.min(last[1], last[2]));
            cnt += min + 1;
        }

        return cnt;
    }
}