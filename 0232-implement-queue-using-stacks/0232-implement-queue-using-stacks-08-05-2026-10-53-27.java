class MyQueue {

    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        moveElements();
        return s2.pop();
    }
    
    public int peek() {
        moveElements();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    void moveElements(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()) s2.push(s1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */