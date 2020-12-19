package basic_algorithm.dp;

import java.util.List;

/**
 * @Classname Solution120
 * @Description TODO
 * @Date 2020/12/11 10:35
 * @Created by laohuang
 */
public class Solution120 {

    // 方法一：找出fn的规律——动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] f = new int[m][n];

        f[0][0] = triangle.get(0).get(0);

        for(int i=1;i<m;i++){
            f[i][0]=f[i-1][0]+triangle.get(i).get(0);
            int j=1;
            for(;j<=i;i++){
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j])+triangle.get(i).get(j);
            }
            f[i][j] = f[i-1][j-1]+triangle.get(i).get(j);
        }

        int min = f[m-1][0];
        for(int i=1;i<n;i++){
            min = Math.min(min,f[m-1][i]);
        }

        return min;


    }


    // 动态规律+空间优化：只用到f(n-1),没有用到f(n-2)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 使用奇偶性交替地使用数组
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        }
        return minTotal;
    }

    // 空间再度优化——从右往左进行
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }




}
