// brute force
class Solution {
    public boolean isPal(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int size = s.length();
        if(isPal(s)) return s;
        int minIndex = 0;
        int maxIndex = 0;
        int max = 0;
        for(int i = 0; i < size; i++){
            for(int j = i; j <= size; j++){
                if(isPal(s.substring(i,j)) && max < j-i+1){
                    max = j - i + 1;
                    minIndex = i;
                    maxIndex = j;
                }
            }
        }
        return s.substring(minIndex,maxIndex);
    }
}