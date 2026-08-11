class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int first = -1, second = -1;
        int ind1 = -1, ind2 = -1;

        int l = 0, r = 0, max = 0;
        while(r < n){
            int el = fruits[r];
            if(first != el && second != el){
                if(first == -1){
                    first = el;
                    ind1 = r;
                }
                else if(second == -1){
                    second = el;
                    ind2 = r;
                }
                else{
                    if(ind1 < ind2){
                        l = ind1 + 1;
                        ind1 = ind2;
                        first = second;
                    }
                    else{
                        l = ind2 + 1;
                    }
                    second = el;
                    ind2 = r;
                }
            }
            if(first == el) ind1 = r;
            else ind2 = r;
            r++;
            max = Math.max(max, r - l);
        }

        return max;
    }
}