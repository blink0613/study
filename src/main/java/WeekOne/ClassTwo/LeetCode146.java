package WeekOne.ClassTwo;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {

    class DoubleLinkedListNode{
        int key;
        int value;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        public DoubleLinkedListNode(){};
        public DoubleLinkedListNode(int _key,int _value){key = _key; value = _value;}

    }
    private Map<Integer, DoubleLinkedListNode> cache = new HashMap<Integer, DoubleLinkedListNode>();
    private int size;
    private int capacity;
    private DoubleLinkedListNode head, tail;

    public LeetCode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DoubleLinkedListNode node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            removeNode(node);
            insertHead(node);
            return cache.get(key).value;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node = cache.get(key);
        if(node == null){
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            cache.put(key,newNode);
            insertHead(newNode);
            size++;
            if(size > capacity){
                // 如果超出容量，删除双向链表的尾部节点
                DoubleLinkedListNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            removeNode(node);
            insertHead(node);
        }

    }

    private void insertHead(DoubleLinkedListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DoubleLinkedListNode removeTail(){
        DoubleLinkedListNode newTail = tail.prev;
        removeNode(tail);
        return newTail;
    }

    private void removeNode(DoubleLinkedListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
