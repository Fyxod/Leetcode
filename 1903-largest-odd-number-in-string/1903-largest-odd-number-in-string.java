class Solution {
    public boolean isOdd(String a) {
        long n = Long.parseLong(a);
        return n % 2 != 0;
    }

    public String largestOddNumber(String num) {
        if (isOdd(num))
            return num;
        int max = 0;
        char[] arr = num.toCharArray();
        int size = arr.length;
        int i = size - 1;

        StringBuilder temp = new StringBuilder();
        while (i >= 0) {
            if(!isOdd(arr[i] + "")){
                i--;
                continue;
            }

            int j = i;
            while(j >= 0){
                String sub = num.substring(j, i + 1);
                if(isOdd(sub)){
                    max = Integer.max(max, Integer.parseInt(sub));
                }
                j--;
            }
            i--;
        }
        return max == 0? "": String.valueOf(max);
    }
}