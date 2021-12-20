/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); 
        Node p = head;
        while(p != null){
            Node temp = new Node(p.val);
            map.put(p,temp);
            p = p.next;
        }
        Node cur = head;
        while(cur != null){
            Node random = cur.random;
            Node next = cur.next;
            Node copy = map.get(cur);
            copy.next = map.get(next);
            copy.random = map.get(random);
            cur = cur.next;
        }
        return map.get(head);

    }
}