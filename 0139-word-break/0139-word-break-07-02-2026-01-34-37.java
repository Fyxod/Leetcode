class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> dict) {
        Collections.sort(dict, Collections.reverseOrder());
        return helper(s, dict, 0);
    }
    boolean helper(String s, List<String> dict, int pos){
        if(pos == s.length()) return true;
        
        for(String a : dict){
            if(!set.contains(pos + a.length()) &&
                pos + a.length() <= s.length() &&
                s.startsWith(a, pos) &&
                helper(s, dict, pos + a.length()))
                return true;
        }
        set.add(pos);
        return false;
    }
}