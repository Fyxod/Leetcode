class Solution {
    public int countArrangement(int n) {
        return f(n, 0, 1);
    }
    int f(int n, int mask, int pos){
        if(pos > n) return 1;

        int res = 0;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            int num = i + 1;
            if(pos % num != 0 && num % pos != 0) continue;
            res += f(n, mask | (1 << i), pos + 1);
        }

        return res;
    }
}