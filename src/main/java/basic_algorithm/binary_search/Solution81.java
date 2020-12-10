package basic_algorithm.binary_search;

/**
 * @Classname Solution81
 * @Description TODO
 * @Date 2020/12/9 17:16
 * @Created by laohuang
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int start = 0,end= nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            // 左边有序
            if(nums[mid]>nums[end]){
                if(nums[start]<=target&&target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[start]>nums[mid]){
                if(nums[mid]<target&&target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                if(nums[start]==target){
                    return true;
                }
                start++;
            }
        }

        return false;
    }


    public static void main(String[] args){
        Solution81 solution81 = new Solution81();
        System.out.println(solution81.search(new int[]{3,1},4));
    }
}
