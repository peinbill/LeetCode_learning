package data_structure.binary_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution107
 * @Description TODO
 * @Date 2020/11/20 10:05
 * @Created by laohuang
 */
// BFS+栈
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Deque<List<Integer>> resQ = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmpResult = new LinkedList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                tmpResult.add(node.val);
            }
            resQ.addFirst(tmpResult);

        }

        while(!resQ.isEmpty()){
            res.add(resQ.removeFirst());
        }
        return res;
    }
}
