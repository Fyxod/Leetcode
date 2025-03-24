class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        int size = s.length();

        for(int i = 0; i < size; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map.putIfAbsent(ch1, 0);
            map.put(ch1, map.get(ch1) + 1);

            map.putIfAbsent(ch2, 0);
            map.put(ch2, map.get(ch2) - 1);
        }
        for(int a: map.values()){
            if(a != 0) return false;
        }
        return true;
    }
}