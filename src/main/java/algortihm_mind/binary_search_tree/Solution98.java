package algortihm_mind.binary_search_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution98
 * @Description TODO
 * @Date 2020/12/28 14:42
 * @Created by laohuang
 */
public class Solution98 {
    // 方法一
    List<Integer> list=new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        // 二叉树，中序为升序
       order(root);
       return isSorted(list);
    }

    private void order(TreeNode node){
       if(node==null){
           return;
       }
       order(node.left);
       list.add(node.val);
       order(node.right);

    }

    private boolean isSorted(List<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).compareTo(list.get(i+1))>=0){
                return false;
            }
        }

        return true;
    }

}

class Solution98_2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
