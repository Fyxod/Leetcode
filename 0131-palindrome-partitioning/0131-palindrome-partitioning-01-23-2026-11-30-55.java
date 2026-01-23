class Solution {
    int n;
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        n = s.length();
        f(s, 0, ans, new ArrayList<>());
        return ans;
    }
    void f(String s, int start, List<List<String>> ans, List<String> list){
        if(start == n){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < n; i++){
            if(isPal(s, start, i)){
                list.add(s.substring(start, i + 1));
                f(s, i + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPal(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}