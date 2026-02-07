class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(cnt != 0) sb.append(ch);
                cnt++;
            }
            else if(ch == ')'){
                if(cnt != 1) sb.append(ch);
                cnt--;
            }
        }

        return sb.toString();
    }
}