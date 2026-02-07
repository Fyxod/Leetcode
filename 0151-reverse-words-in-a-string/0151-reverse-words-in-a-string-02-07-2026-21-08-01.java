class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        StringBuilder temp;
        while(ind < l){
            temp = new StringBuilder();
            while(ind < l && s.charAt(ind) != ' '){
                temp.append(s.charAt(ind++));
            }
            temp.insert(0, ' ');
            sb.insert(0, temp.toString());
            while(ind < l && s.charAt(ind) == ' ') ind++;
        }

        return sb.toString().trim();
    }
}