class LRUCache {
    int capacity;
    DoubleListNode head;
    DoubleListNode tail;
    Map<Integer, DoubleListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleListNode(-1, -1);
        tail = new DoubleListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DoubleListNode oldNode = map.get(key);
            remove(oldNode);
        }
        DoubleListNode newNode = new DoubleListNode(key, value);
        add(newNode);
        map.put(key, newNode);

        if(map.size() > capacity) {
            DoubleListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    public void remove(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(DoubleListNode node) {
        DoubleListNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

}

class DoubleListNode {
    DoubleListNode next;
    DoubleListNode prev;
    int key;
    int value;

    public DoubleListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */