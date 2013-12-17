import java.util.Hashtable;

class LRUNode{
    int key;
    int value;
    LRUNode prev;
    LRUNode next;
    public LRUNode(int k,int v){
        key = k;
        value = v;
        prev = null;
        next = null;
    }
    
    public LRUNode(){
        prev = null;
        next = null;
    }
}

public class LRUCache{
    Hashtable<Integer,LRUNode> h_LRUCatch;
    int currentCap,limitCap;
    LRUNode head,tail;
    
    public LRUCache(int capacity) {
        h_LRUCatch = new Hashtable<Integer,LRUNode>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        limitCap = capacity;
        currentCap = 0;
    }
    
    public int get(int key) {
        Integer k = new Integer(key);
        LRUNode tmpn = h_LRUCatch.get(k);
        if(tmpn==null){
            return -1;
        }
        else{
            detachNode(tmpn);
            addToHead(tmpn);
            return tmpn.value;
        }
    }
    
    public void set(int key, int value) {
        Integer k = new Integer(key);
        LRUNode tmpn = h_LRUCatch.get(k);
        LRUNode t;
        if(tmpn==null){
            if(currentCap >= limitCap){
                t = tail.prev;
                detachNode(t);
                h_LRUCatch.remove(t.key);
            }
            else{
                t = new LRUNode(key,value);
                currentCap++;
            }
            t.key = key;
            t.value = value;
            addToHead(t);
            h_LRUCatch.put(k,t);
        }
        else{
            tmpn.value = value;
            detachNode(tmpn);
            addToHead(tmpn);
        }
    }
    
    public void detachNode(LRUNode n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public void addToHead(LRUNode n){
        n.prev = head;
        n.next = head.next;
        head.next = n;
        n.next.prev = n;
    }
}
