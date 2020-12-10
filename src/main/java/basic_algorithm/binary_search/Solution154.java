package basic_algorithm.binary_search;

/**
 * @Classname Solution154
 * @Description TODO
 * @Date 2020/12/9 11:19
 * @Created by laohuang
 */
public class Solution154 {
    public int findMin(int[] nums) {
        // 要看是不是递增的，结果就返回非递增的右侧
        int left = 0, right = nums.length - 1;



        while (left+1  < right){
            // 判断是否局部有序
            if(nums[left]<nums[right]){
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left]<nums[mid]) {
                left = mid;
            } else if(nums[left]>nums[mid]){
                right = mid;
            }else{
                left++;
            }
        }
        if(nums[left]>nums[right]){
            return nums[right];
        }else{
            return nums[left];
        }
    }

    public int findMin2(int[] nums) {
        int right = nums.length - 1, left = 0;
        if(right == 0) {
            return nums[0];
        }
        // 把nums[right]当做target做二分
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) { //最小值一定在[mid+1, right]索引中
                left = mid + 1;
            } else { // 相等表示重复，往左边移一位
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){
        Solution154 solution154 = new Solution154();
        System.out.println(solution154.findMin(new int[]{2,2,2,0,1}));
    }
}
