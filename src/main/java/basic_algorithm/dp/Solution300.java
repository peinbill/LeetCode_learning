package basic_algorithm.dp;

/**
 * @Classname Solution300
 * @Description TODO
 * @Date 2020/12/20 10:56
 * @Created by laohuang
 */
public class Solution300 {

    // 核心在于dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);

        }
        return  maxLen;
    }
}
