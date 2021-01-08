package basic_algorithm.dp;

/**
 * @Classname Solution53
 * @Description TODO
 * @Date 2021/1/4 8:30
 * @Created by laohuang
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        int max_nums = nums[0];
        for(int i=1;i<nums.length+1;i++){
            if (dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i-1];
            }else{
                dp[i] = nums[i-1];
            }
            max_nums = Math.max(dp[i],max_nums);
        }
        return max_nums;
    }
}
