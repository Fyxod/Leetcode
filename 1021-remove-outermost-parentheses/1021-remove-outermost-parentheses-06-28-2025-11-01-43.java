class Solution {
    public String removeOuterParentheses(String s) {
        // String ans = "";
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(char a : s.toCharArray()){
            if(a == '('){
                if(count != 0){
                    ans.append(String.valueOf(a));
                }
                count++;
            }
            else{
                count--;
                if(count == 0) continue;
                ans.append(String.valueOf(a));
            }
        }
        return ans.toString();
    }
}