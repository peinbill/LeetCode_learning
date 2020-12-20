package basic_algorithm.dp;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        // exception
        if(text1==null||text2==null||text1.length()==0||text2.length()==0){
            return 0;
        }

        int len1 = text1.length(),len2 = text2.length();
        int[][] dp = new int[len1][len2];

        if(text1.charAt(0)==text2.charAt(0)){
            dp[0][0]=1;
        }

        // init first row
        for(int j=1;j<len2;j++){
            if(text1.charAt(0)==text2.charAt(j)){
                dp[0][j]=1;
            }else{
                dp[0][j]=dp[0][j-1];
            }
        }

        // init first column
        for(int i=1;i<len1;i++){
            if(text2.charAt(0)==text1.charAt(i)){
                dp[i][0]=1;
            }else{
                dp[i][0]=dp[i-1][0];
            }
        }


        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1-1][len2-1];

    }

    // 把第一行和第一列也列入了该情况考虑
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
