package LRUCache.Model;

public class Node {
    private int key;
    private int value;
    private Node nextNode;
    private Node prevNode;

    public Node() {
    }
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.nextNode = null;
        this.prevNode = null;
    }

    public int getKey() {
        return key;
    }

    public int getValue(){
        return value;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
