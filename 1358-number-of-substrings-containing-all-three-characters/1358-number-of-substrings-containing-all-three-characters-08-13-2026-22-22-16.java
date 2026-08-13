class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int arr[] = new int[3];
        Arrays.fill(arr, -1);

        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a'] = i;
            int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
            if(min != -1){
                cnt += min + 1;
            }
        }

        return cnt;
    }
}