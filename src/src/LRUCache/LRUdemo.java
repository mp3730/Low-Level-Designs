package LRUCache;

import LRUCache.Model.LRUCache;
import LRUCache.Model.Node;

public class LRUdemo {
    public void run(){
        LRUCache lruCache = new LRUCache(2);

        lruCache.putNode(1,12);
        lruCache.putNode(2,21);
        lruCache.putNode(3,32);

        System.out.println("Value of 1:" + lruCache.getNode(1));
        System.out.println("Value of 3:" + lruCache.getNode(3));

        lruCache.putNode(4,43);
        lruCache.putNode(3,39);

        System.out.println("Value of 2:" + lruCache.getNode(2));
        System.out.println("Updated Value of 3:" + lruCache.getNode(3));
    }
}
