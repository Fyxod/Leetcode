class Solution {
    int p;
    int u;
    int v;
    int max;
    public boolean carPooling(int[][] trips, int capacity) {
        max = 0;
        for(int trip[] : trips){
            max = Math.max(max, trip[2]);
        }
        int loc[] = new int[max + 1];
        for(int trip[] : trips){
            p = trip[0];
            u = trip[1];
            v = trip[2];
            loc[u] += p;
            loc[v] += -p;
        }

        p = 0;
        for(int i = 0; i <= max; i++){
            p += loc[i];
            if(p > capacity) return false;
        }

        return true;
    }
}