package basic_algorithm.dp;

/**
 * @Classname Solution55
 * @Description TODO
 * @Date 2020/12/18 17:12
 * @Created by laohuang
 */
public class Solution55 {
    // 贪心算法——但贪心算法基本靠计题
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightMost= 0;
        for(int i=0;i<len;i++){
            // 先判断该点能不能到达
            rightMost = Math.max(rightMost,nums[i]+i);

            if(i<=rightMost){
                if(rightMost>len-1){
                    return true;
                }
            }
        }
        return false;

    }
}
