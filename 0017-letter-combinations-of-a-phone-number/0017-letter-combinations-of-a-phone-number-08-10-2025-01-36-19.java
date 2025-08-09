class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        String letters[][] = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
        };
        List<String> ans = new ArrayList<>();
        helper(digits, letters, ans, new StringBuilder(), 0);
        return ans;
    }
    void helper(String digits, String letters[][], List<String> ans, StringBuilder curr, int idx){
        if(curr.length() == digits.length()){
            ans.add(curr.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        for(int i = 0; i < letters[digit - 2].length; i++){
            curr.append(letters[digit - 2][i]);
            helper(digits, letters, ans, curr, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}