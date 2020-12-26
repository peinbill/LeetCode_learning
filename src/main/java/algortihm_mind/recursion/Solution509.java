package algortihm_mind.recursion;

/**
 * @Classname Solution509
 * @Description TODO
 * @Date 2020/12/26 16:39
 * @Created by laohuang
 */
public class Solution509 {

    // 递归做法，但是重复状态太多
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }

    // 动态规划做法
    public int fib2(int n){

        int[] dp = new int[n+1];

        if(n==0||n==1){
            return n;
        }

        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }


        return dp[n];

    }

}
