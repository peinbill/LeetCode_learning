package data_structure.stack_deque;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution94
 * @Description TODO
 * @Date 2020/11/29 10:12
 * @Created by laohuang
 */
public class Solution94 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        order(root);

        return res;

    }

    private void order(TreeNode root) {
        if (root == null) {
            return;
        }

        order(root.left);
        res.add(root.val);
        order(root.right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
}
