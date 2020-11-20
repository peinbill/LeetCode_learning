package data_structure.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution102
 * @Description TODO
 * @Date 2020/11/20 9:35
 * @Created by laohuang
 */


// 其实就是BFS的简单应用
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // size记录当前层有多少元素（遍历当前层，再添加下一层）
            List<Integer> tmpRes = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmpRes.add(node.val);
            }
            res.add(tmpRes);
        }
        return res;
    }
}
