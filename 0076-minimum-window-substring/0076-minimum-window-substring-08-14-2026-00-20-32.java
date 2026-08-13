class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int l = 0;
        for(int i = 0; i < m; i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        int unique = map.size();

        int min = Integer.MAX_VALUE;
        String ans = "";

        for(int r = 0; r < n; r++){
            char ch = s.charAt(r);
            if(!map.containsKey(ch)) continue;

            int freq = map.get(ch);
            freq--;
            if(freq == 0) cnt++;
            map.put(ch, freq);
            if(cnt == unique){
                char temp = s.charAt(l);
                while(!map.containsKey(temp) || map.get(temp) < 0){
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp) + 1);
                    }
                    temp = s.charAt(++l);
                }
                if(min > r - l + 1){
                    min = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
            }
        }

        return ans;
    }
}