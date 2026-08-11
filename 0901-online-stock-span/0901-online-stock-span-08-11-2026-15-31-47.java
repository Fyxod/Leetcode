class StockSpanner {
    Deque<int[]> stack;
    int day;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        day = 0;
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
        int last = stack.isEmpty() ? -1 : stack.peek()[0];
        stack.push(new int[]{day, price});
        return day++ - last;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */