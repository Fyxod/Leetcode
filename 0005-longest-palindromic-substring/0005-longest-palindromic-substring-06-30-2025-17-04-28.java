class Solution {
    public String longestPalindrome(String s) {
        if(isPal(s)) return s;

        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPal(s.substring(i, j + 1)) && (j - i) > (end - start)){
                    start = i; end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    boolean isPal(String s){
        int start = 0, end = s.length() - 1;

        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}