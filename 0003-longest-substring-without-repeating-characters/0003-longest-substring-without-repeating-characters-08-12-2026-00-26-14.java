class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch) >= l) {
                max = Math.max(max, r - l);
                l = map.get(ch) + 1;
            }
            else map.remove(ch);
            map.put(ch, r++);
            max = Math.max(max, r - l);
        }

        return max;
    }
}