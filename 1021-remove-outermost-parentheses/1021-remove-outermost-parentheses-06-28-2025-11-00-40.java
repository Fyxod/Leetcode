class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int count = 0;
        for(char a : s.toCharArray()){
            if(a == '('){
                if(count != 0){
                    ans = ans + a;
                }
                count++;
            }
            else{
                count--;
                if(count == 0) continue;
                ans = ans + a;
            }
        }
        return ans;
    }
}