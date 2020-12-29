package algortihm_mind.backtrack;

import data_structure.linked_list.Solution92;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution78
 * @Description TODO
 * @Date 2020/12/29 10:07
 * @Created by laohuang
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution78 solution78 = new Solution78();
        solution78.subsets(new int[]{1,2,3});
    }



}
