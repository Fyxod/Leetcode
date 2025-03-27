class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        int size = s.length();
        int sum = 0;

        if(map.get(s.charAt(1)) <= map.get(s.charAt(0)) ){
            sum += map.get(s.charAt(0));
        }

        for(int i = 1; i < size; i++){
            int current = map.get(s.charAt(i));
            int left = map.get(s.charAt(i - 1));
            int right = 0;
            if(i != size - 1)
            right = map.get(s.charAt(i + 1));
            if(current > left){
                sum += current - left;
            }
            else if(current <= left && current >= right){
                sum += current;
            }
        }
        return sum;
    }
}