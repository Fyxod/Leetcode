class Solution {
    public String longestCommonPrefix(String[] strs) {
        // int max = 0;
        // String smallest;
        // int min = Integer.MAX_VALUE;
        // for(String a : strs){
        //     if(a.length < min){
        //         min = a.length;
        //         smallest = a;
        //     }
        // }

        // for(String)

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int index = 0;
            while(index < strs[i].length() && index < prefix.length()
             && strs[i].charAt(index) == prefix.charAt(index)){
                index++;
            }
            prefix = prefix.substring(0, index);
        }

        return prefix;
    }
}