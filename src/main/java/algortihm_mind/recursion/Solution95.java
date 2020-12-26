package algortihm_mind.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution95
 * @Description TODO
 * @Date 2020/12/26 15:44
 * @Created by laohuang
 */
public class Solution95 {


    // 因为二叉树的左子树和右子树同样也为二叉树，所以天生适合用递归
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            // 空串
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args){
        Solution95 solution95 = new Solution95();
        solution95.generateTrees(1);
    }

}
