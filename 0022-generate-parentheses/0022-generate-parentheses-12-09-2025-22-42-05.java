class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, 0, 0, new StringBuilder(), n);
        return list;
    }
    void helper(List<String> list, int l, int r, StringBuilder sb, int n){
        if(r > l) return;
        if(l == n && r == n){
            list.add(sb.toString());
            return;
        }
        if(l < n) {
            sb.append("(");
            helper(list, l + 1, r, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(r < n) {
            sb.append(")");
            helper(list, l, r + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}