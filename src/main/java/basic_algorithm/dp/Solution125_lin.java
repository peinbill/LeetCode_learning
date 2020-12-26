package basic_algorithm.dp;

/**
 * @Classname Solution125_lin
 * @Description TODO
 * @Date 2020/12/26 15:11
 * @Created by laohuang
 */
public class Solution125_lin {

    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int len = A.length;
        // dp[i][j] 表示前i件物品，当容量为j的时候的最大价值（重量）
        int[][] dp = new int[len+1][m+1];

        // 初始化
        dp[0][0]=0;

        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=len;i++){
            dp[i][0]=0;
        }

        // 状态转移
        for(int i=1;i<=len;i++){
            for(int j=1;j<=m;j++){
                if(j>=A[i-1]){
                    // 此时容量够,可以选择放或者不放这件物品
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+V[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[len][m];

    }
}
