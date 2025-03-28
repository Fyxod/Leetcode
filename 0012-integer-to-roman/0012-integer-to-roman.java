class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, Character> map = new LinkedHashMap<>();
        map.put(1000, 'M');
        map.put(500, 'D');
        map.put(100, 'C');
        map.put(50, 'L');
        map.put(10, 'X');
        map.put(5, 'V');
        map.put(1, 'I');
        while (num > 0) {
            int length = Integer.toString(num).length();
            int firstDigit = num / (int)Math.pow(10, (length - 1));
                if(firstDigit == 4){
                    int factor = (int)Math.pow(10, length - 1);
                    char first = map.get(factor);
                    char second = map.get(factor * 5);
                    ans.append(first).append(second);
                    num = num - firstDigit * factor;
                }
                else if(firstDigit == 9){
                    int factor = (int)Math.pow(10, length - 1);
                    char first = map.get(factor);
                    char second = map.get(factor * 10);
                    ans.append(first).append(second);
                    num = num - firstDigit * factor;
                }
                else {
                    int divisor = 1;
                    for (int i : map.keySet()) {
                            if ((int)(firstDigit * Math.pow(10, length - 1)) / i != 0) {
                                divisor = i;
                                break;
                            }
                    }
                int minus = num / divisor;
                num = num - minus*divisor;
                ans.append(String.valueOf(map.get(divisor)).repeat(minus));
                }

            }
        return ans.toString();
}
}