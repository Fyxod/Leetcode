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
            boolean flag = false;
            intervals++;
            int max = 0;
            for(Map.Entry<Character, int[]> entry: map.entrySet()){
                int[] task = entry.getValue();
                if((task[1] == -1 || intervals - task[1] > n) && task[0] > max){
                    max = task[0];
                    save = entry;
                    flag = true;
                }
            }
            if(flag){
                int[] task = save.getValue();
                task[0]--;
                if(task[0] == 0) map.remove(save.getKey());
                else task[1] = intervals;
            }
        }
        return intervals;
    }
}