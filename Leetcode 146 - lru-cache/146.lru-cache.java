/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

  private Map<Integer, Integer> cache;
  private LinkedList<Integer> order;
  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.order = new LinkedList<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    // Put the key into order
    order.remove(Integer.valueOf(key));
    order.addFirst(key);

    return cache.get(key);
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      cache.put(key, value);

      order.remove(Integer.valueOf(key));
      order.addFirst(key);
    } else {
      cache.put(key, value);

      order.addFirst(key);

      if (cache.size() > capacity) {
        int lur = order.removeLast();
        cache.remove(lur);
      }
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
