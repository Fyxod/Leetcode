class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(char ch: tasks){
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;

        for(int i = 24; i >= 0 && idleSlots > 0; i--){
            idleSlots -= Math.min(freq[i], maxFreq - 1);
        }
        idleSlots = Math.max(idleSlots, 0);
        return idleSlots + tasks.length;
    }
}