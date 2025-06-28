class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder r = new StringBuilder(s);
        int size = r.length();
        for(int i = 0; i < size; i++){
            char temp = r.charAt(size - 1);
            r.deleteCharAt(size - 1);
            r.insert(0, temp);
            if(r.toString().equals(goal)){
                return true;
            }
        }
        return false;
    }

}