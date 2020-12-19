package basic_algorithm.dp;

public class Solution5 {

    // 画格子，
    public String longestPalindrome(String s) {
        // 先写出异常情况
        if(s==null||s.length()==0){
            return null;
        }
        int len =s.length();
        boolean[][] dp = new boolean[len][len];

        int[] result = new int[2];
        result[0]=0;
        result[1]=0;
        int maxLen = 1;
        // i==j的特殊情况
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }


        // 动态规划画格子知道是下往上，左往右进行表格的遍历
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(j==i+1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                if(j>i+1){
                    if(dp[i+1][j-1]==true&&s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                if(j-i+1>maxLen&&dp[i][j]==true){
                    maxLen=j-i+1;
                    result[0]=i;
                    result[1]=j;
                }

            }



        }
        return s.substring(result[0],result[1]+1);

    }
}
