package advance_algorithm.tritree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Trie
 * @Description 同样也是Solution208
 * @Date 2021/1/8 15:42
 * @Created by laohuang
 */
public class Trie {
    class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    // 很类似二叉树
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    // 搜索失败的两种可能：要么该单词不在前缀树中，要么该单词在前缀树中只是一个前缀而不是一个单词
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    // 跟搜索差不多，唯一的区别在于不用判断该前缀树是一个单词还是仅仅是前缀
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
