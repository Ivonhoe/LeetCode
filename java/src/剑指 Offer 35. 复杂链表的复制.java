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
        Map<Node,Node> map = new HashMap<>();
        
        Node ans = new Node(-1);
        Node q = ans;
        Node p = head;
        while(p!=null){
            q.next = new Node(p.val);
            map.put(p, q.next);
            
            p =p.next;
            q=q.next;
        }
        
        p = head;
        q = ans.next;
        while(p!=null){
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return ans.next;
    }
}