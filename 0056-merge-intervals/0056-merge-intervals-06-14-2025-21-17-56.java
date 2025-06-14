class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(list.isEmpty() || intervals[i][0] > list.get(list.size() - 1)[1]){
                list.add(intervals[i]);
            }
            else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[0][]);
    }
}


















// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         int start = intervals[0][0];
//         int end = intervals[0][1];
//         List<int[]> list = new ArrayList<>();

//         for(int i = 1; i < intervals.length; i++){

//             if(currStart <= end){
//                 end = Math.max(end, currEnd);
//             }
//             else {
//                 list.add(new int[]{start, end});
//                 start = currStart;
//                 end = currEnd;
//             }
//         }
//         list.add(new int[]{start, end});

//         int arr[][] = list.toArray(new int[0][]);
//         return arr;
//     }
// }