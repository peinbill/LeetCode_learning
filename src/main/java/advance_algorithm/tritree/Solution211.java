package advance_algorithm.tritree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution211
 * @Description TODO
 * @Date 2021/1/8 17:04
 * @Created by laohuang
 */
public class Solution211 {
    class WordDictionary {
        Trie trie;
        /** Initialize your data structure here. */
        public WordDictionary() {
            trie = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            trie.insert(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return trie.search(word);
        }
    }

    class Trie{
        class TrieNode{
            Map<Character,TrieNode> node = new HashMap<>();
            boolean isWord;
        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode curr = root;
            for(char c:word.toCharArray()){
                if(curr.node.get(c)==null){
                    curr.node.put(c,new TrieNode());
                }
                curr=curr.node.get(c);
            }
            curr.isWord=true;
        }

        public boolean search(String word){
            return search(word,root);
        }

        public boolean search(String word,TrieNode node){
            if(word.length()==0){
                return node.isWord;
            }
            TrieNode curr = node;
            char[] cs = word.toCharArray();
            for(int i=0;i<cs.length;i++){
                char c = cs[i];
                if(c!='.'){
                    curr=curr.node.get(c);
                    if(curr==null){
                        return false;
                    }
                }else{
                    for(Map.Entry<Character, TrieNode> set:curr.node.entrySet()){
                        TrieNode next = set.getValue();
                        boolean token = search(word.substring(i+1, word.length()),next);
                        if(token==true){
                            return true;
                        }
                    }
                    return false;
                }


            }

            return curr.isWord;
        }


    }
}
