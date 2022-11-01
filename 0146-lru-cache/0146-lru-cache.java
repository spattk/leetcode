class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        
        node.prev = head;
        head.next = node;
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(Node node) {
        this.remove(node);
        this.addFirst(node);
    }
    
    private int popTail() {
        Node prev = tail.prev;
        this.remove(prev);
        return prev.key;
    }
    
    
    Map<Integer, Node> map;
    int capacity;
    int count;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        //dummy
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        // System.out.println("get" + map);
        if(map.get(key) != null){
            Node node = map.get(key);
            //remove and put it at the front as well
            moveToHead(node);
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        // System.out.println("put" + map);
        Node node = map.get(key);
        //not found
        if(node == null){
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            this.addFirst(newNode);
            map.put(key, newNode);
            count++;

            if(count > capacity) {
                int temp = this.popTail();
                map.remove(temp);
                count--;
            }
        } else {
            //found
            node.value = value;
            map.put(key, node);
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */