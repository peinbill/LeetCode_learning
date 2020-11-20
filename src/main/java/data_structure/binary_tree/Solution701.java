package data_structure.binary_tree;

/**
 * @Classname Solution701
 * @Description TODO
 * @Date 2020/11/20 15:15
 * @Created by laohuang
 */
public class Solution701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }

        if(val>root.val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
