package algortihm_mind.binary_search_tree;

/**
 * @Classname Solution110
 * @Description TODO
 * @Date 2020/12/28 15:48
 * @Created by laohuang
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);


    }

    private int height(TreeNode node){
        if(node==null){
            return 0;
        }

        return Math.max(height(node.left),height(node.right))+1;
    }
}
