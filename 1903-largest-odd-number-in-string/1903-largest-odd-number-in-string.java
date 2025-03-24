class Solution {

    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while(i >= 0){
            if((Integer.parseInt(num.charAt(i) + "") % 2 == 0))
                i--;
            else
                break;
        }
        return num.substring(0, i + 1);
    }
}