class Solution {
    public int totalFruit(int[] fruits) {
        int first = -1, second = -1, l = 0, r = 0, max = 0, firstCount = 0, secondCount = 0;
        while(r < fruits.length){
            int fruit = fruits[r];
            if(fruit != first && fruit != second){
                if(first == -1) first = fruit;
                else if(second == -1) second = fruit;
                else{
                    while(firstCount != 0 && secondCount != 0){
                        if(fruits[l] == first) firstCount--;
                        if(fruits[l] == second) secondCount--;
                        l++;
                    }
                    if(firstCount == 0) first = fruit;
                    else if(secondCount == 0) second = fruit;
                }
            }

            if(fruit == first) firstCount++;
            else if(fruit == second) secondCount++;

            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }
}