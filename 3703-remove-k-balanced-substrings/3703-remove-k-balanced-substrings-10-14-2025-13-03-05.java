class Pair{
    char ch;
    int count;

    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeSubstring(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peek().ch == c){
                stack.peek().count++;
            }
            else{
                stack.push(new Pair(c, 1));
            }

            if(stack.size() >= 2){
                Pair first = stack.pop();
                Pair second = stack.pop();

                if(first.ch == ')' && second.ch == '(' && first.count == k && second.count >= k){
                    second.count -= k;
                    if(second.count > 0) stack.push(second);
                }
                else{
                    stack.push(second);
                    stack.push(first);
                }
            }
        }

        StringBuilder str = new StringBuilder();

        while(!stack.isEmpty()){
            Pair el = stack.pop();
            str.append(String.valueOf(el.ch).repeat(el.count));
        }
        return str.reverse().toString();
    }
}