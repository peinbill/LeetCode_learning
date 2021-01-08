package advance_algorithm.tritree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution677
 * @Description TODO
 * @Date 2021/1/8 16:08
 * @Created by laohuang
 */
public class Solution677 {
    class MapSum {
        Trie trie;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            trie.insert(key, val);
        }

        public int sum(String prefix) {
            Trie.TrieNode trieNode = trie.search(prefix);
            // 进行深度遍历
            int sumTotal = dfs(trieNode);
            return sumTotal;
        }

        private int dfs(Trie.TrieNode node) {
            if (node == null) {
                return 0;
            }
            int sum = node.value;
            for (Map.Entry<Character, Trie.TrieNode> set : node.node.entrySet()) {
                sum += dfs(set.getValue());
            }
            return sum;
        }


    }

    class Trie {
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        class TrieNode {
            Map<Character, TrieNode> node = new HashMap<>();
            int value = 0;
        }

        public void insert(String key, int val) {
            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                if (curr.node.get(c) == null) {
                    curr.node.put(c,new TrieNode());
                }
                curr = curr.node.get(c);
            }
            curr.value=val;
        }

        public TrieNode search(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                curr = curr.node.get(c);
                if(curr==null){
                    return new TrieNode();
                }
            }
            return curr;
        }
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */


}
