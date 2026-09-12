class MinStack {

    int min = Integer.MAX_VALUE; 
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty() || val < stack.peek()[1]) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, stack.peek()[1]});
        }
    }
    
    public void pop() {
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1]; 
    }
}
