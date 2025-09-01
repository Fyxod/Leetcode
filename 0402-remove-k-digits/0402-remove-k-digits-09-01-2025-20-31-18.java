class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        int temp = k;
        for(int i = 0; i < num.length(); i++){
            char el = num.charAt(i);
            while(!stack.isEmpty() && temp > 0 && stack.peek() > el) {
                stack.pop();
                temp--;
            }
            stack.push(el);
        }
        while(temp > 0){
            temp--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }
        while(sb.length() != 0 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        if(sb.length() == 0) return "0";
        return sb.reverse().toString();
    }
}