class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, ch);

            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}