// brute force
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int i = 0;

        while(content < g.length && i < s.length){
            if(s[i] >= g[content]){
                i++;
                content++;
            }
            else{
                i++;
            }
        }
        return content;
    }
}