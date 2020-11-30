package data_structure.stack_deque;

import java.util.*;

/**
 * @Classname Solution496
 * @Description TODO
 * @Date 2020/11/29 17:02
 * @Created by laohuang
 */
public class Solution496 {

    // 暴力破解法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],-1);
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }

        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }

        return res;

    }

    // 单调栈
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Deque< Integer > stack = new LinkedList<>();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }



    public static void main(String[] args){
        Solution496 solution496 = new Solution496();
        solution496.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }
}
