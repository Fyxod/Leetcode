class Solution {
    public String largestOddNumber(String num) {
        // if(Long.parseLong(num) % 2 != 0) return num;

        int i = num.length() - 1;

        while(i >= 0 && (num.charAt(i) - '0') % 2 == 0) i--;
        if(i >= 0) return num.substring(0, i + 1);
        return "";
    }
}