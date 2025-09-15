class StockSpanner {
    List<Integer> list;
    Deque<Integer> stack;
    public StockSpanner() {
        list = new ArrayList<>();
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        list.add(price);
        int idx = list.size() - 1;
        while(!stack.isEmpty() && list.get(stack.peek()) <= price) stack.pop();
        int span = 1;
        if(idx == 0){
            stack.push(idx);
            return span;
        }
        if(stack.isEmpty()){
            span += idx;
        }
        else span += idx - stack.peek() - 1;
        stack.push(idx);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
