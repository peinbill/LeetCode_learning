package data_structure.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution98
 * @Description TODO
 * @Date 2020/11/20 11:22
 * @Created by laohuang
 */


/*
    作者：sdwwld
    链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/san-chong-jie-jue-fang-shi-liang-chong-ji-bai-liao/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    这种做法非常巧妙，用确定范围的值进行
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


}


// 错误代码——左子树和左节点混淆
class Mistake98{
    private boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }

        if(root.left!=null){
            if(root.left.val>=root.val){
                flag=false;
                return;
            }
            dfs(root.left);
        }

        if(root.right!=null){
            if(root.right.val<=root.val){
                flag=false;
                return;
            }
            dfs(root.right);
        }
    }
}
