class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, new ArrayList<>(), 0);
        return ans;
    }
    void helper(String s, List<List<String>> ans, List<String> curr, int start){
        if(start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            if(isPal(s, start, end)){
                curr.add(s.substring(start, end + 1));
                helper(s, ans, curr, end + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    boolean isPal(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}