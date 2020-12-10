package basic_algorithm.binary_search;

/**
 * @Classname Solution153
 * @Description TODO
 * @Date 2020/12/9 11:00
 * @Created by laohuang
 */
public class Solution153 {
    public int findMin(int[] nums) {
        // 要看是不是递增的，结果就返回非递增的右侧
        int left = 0, right = nums.length - 1;

        if(nums[left]<nums[right]){
            return nums[left];
        }

        while (left+1  < right){
            int mid = left + (right - left) / 2;
            if (increasing(nums[left],nums[mid])) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left]>nums[right]){
            return nums[right];
        }else{
            return nums[left];
        }
    }

    private boolean increasing(int n,int m){
        return n<=m;
    }

    public static void main(String[] args){
        Solution153 solution153 = new Solution153();
        solution153.findMin(new int[]{4,5,6,7,0,1,2});
    }
}
