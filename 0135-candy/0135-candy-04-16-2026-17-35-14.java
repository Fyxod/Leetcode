class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int cand[] = new int[n];
        for(int i = 0; i < n; i++) cand[i] = 1;

        for(int i = 1; i < n; i++){
            if(rating[i] > rating[i - 1]) cand[i] = cand[i - 1] + 1;
        }
        for(int i = n - 2; i >= 0; i--){
            if(rating[i] > rating[i + 1]) cand[i] = Math.max(cand[i + 1] + 1, cand[i]);
        }

        int sum = 0;
        for(int a : cand) sum += a;
        return sum;
    }
}