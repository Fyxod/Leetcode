class Solution {
    public int minBitFlips(int start, int goal) {
        int check = start ^ goal;
        int count = 0;
        while(check > 0){
            check = check & check - 1;
            count++;
        }
        return count;
    }
}