class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else if(
            stack.peek() != null &&

(            (ch == ')' && stack.peek() == '(') || 
            (ch == ']' && stack.peek() == '[') || 
            (ch == '}' && stack.peek() == '{'))
            ) 
                stack.pop();
            else return false;
        }
        if(stack.size() != 0) return false;
        return true;
    }
}