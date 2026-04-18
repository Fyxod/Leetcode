class Solution {
    public int[][] insert(int[][] intervals, int[] I) {
        List<int[]> list = new ArrayList<>();
        for(int slot[] : intervals){
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
        return list.toArray(new int[0][]);
    }
}