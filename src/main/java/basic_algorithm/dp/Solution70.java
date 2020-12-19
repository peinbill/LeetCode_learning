package basic_algorithm.dp;

/**
 * @Classname Solution70
 * @Description TODO
 * @Date 2020/12/16 16:21
 * @Created by laohuang
 */
public class Solution70 {
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }

        int[] methods = new int[n];

        methods[0] =1;
        methods[1] =2;
        for(int i=2;i<n;i++){
            methods[i] = methods[i-1]+methods[i-2];
        }

        return methods[n-1];
    }


    // 进一步优化空间
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        for (int i = 2; i < n; ++i) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}
