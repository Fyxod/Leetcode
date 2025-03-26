class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        heap.addAll(map.entrySet());

        while(!heap.isEmpty()){
            Map.Entry<Character, Integer> entry = heap.poll();
            ans.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return ans.toString();
    }
}


// class Solution {
//     public String frequencySort(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         StringBuilder ans = new StringBuilder();
//         int size = s.length();
//         for(int i = 0; i < size; i++){
//             char ch = s.charAt(i);
//             map.putIfAbsent(ch, 0);
//             map.put(ch, map.get(ch) + 1);
//         }
//         Map<Integer, ArrayList<Character>> freq = new TreeMap<>();
//         for(char a: map.keySet()){
//             freq.putIfAbsent(map.get(a), new ArrayList<Character>());
//             freq.get(map.get(a)).add(a);
//         }

//         for(int a: freq.keySet()){
//             for(char ch: freq.get(a)){
//                 ans.insert(0, String.valueOf(ch).repeat(a));
//             }
//         }
//         return ans.toString();
//     }
// }