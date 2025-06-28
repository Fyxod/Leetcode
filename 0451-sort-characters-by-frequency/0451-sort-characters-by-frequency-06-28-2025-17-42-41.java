class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());
        for(Map.Entry<Character, Integer> entry : list){
            System.out.println(entry.getKey() + " " + entry.getValue());
            char ch = entry.getKey();
            sb.append(String.valueOf(ch).repeat(entry.getValue()));
        }
        return sb.toString();
    }
}