回溯法

回溯法（backtrack）常用于遍历列表所有子集，是 DFS 深度搜索一种，一般用于全排列，穷尽所有可能，遍历的过程实际上是一个决策树的遍历过程。
时间复杂度一般 O(N!)，它不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。

核心就是从选择列表里做一个选择，然后一直递归往下搜索答案，如果遇到路径不通，就返回来撤销这次选择。

模板：
int[] result = new int[size];
void backtrack(选择列表,路径): {
    if 满足结束条件: {
        result.add(路径)
        return
    }
    for (选择 : 选择列表): {
        做选择（一般要排除不合法的选择）
        backtrack(选择列表,路径)
        撤销选择
    }
}

选择列表：下一步
路径：当前步骤

Solution78: 先画出图，再进行回溯算法的应用
Solution90: 在78的基础上增加排序
Solution46：回溯最最经典例题，https://mp.weixin.qq.com/s/nMUHqvwzG2LmWA9jMIHwQQ
Solution47:也是在46的基础上增加排序

有重复组合的全排列问题都应该考虑排序！！！

Solution39: 难点在于有顺序后的重复问题
SOlution17: 回溯的实际应用场景，难点在于怎么将业务问题转化为实际，以及StringBuffer的使用







