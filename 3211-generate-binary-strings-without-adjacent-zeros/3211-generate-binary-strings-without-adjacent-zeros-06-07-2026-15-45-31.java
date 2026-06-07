class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(list, sb, 1, n);
        return list;
    }
    void helper(List<String> list, StringBuilder sb, int last, int n){
        if(n == 0){
            list.add(sb.toString());
            return;
        }
        sb.append("1");
        helper(list, sb, 1, n - 1);
        sb.deleteCharAt(sb.length() - 1);
        if(last == 1){
            sb.append("0");
            helper(list, sb, 0, n - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}