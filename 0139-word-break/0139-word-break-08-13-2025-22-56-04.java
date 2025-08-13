class Solution {
    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        // Collections.sort(wordDict, (a, b) -> Integer.compare(b.length(), a.length()));
        return helper(s, wordDict, 0);
    }
    boolean helper(String s, List<String> dict, int start){
        if(start == s.length()) return true;
        if(start > s.length()) return false;
        for(String x : dict){
            boolean res = false;
            String val = "" + start + " " + x;
            if(set.contains(val)) continue;
            String temp = s.substring(start);
            if(temp.startsWith(x)){
                res = res || helper(s, dict, start + x.length());
            }
            if(res) return true;
            set.add(val);
        }
        return false;
    }
}