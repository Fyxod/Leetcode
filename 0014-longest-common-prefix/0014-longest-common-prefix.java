class Solution {
    public String longestCommonPrefix(String[] strs) {
        // jsurt checking again
        String ans = "";
        int minIndex = 0;
        int size = strs.length;
        int minLength = strs[0].length();
        for (int i = 1; i < size; i++) {
            if (minLength > strs[i].length()) {
                minLength = strs[i].length();
                minIndex = i;
            }
        }
        String check = strs[minIndex];
        while(check.length() > 0){
            boolean flag = true;
            for(int j = 0; j < strs.length; j++){
                if(j == minIndex) continue;
                if(!(strs[j].startsWith(check))){
                    flag = false;
                    break;
                }
                
            }
            if(flag){
                ans = check;
                break;
            }
            check = check.substring(0, check.length() - 1);
        }
        return ans;
    }
}