package basic_algorithm.binary_search;

/**
 * @Classname Solution704
 * @Description TODO
 * @Date 2020/12/8 9:47
 * @Created by laohuang
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int start = 0,end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}
