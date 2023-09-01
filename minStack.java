class MinStack {
        
    class Node {
        int value;
        Node prev;
        int min;

        public Node(int val, Node prev, int min){
            this.value = val;
            this.prev = prev;
            this.min = min;
        }
    }

    private Node head;

    public MinStack() {        
        this.head = null;
    }
    
    public void push(int val) {
        if (head == null){
            head = new Node(val, null, val);
        }
        else{
            head = new Node(val, head, Math.min(head.min, val));
        }
    }
    
    public void pop() {
        head = head.prev;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 * 
 * https://leetcode.com/problems/min-stack/
 */