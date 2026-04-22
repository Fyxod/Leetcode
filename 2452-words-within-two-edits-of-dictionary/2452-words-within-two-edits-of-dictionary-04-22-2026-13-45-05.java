class Solution {
    public List<String> twoEditWords(String[] queries, String[] dict) {
        int length = queries[0].length();
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String a : dict){
            set.add(a);
        }

        for(String a : queries){
            for(String b : dict){
                int diff = 0;
                for(int i = 0; i < length; i++){
                    if(a.charAt(i) != b.charAt(i)){
                        diff++;
                        if(diff > 2) break;
                    }
                }
                if(diff <= 2){
                    ans.add(a);
                    break;
                }
            }
        }

        return ans;
    }
}