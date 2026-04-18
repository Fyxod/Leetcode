class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int I[] = intervals[0];
        int cnt = 0;
        for(int i = 1; i < n; i++){
            int slot[] = intervals[i];
            if(I[1] <= slot[0]){
                I = slot;
            }
            else{
                cnt++;
            }
        }

        return cnt;
    }
}