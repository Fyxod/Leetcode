class Solution {
    public String reverseWords(String s) {
        char charArray[] = s.trim().toCharArray();
        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for(int i = charArray.length - 1; i >= 0; i--){
            if(charArray[i] == ' '){
                if(!word.toString().trim().isEmpty()){
                    ans.append(word + " ");
                }
                word.setLength(0);
            }
            else{
                word.insert(0, charArray[i]);
            }
        }
        ans.append(word);
        return ans.toString().trim();
    }
}