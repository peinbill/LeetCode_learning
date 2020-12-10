package basic_algorithm.binary_search;

/**
 * @Classname Solution34
 * @Description TODO
 * @Date 2020/12/8 10:14
 * @Created by laohuang
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0,end = nums.length-1;
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int temResult = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==nums[mid]){
                temResult = mid;
                break;
            }
            if(target>nums[mid]){
                start = mid+1;
            }
            if(target<nums[mid]){
                end = mid-1;
            }
        }

        if(temResult==-1){
            return new int[]{-1,-1};
        }else{
            int front = temResult;
            int back = temResult;
            while(front>=0 && nums[front]==target){
                result[0]=front;
                front--;
            }
            while(back<nums.length&&nums[back]==target){
                result[1]=back;
                back++;
            }
            return result;
        }


    }
}
