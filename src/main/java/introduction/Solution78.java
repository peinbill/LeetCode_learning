package introduction;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * (usedSize, tarSize, start)
 *
 * usedSize：表示当前已经选入集合中的元素个数
 * tarSize：表示我期望的集合大小
 * start：表示可选元素的位置起始位置，即可以从nums[start .. n]中选择元素
 *
 * 作者：beney-2
 * 链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-beney-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution78 {
    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> util = new LinkedList<>();
    private int n;
    private int[] arr;

    public List<List<Integer>> subsets(int[] nums) {
        if ((arr = nums) == null || (n = nums.length) == 0)
            return res;
        // 期望的集合大小由 0~n
        for (int size = 0; size <= n; ++size) {
            backTrace(0, size, 0);
        }
        return res;
    }

    // 向后找，st之前的元素不作考虑
    public void backTrace(int usedSize, int tarSize, int st) {
        if (usedSize == tarSize) {
            // 元素数目刚刚好
            res.add(new LinkedList<>(util));
            return;
        } else if (usedSize + n-st < tarSize){
            // 元素数目不足以构造
            return;
        }

        for (int i = st; i < n; ++i) {
            util.push(arr[i]);
            backTrace(usedSize + 1, tarSize, i+1);
            util.pop();
        }
    }

    public static void main(String[] args){
        Solution78 solution78 = new Solution78();
        solution78.subsets(new int[]{1,2,3});
    }
}
