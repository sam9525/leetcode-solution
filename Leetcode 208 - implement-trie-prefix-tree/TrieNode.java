/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start

import java.util.HashMap;

class TrieNode {

  public HashMap<Character, TrieNode> children = new HashMap<>();
  public boolean isEnd = false;
}

class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    // Copy the root
    TrieNode cur = root;

    // Iterate through each character in the word
    for (char c : word.toCharArray()) {
      // If the character is not in the children map, add it
      cur.children.putIfAbsent(c, new TrieNode());
      // Move to the next node
      cur = cur.children.get(c);
    }

    // Mark the end of the word
    cur.isEnd = true;
  }

  public boolean search(String word) {
    // Copy the root
    TrieNode cur = root;

    // Iterate through each character in the word
    for (char c : word.toCharArray()) {
      // Check if the character is in the children map
      if (!cur.children.containsKey(c)) {
        return false;
      }

      // Move to the next node
      cur = cur.children.get(c);
    }

    // Check if this is the end of the word
    return cur.isEnd;
  }

  public boolean startsWith(String prefix) {
    // Copy the root
    TrieNode cur = root;

    // Iterate through each character in the word
    for (char c : prefix.toCharArray()) {
      // Check if the character is in the children map
      if (!cur.children.containsKey(c)) {
        return false;
      }

      // Move to the next node
      cur = cur.children.get(c);
    }

    return true;
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
