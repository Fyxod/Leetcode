class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int max = 0;
        int l = 0, r = 0;
        int count = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            int largest = getLargest(arr);
            if(r == 0 || arr[largest] == ch || different(arr, largest) < k){
                
            }
            else{
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            arr[ch - 'A']++;
            largest = getLargest(arr);
            r++;
            if(different(arr, largest) <= k){
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
    int getLargest(int[] arr){
        int max = 0;
        int index = -1;
        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                index = i;
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