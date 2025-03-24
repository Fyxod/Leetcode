class Solution {

    public String largestOddNumber(String num) {
        char[] arr = num.toCharArray();
        int i = arr.length - 1;
        while(i >= 0){
            if((Integer.parseInt(arr[i] + "") % 2 == 0))
                i--;
            else
                break;
        }
        return num.substring(0, i + 1);
    }
}