/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start

import java.util.HashMap;

class TrieNode {

  public HashMap<Character, TrieNode> children = new HashMap<>();
  public boolean isEnd = false;
}

class WordDictionary {

  private TrieNode root;

  public WordDictionary() {
    this.root = new TrieNode();
  }

  public void addWord(String word) {
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
    return dfs(word, 0, root);
  }

  public boolean dfs(String word, int j, TrieNode root) {
    // Copy the root
    TrieNode cur = root;

    // Iterate through each character in the word
    for (int i = j; i < word.length(); i++) {
      char c = word.charAt(i);

      // If character is ., start from next character
      if (c == '.') {
        // Iterate through all children
        for (TrieNode child : cur.children.values()) {
          if (dfs(word, i + 1, child)) {
            return true;
          }
        }
      }

      if (!cur.children.containsKey(c)) {
        return false;
      }

      cur = cur.children.get(c);
    }

    return cur.isEnd;
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad")); // false
    System.out.println(wordDictionary.search("bad")); // true
    System.out.println(wordDictionary.search(".ad")); // true
    System.out.println(wordDictionary.search("b..")); // true
  }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
