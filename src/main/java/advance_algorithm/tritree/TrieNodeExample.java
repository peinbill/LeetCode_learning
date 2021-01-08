package advance_algorithm.tritree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TrieNode
 * @Description 前缀树的表示方式
 * @Date 2021/1/8 15:23
 * @Created by laohuang
 */


//表示方法一: 使用数组
class TrieNode {
    //访问子节点十分 快捷 。访问一个特定的子节点比较 容易 ，
    //因为在大多数情况下，我们很容易将一个字符转换为索引。
    //但并非所有的子节点都需要这样的操作，所以这可能会导致 空间的浪费 。
    // change this value to adapt to different cases
    public static final int N = 26;
    public TrieNode[] children = new TrieNode[N];

    // you might need some extra values according to different cases
};

/** Usage:
 *  Initialization: TrieNode root = new TrieNode();
 *  Return a specific child node with char c: root.children[c - 'a']
 */

// 表示方法二：使用map
//    通过相应的字符来访问特定的子节点 更为容易 。
//    但它可能比使用数组 稍慢一些 。
//    但是，由于我们只存储我们需要的子节点，因此 节省了空间 。
//    这个方法也更加 灵活 ，因为我们不受到固定长度和固定范围的限制。

class TrieNode2 {
    public Map<Character, TrieNode> children = new HashMap<>();

    // you might need some extra values according to different cases
};

/** Usage:
 *  Initialization: TrieNode root = new TrieNode();
 *  Return a specific child node with char c: root.children.get(c)
 */
