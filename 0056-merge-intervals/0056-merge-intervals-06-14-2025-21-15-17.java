class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart <= end){
                end = Math.max(end, currEnd);
            }
            else if(currStart > end){
                list.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        list.add(new int[]{start, end});

        int arr[][] = list.toArray(new int[0][]);
        return arr;
    }
}