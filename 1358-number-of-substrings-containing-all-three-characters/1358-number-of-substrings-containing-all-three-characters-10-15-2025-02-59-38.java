class Solution {
    public int numberOfSubstrings(String s) {
        int track[] = {-1, -1, -1};
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            track[ch - 'a'] = i;
            int min = Math.min(track[0], Math.min(track[1], track[2]));

            if(min != -1){
                count += min + 1; 
            }
        }
        return count;
    }
}