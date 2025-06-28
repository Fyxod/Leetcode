class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int index = 0;
            while(index < strs[i].length() && index < prefix.length()
             && strs[i].charAt(index) == prefix.charAt(index)){
                index++;
            }
            prefix = prefix.substring(0, index);
            if(prefix.isEmpty()) return "";
        }

        return prefix;
    }
}