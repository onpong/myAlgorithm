/**
 * 方法1，比较慢
 */
class LRUCache {
    private HashMap<Integer,Integer> hash;
    private LinkedList<Integer> queue;
    int size;
    public LRUCache(int capacity) {
        hash = new HashMap<>();
        queue = new LinkedList<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Integer i = key;
            queue.remove(i);
            queue.addFirst(key);
            return hash.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //如果存在
        if(hash.containsKey(key)){
            hash.put(key,value);
            Integer i = key;
            queue.remove(i);
            queue.addFirst(key);

        }else{
            if(hash.size() == size){
                int temp = queue.pollLast();
                hash.remove(temp);
            }
            queue.addFirst(key);
            hash.put(key,value);
            
        }
        //如果不存在
            //如果满了
            //如果没满
    }
}
/**
 * 方法2
 */


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    private class Node {
        Node prev, next;
        int key, value;

        private Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private class DoubleList {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size;

        private DoubleList() {
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        private void addFirst(Node n) {
            Node headNext = head.next;
            head.next = n;
            headNext.prev = n;
            n.prev = head;
            n.next = headNext;
            size++;
        }

        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }

        private Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        private int size() {
            return size;
        }

    }

    // key -> Node(key, val)
    private Map<Integer, Node> map;
    // node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value; // 利⽤ put ⽅法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(n);
            map.put(key, n);
        } else {
            if (cache.size() == capacity) {
                // delete last element in list
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(n);
            map.put(key, n);
        }
    }
}