class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        TreeMap<Integer, List<Character>> map = new TreeMap<>((a, b) -> b - a);

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, List<Character>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Character> list = entry.getValue();

            for(char ch : list){
                sb.append(String.valueOf(ch).repeat(key));
            } 
        }

        return sb.toString();
    }
}