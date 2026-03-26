class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        List<Character>[] arr = new ArrayList[s.length() + 1];
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if(arr[val] == null) arr[val] = new ArrayList<>();
            arr[val].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i >= 0; i--){
            if(arr[i] != null){
                for(char ch : arr[i]){
                    sb.append(String.valueOf(ch).repeat(i));
                }
            }
        }

        return sb.toString();
    }
}