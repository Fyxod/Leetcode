class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        list.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int top[] = list.get(list.size() - 1);
            if(top[1] < intervals[i][0]){
                list.add(intervals[i]);
            }
            else{
                top[0] = Math.min(top[0], intervals[i][0]);
                top[1] = Math.max(top[1], intervals[i][1]);
            }
        }

        int size = list.size();
        return list.toArray(new int[0][]);
    }
}