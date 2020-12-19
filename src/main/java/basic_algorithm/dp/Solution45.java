package basic_algorithm.dp;

public class Solution45 {

    // 动态规划，核心点在于dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;

        for(int i=1;i<len;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<len;i++){
            int tmpMaxLen = nums[i];
            for(int j=1;j<=tmpMaxLen;j++){
                if(i+j>len-1){
                    continue;
                }
                dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
            }
        }

        return dp[len-1];
    }

    // 贪心算法：从左边的部属必然小于右边可推导，当前路径=下一步最远
    public int jump2(int[] nums) {
        int len = nums.length;
        int maxPosition = 0;
        int steps = 0;
        int end =0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
