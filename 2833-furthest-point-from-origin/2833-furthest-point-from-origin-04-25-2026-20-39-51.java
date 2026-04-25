class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int max = 0, min = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                max--;
                min--;
            }
            else if(ch == 'R'){
                max++;
                min++;
            }
            else{
                max++;
                min--;
            }
        }

        return Math.max(-1 * min, max);
    }
}