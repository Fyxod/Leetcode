class Solution {
    public int takeCharacters(String s, int k) {
        if(k * 3 > s.length()) return -1;
        int arr[] = new int[3];
        int n = s.length();
        for(int i = 0; i < n; i++) arr[s.charAt(i) - 'a']++;
        if(!check(arr, k)) return -1;
        
        int max = 0;
        int i = 0, j = 0;
        while(j < n){
            arr[s.charAt(j) - 'a']--;
            while(!check(arr, k)){
                arr[s.charAt(i++) - 'a']++;
            }
            max = Math.max(max, j++ - i + 1);
        }

        return n - max;
    }
    boolean check(int arr[], int k){
        for(int a : arr) if(a < k) return false;
        return true;
    }
}