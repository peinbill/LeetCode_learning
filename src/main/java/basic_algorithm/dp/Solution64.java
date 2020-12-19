package basic_algorithm.dp;

/**
 * @Classname Solution64
 * @Description TODO
 * @Date 2020/12/16 14:48
 * @Created by laohuang
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[m-1].length;
        int[][] f = new int[m][n];

        f[0][0] = grid[0][0];

        // 第一行
        for(int j=1;j<n;j++){
            f[0][j] = f[0][j-1]+grid[0][j];
        }

        // 第一列
        for(int i =1;i<m;i++){
            f[i][0]=f[i-1][0]+grid[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                f[i][j] = Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
            }
        }

        return f[m-1][n-1];
    }
}
