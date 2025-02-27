/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair<K, V> {

  private K key;
  private V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}

class TimeMap {

  private Map<String, List<Pair<String, Integer>>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.putIfAbsent(key, new ArrayList<>());

    map.get(key).add(new Pair<String, Integer>(value, timestamp));
  }

  public String get(String key, int timestamp) {
    String res = "";

    if (map.containsKey(key)) {
      List<Pair<String, Integer>> temp = map.get(key);

      int low = 0, high = temp.size() - 1;

      while (low <= high) {
        int mid = low + (high - low) / 2;

        if (temp.get(mid).getValue() <= timestamp) {
          res = temp.get(mid).getKey();

          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    TimeMap timeMap = new TimeMap();

    timeMap.set("foo", "bar", 1);
    System.out.println(timeMap.get("foo", 1)); // bar
    System.out.println(timeMap.get("foo", 3)); // bar

    timeMap.set("foo", "bar2", 4);
    System.out.println(timeMap.get("foo", 4)); // bar2
  }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
