class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int max = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            arr[ch - 'A']++;
            int largest = getLargest(arr);
            int different = different(arr, largest);
            if(r == 0 || different <= k){
                
            }
            else{
                arr[s.charAt(l) - 'A']--;
                l++;
                largest = getLargest(arr);
                different = different(arr, largest);
            }
            if(different <= k){
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }
    int getLargest(int[] arr){
        int max = 0;
        int index = -1;
        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                index = i;
                max = arr[i];
            }
        }
        return index;
    }
    int different(int arr[], int ch){
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(ch != i) count += arr[i];
        }
        return count;
    }
}