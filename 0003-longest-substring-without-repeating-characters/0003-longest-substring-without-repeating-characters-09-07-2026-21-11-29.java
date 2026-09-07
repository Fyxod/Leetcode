class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        int l = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= l){
                max = Math.max(i - l, max);
                l = map.get(ch) + 1;
            }
            map.put(ch, i);
        }

        return Math.max(max, n - l);
    }
}