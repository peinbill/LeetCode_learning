package data_structure.binary_tree;

/**
 * @Classname Solution235
 * @Description TODO
 * @Date 2021/1/17 16:26
 * @Created by laohuang
 */

public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p){
            if(search(root,q)){
                return root;
            }
        }else if(root==q){
            if(search(root, p)){
                return root;
            }
        }

        if(search(root.right,p)&&search(root.right,q)){
            return lowestCommonAncestor(root.right, p, q);
        }else if(search(root.left,p)&&search(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }



    }

    private boolean search(TreeNode root ,TreeNode node){
        if(root==null){
            return false;
        }
        if(root.val==node.val){
            return true;
        }
        return search(root.left,node)||search(root.right,node);

    }
}
