class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];

        int l = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int r = 0; r < n; r++){
            int ind = s.charAt(r) - 'A';
            freq[ind]++;
            maxFreq = Math.max(maxFreq, freq[ind]);

            while((r - l + 1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            if((r - l + 1) - maxFreq <= k) maxLen = Math.max(r - l + 1, maxLen);
        }

        return maxLen;
    }
}