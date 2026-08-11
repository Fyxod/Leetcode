class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while(r < n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(l < r && map.get(ch) > 1){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
            max = Math.max(max, r - l);
        }

        return max;
    }
}