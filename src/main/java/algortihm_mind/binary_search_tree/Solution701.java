package algortihm_mind.binary_search_tree;

/**
 * @Classname Solution701
 * @Description TODO
 * @Date 2020/12/28 15:17
 * @Created by laohuang
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }

        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right= insertIntoBST(root.right,val);
        }

        return root;
    }
}
