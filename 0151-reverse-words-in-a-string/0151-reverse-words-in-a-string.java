class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder ans = new StringBuilder();
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != ' ') temp.append(arr[i]);

            if(arr[i] == ' ' && arr[i - 1] != ' '){
                temp.append(' ');
                stack.push(temp);
                temp = new StringBuilder();
            }

            if(i == arr.length - 1){
                temp.append(' ');
                stack.push(temp);
            }
        }

        int size = stack.size();
        for(int i = 0; i < size; i++){
            ans = ans.append(stack.pop());
        }
        return ans.toString().trim();
    }
}