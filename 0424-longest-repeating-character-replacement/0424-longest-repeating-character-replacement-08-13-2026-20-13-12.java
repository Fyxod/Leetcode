class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];

        int max = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            freq[s.charAt(r) - 'A']++;
            int maxCharFreq = getMaxFreq(freq);
            int len = r - l + 1;
            while(len - maxCharFreq > k){
                freq[s.charAt(l) - 'A']--;
                maxCharFreq = getMaxFreq(freq);
                len--;
                l++;
            }
            max = Math.max(max, len);
        }

        return max;
    }
    int getMaxFreq(int freq[]){
        int maxCharFreq = 0;
        for(int i = 0; i < 26; i++) maxCharFreq = Math.max(freq[i], maxCharFreq);
        return maxCharFreq;
    }
}