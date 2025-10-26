class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, int[]> map = new HashMap<>();
        int intervals = 0;

        for(char ch : tasks){
            if(map.get(ch) == null){
                map.put(ch, new int[]{1, -1});
            }
            else{
                map.get(ch)[0]++;
            }
        }

        while(!map.isEmpty()){
            Map.Entry<Character, int[]> save = null;
            boolean flag = true;
            intervals++;
            int max = 0;
            for(Map.Entry<Character, int[]> entry: map.entrySet()){
                int[] task = entry.getValue();
                if(task[1] == -1){
                    task[0]--;
                    if(task[0] == 0) map.remove(entry.getKey());
                    else task[1] = intervals;
                    flag = false;
                    break;
                }
                else if(intervals - task[1] > max){
                    max = intervals - task[1];
                    save = entry;
                }
            }
            if(flag && max > n){
                int[] task = save.getValue();
                task[0]--;
                if(task[0] == 0) map.remove(save.getKey());
                else task[1] = intervals;
            }
        }
        return intervals;
    }
}