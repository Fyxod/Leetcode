class Solution {
    public boolean parseBoolExpr(String e) {
        Deque<Character> stack = new ArrayDeque<>();

        int n = e.length();
        for(int i = 0; i < n; i++){
            if(e.charAt(i) == ')'){
                List<Character> list = new ArrayList<>();
                while(stack.peek() != '('){
                    char temp = stack.pop();
                    if(temp == ',') continue;
                    list.add(temp);
                }
                stack.pop();
                char op = stack.pop();
                if(list.size() == 0) continue;
                boolean res = list.get(0) == 't';

                if(op == '!'){
                    stack.push(!res ? 't' : 'f');
                    continue;
                }
                System.out.println(res);
                for(char ch : list){
                    System.out.println(ch);
                    if(op == '&') res = res && ch == 't';
                    else res = res || ch == 't';
                }
                System.out.println(res);
                stack.push(res? 't' : 'f');
            }
            else stack.push(e.charAt(i));
        }
        System.out.println(stack.size());
        return stack.pop() == 't';
    }
}