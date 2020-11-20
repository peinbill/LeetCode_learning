package data_structure.binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution103
 * @Description TODO
 * @Date 2020/11/20 11:04
 * @Created by laohuang
 */

// bfs+翻转
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        List<List<Integer>> resR = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmpRes = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                tmpRes.add(node.val);
            }
            resR.add(tmpRes);

        }

        boolean reverse=false;
        for(List<Integer> list:resR){
            if(reverse){
                List<Integer> tmp = new LinkedList<>();
                int listSize = list.size()-1;
                for(int i=listSize;i>=0;i--){
                    tmp.add(list.get(i));
                }
                res.add(tmp);
            }else{
                res.add(list);
            }
            reverse = !reverse;

        }
        return res;
    }
}
