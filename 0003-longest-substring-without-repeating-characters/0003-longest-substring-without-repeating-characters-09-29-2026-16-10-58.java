class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch) >= l){
                max = Math.max(max, r - l);
                l = map.get(ch) + 1;
            }
            map.put(ch, r);
        }

        return Math.max(max, s.length() - l);
    }
}