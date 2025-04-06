// brute force
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int i = 0;

        int size1 = g.length;
        int size2 = s.length;
        while(content < size1 && i < size2){
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