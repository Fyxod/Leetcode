class Solution {

    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        StringBuilder s = new StringBuilder(num);
        while(i >= 0){
            if((Integer.parseInt(s.charAt(i) + "") % 2 == 0))
                i--;
            else
                break;
        }
        return num.substring(0, i + 1);
    }
}