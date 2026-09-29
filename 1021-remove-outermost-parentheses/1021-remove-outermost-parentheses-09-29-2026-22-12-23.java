class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                cnt++;
                if(cnt != 1) sb.append(ch);
            }
            else {
                cnt--;
                if(cnt != 0) sb.append(ch);
            }
        }

        return sb.toString();
    }
}