package basic_algorithm.dp;

/**
 * @Classname Solution55
 * @Description TODO
 * @Date 2020/12/18 17:12
 * @Created by laohuang
 */
public class Solution55 {
    // 动态规划
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0]=true;
        for(int i=0;i<len;i++){
            if(dp[i]==true){
                int tmpMaxLen = nums[i];
                if(i+tmpMaxLen>len-1){
                    return true;
                }
                for(int j=tmpMaxLen;j>0;j--){
                    dp[i+j]=true;
                }
            }
        }
        return dp[len-1];

    }

    // 动态规划推导出贪心算法，最大值rightmost>len-1
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        // rightMost指的是当前值能到达的最后侧
        int rightMost = 0;
        for(int i=0;i<len;i++){
            if(i<=rightMost){
                int tmpRight = nums[i]+i;
                rightMost = Math.max(tmpRight,rightMost);
                if(rightMost>=len-1){
                    return true;
                }
            }
        }
        return false;

    }
}
