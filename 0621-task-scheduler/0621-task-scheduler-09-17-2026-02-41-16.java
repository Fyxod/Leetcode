class Solution {
    public int leastInterval(char[] tasks, int n) {
        int k = tasks.length;

        int freq[] = new int[26];
        for(char task : tasks) freq[(int)(task - 'A')]++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq) if(f > 0) pq.offer(f);

        int time = 0;
        while(!pq.isEmpty()){
            int slots = n + 1;

            List<Integer> temp = new ArrayList<>();
            while(slots > 0 && !pq.isEmpty()){
                int f = pq.poll();
                f--;

                time++;
                slots--;
                if(f > 0) temp.add(f);
            }

            for(int f : temp) pq.offer(f);
            if(!pq.isEmpty()) time += slots;
        }

        return time;
    }
}