class Solution {
    public int beautySum(String s) {
        StringBuilder str = new StringBuilder(s);
        int size = str.length();
        int ans = 0;
        for(int i = 0; i < size; i++){
            int freq[] = new int[26];
            int minIndex = s.charAt(i)- 'a';
            boolean same = true;
            for(int j = i; j < size; j++){
                int index = str.charAt(j) - 'a';
                freq[index]++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){
                    max = Math.max(freq[k], max);
                    if(min > freq[k] && freq[k] != 0){
                        min = freq[k];
                    }
                }
                ans = ans + max - min;
            }
        }
        return ans;
    }
}