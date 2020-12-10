package basic_algorithm.binary_search;

import data_structure.stack_deque.Solution496;

/**
 * @Classname Solution35
 * @Description TODO
 * @Date 2020/12/8 11:10
 * @Created by laohuang
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
         if (target < nums[left]) return 0;
         if (target > nums[right]) return nums.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }


    public static void main(String[] args){
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1,3,5,6},7));
    }

}
