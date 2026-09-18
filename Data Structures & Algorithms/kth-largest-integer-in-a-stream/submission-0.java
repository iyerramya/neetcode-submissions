class KthLargest {
    PriorityQueue<Integer> pq;
    int num;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        this.num = k;
        for(int i : nums) {
            insertIntoPq(i);
        }
    }
    
    public int add(int val) {
        insertIntoPq(val);
        return pq.peek();
    }

    private void insertIntoPq(int val) {
        pq.offer(val);
        if(pq.size() > num) {
            pq.poll();
        }
    }
}
