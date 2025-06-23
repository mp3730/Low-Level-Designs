package LRUCache.Model;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private Map<Integer, Node> cache;
    private Node headNode;
    private Node tailNode;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.headNode = new Node(-1,-1);
        this.tailNode = new Node(-1,-1);
        headNode.setNextNode(tailNode);
        tailNode.setPrevNode(headNode);
    }

    public synchronized int getNode(int key){
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.getValue();
        }
    }

    public synchronized void putNode(int key, int value){
        if(cache.containsKey(key)){
            cache.get(key).setValue(value);
            addToHead(cache.get(key));
        }else{
            Node node = new Node(key,value);
            cache.put(key, node);
            addToHead(node);

            if(cache.size() > capacity){
                Node removed = removeTail();
                cache.remove(removed.getKey());
            }
        }
    }

    public void addToHead(Node node){
        node.setNextNode(headNode.getNextNode());
        node.setPrevNode(headNode);
        headNode.setNextNode(node);
        headNode.getNextNode().setPrevNode(node);
    }

    public void removeNode(Node node) {
        int key = node.getKey();
        cache.remove(key);

        if (node.getPrevNode() != null) {
            node.getPrevNode().setNextNode(node.getNextNode());
        }
        if (node.getNextNode() != null) {
            node.getNextNode().setPrevNode(node.getPrevNode());
        }
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public Node removeTail(){
        Node lastNode = tailNode.getPrevNode();
        removeNode(lastNode);
        return lastNode;
    }
}
