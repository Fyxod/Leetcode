class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3 || arr[0] >= arr[1] || arr[n - 1] >= arr[n - 2]) return false;
        int i = 1;
        while(i < n){
            if(arr[i] == arr[i - 1]) return false;
            if(arr[i] < arr[i - 1]) break;
            i++;
        }
        while(i < n){
            if(arr[i] >= arr[i - 1]) return false;
            i++;
        }
        return true;
    }
}