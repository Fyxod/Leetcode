class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else{
                if(stack.isEmpty() || map.get(ch) != stack.peek()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}