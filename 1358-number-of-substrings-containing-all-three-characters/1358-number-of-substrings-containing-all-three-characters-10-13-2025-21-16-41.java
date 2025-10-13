class Solution {
    public int numberOfSubstrings(String s) {
        int none = 0;
        int count[] = new int[3];
        int l = 0, r = 0;
        int length = s.length();
        while(r < length){
            char ch = s.charAt(r);
            count[ch - 'a']++;

            while(checkAll(count)){
                count[s.charAt(l) - 'a']--;
                l++;
            }
            none += r - l + 1;
            r++;
        }
        long all = (long)length * (length + 1) / 2;
        return (int)(all - none);
    }
    boolean checkAll(int count[]){
        for(int a : count){
            if(a == 0) return false;
        }
        return true;
    }
}