package cn.zliangcheng.hash;

import cn.zliangcheng.linklist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    Map<Integer, ListNode> cache = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode curNode = cache.get(key);
        deleteNode(curNode);
        insertToTail(curNode);

        return curNode.val;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (cache.containsKey(key)) {
            deleteNode(cache.get(key));
        } else {
            if (cache.size() == capacity) {
                ListNode remove = head.next;
                deleteNode(remove);
                cache.remove(remove.key);
            }
        }
        insertToTail(node);
        cache.put(key, node);
    }

    public void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void insertToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    public class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
