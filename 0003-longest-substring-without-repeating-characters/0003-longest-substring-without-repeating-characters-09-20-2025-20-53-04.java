class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int curr = 0;
        int start = 0, end = 0;
        while(start < n && end < n){
            char ch = s.charAt(end);
            while(set.contains(ch) && start < end){
                set.remove(s.charAt(start));
                start++;
                curr--;
            }
            set.add(ch);
            end++;
            curr++;
            max = Math.max(curr, max);
        }
        return max;
    }
}