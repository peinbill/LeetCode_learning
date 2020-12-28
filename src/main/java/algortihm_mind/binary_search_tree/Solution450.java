package algortihm_mind.binary_search_tree;

/**
 * @Classname Solution450
 * @Description TODO
 * @Date 2020/12/28 15:42
 * @Created by laohuang
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }

        if(root.val==key){
            // 删除当前值
            if(root.left==null){
                root=root.right;
            }else if(root.right==null){
                root=root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根或者左边树的最右结点
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }



        }else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }


        return root;
    }

    private TreeNode min(TreeNode node){
        if(node.left==null){
            return node;
        }else{
            return min(node.left);
        }
    }

    private TreeNode deleteMin(TreeNode node){
        if(node==null){
            return node;
        }

        if(node.left==null){
            return node.right;
        }

        node.left = deleteMin(node.left);

        return node;
    }
}
