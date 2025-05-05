/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start

import java.util.PriorityQueue;

class KthLargest {

  private PriorityQueue<Integer> pq;
  private int k;

  public KthLargest(int k, int[] nums) {
    pq = new PriorityQueue<>(k);
    this.k = k;

    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    if (pq.size() < k) {
      pq.offer(val);
    } else if (val > pq.peek()) {
      pq.poll();
      pq.offer(val);
    }
    return pq.peek();
  }

  public static void main(String[] args) {
    KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });

    System.out.println(kthLargest.add(3)); // 4
    System.out.println(kthLargest.add(5)); // 5
    System.out.println(kthLargest.add(10)); // 5
    System.out.println(kthLargest.add(9)); // 8
    System.out.println(kthLargest.add(4)); // 8
  }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end
