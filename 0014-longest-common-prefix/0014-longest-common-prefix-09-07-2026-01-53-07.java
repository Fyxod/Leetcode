class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];

        for(int i = 1; i < strs.length; i++){
            int j1 = 0, j2 = 0;
            String str = strs[i];

            while(j1 < pre.length() && j2 < str.length()){
                if(pre.charAt(j1) != str.charAt(j2)) break;
                j1++; j2++;
            }
            pre = pre.substring(0, j1);
        }

        return pre;
    }
}