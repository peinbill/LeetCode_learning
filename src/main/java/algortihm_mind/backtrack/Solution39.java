package algortihm_mind.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution39
 * @Description TODO
 * @Date 2020/12/29 16:10
 * @Created by laohuang
 */
public class Solution39 {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int sum = 0;
        backTrack(candidates,sum,target,new LinkedList<>(),0);
        return res;
    }

    private void backTrack(int[] candicate,int sum,int target,List<Integer> list,int start){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i=start;i<candicate.length;i++){
            list.add(candicate[i]);
            sum += candicate[i];
            backTrack(candicate,sum,target,list,start);

            list.remove(list.size()-1);
            sum -= candicate[i];
        }
    }
}
