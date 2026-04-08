class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for(int a : bills){
            if(a == 5) fives++;
            else if(a == 10){
                if(fives == 0) return false;
                fives--;
                tens++;
            }
            else{
                if(fives >= 1 && tens >= 1){
                    tens--;
                    fives--;
                }
                else if(fives >= 3){
                    fives -= 3;
                }
                else return false;
            }
        }

        return true;
    }
}