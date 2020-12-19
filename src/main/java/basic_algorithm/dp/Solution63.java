package basic_algorithm.dp;

/**
 * @Classname Solution63
 * @Description TODO
 * @Date 2020/12/16 15:45
 * @Created by laohuang
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[m-1].length;
        int[][] pathCount = new int[m][n];
        if(obstacleGrid[0][0]==1){
            pathCount[0][0]=0;
        }else{
            pathCount[0][0]=1;
        }


        // 加入一个判断，如果碰到障碍物，当前值为0——尤其是第一行第一列
        // 第一列
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==1){
                pathCount[i][0]=0;
            }else {
                pathCount[i][0]=pathCount[i-1][0];
            }
        }
        // 第一行
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j]==1){
                pathCount[0][j]=0;
            }else {
                pathCount[0][j]=pathCount[0][j-1];
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    pathCount[i][j]=0;
                }else {
                    pathCount[i][j] = pathCount[i-1][j]+pathCount[i][j-1];
                }
            }

        }

        return pathCount[m-1][n-1];
    }


}
