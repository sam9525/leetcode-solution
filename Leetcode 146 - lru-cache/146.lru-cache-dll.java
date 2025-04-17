/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class LRUCache {

  class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }

  private Map<Integer, Node> cache;
  private int capacity;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.cache = new HashMap<>();
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  public void insert(Node node) {
    Node prev = this.tail.prev;

    prev.next = node;
    node.prev = prev;
    node.next = tail;
    this.tail.prev = node;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    Node cur = cache.get(key);
    remove(cur);
    insert(cur);

    return cur.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }

    Node newNode = new Node(key, value);
    cache.put(key, newNode);
    insert(newNode);

    if (cache.size() > capacity) {
      // Remove the first element after head from the cache
      Node lru = this.head.next;
      remove(lru);
      cache.remove(lru.key);
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);

    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1)); // 1
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2)); // -1
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1)); // -1
    System.out.println(lruCache.get(3)); // 3
    System.out.println(lruCache.get(4)); // 4
  }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
