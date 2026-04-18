class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int I[] = intervals[0];
        for(int i = 1; i < n; i++){
            int slot[] = intervals[i];
            if(I[1] < slot[0]){
                list.add(I);
                I = slot;
            }
            else if(I[0] > slot[1]){
                list.add(slot);
            }
            else{
                I[0] = Math.min(I[0], slot[0]);
                I[1] = Math.max(I[1], slot[1]);
            }
        }
        list.add(I);

        return list.toArray(new int[list.size()][]);
    }
}