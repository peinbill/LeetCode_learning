package data_structure.stack_deque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution133
 * @Description TODO
 * @Date 2020/11/29 10:38
 * @Created by laohuang
 */
public class Solution133 {
    Map<Node, Node> map = new HashMap<>();


    public Node cloneGraph(Node node) {
        // 第一次遍历创建图
        dfs(node);

        // 第二次遍历为图的结点添加邻居
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node key = entry.getKey();
            List<Node> list = new ArrayList<>();
            for (Node tmp : key.neighbors) {
                list.add(map.get(tmp));
            }
            entry.getValue().neighbors = list;
        }

        // 返回值
        return map.get(node);

    }

    private void dfs(Node node) {

        if (node == null) {
            return;
        }
        if (map.containsKey(node)) {
            return;
        }
        map.put(node, new Node(node.val));

        for (Node tmp:node.neighbors){
            dfs(tmp);
        }
    }
}

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
