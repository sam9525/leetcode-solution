/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;

class Solution {

  public Node cloneGraph(Node node) {
    Map<Node, Node> oldToNew = new HashMap<>();

    return dfs(node, oldToNew);
  }

  private Node dfs(Node node, Map<Node, Node> oldToNew) {
    if (node == null) {
      return null;
    }

    if (oldToNew.containsKey(node)) {
      return oldToNew.get(node);
    }

    Node copy = new Node(node.val);
    oldToNew.put(node, copy);

    for (Node nei : node.neighbors) {
      copy.neighbors.add(dfs(nei, oldToNew));
    }

    return copy;
  }
  // Time Complexity : O(V + E) where V is the number of vertices and E is the number of edges
  // Space Complexity : O(V)
}
// @lc code=end
