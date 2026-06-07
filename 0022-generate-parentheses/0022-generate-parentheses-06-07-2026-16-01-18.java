class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(list, sb, n, n);
        return list;
    }
    void helper(List<String> list, StringBuilder sb, int left, int right){
        if(left == 0 && right == 0){
            list.add(sb.toString());
            return;
        }

        if(left > 0){
            sb.append('(');
            helper(list, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > left){
            sb.append(')');
            helper(list, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}