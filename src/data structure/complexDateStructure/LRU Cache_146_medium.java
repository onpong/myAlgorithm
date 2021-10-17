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
                queue.addFirst(key);
                hash.put(key,value);
            }else{
                queue.addFirst(key);
                hash.put(key,value);
            }
        }
        //如果不存在
            //如果满了
            //如果没满
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */