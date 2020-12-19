package basic_algorithm.dp;

/**
 * @Classname Solution62
 * @Description TODO
 * @Date 2020/12/16 15:25
 * @Created by laohuang
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] pathCount = new int[m][n];
        pathCount[0][0]=1;
        // 第一行
        for(int i=1;i<m;i++){
            pathCount[i][0] = 1;
        }

        // 第一列
        for(int j=1;j<n;j++){
            pathCount[0][j]=1;
        }

        // 核心在于pathCount[i-1][j]和pathCount[i][j-1]所经过的路径一定是不同的
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                pathCount[i][j]=pathCount[i-1][j]+pathCount[i][j-1];
            }
        }
        return pathCount[m-1][n-1];
    }
}
