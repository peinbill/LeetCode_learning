package basic_algorithm.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname Solution139
 * @Description TODO
 * @Date 2020/12/20 11:14
 * @Created by laohuang
 */
public class Solution139 {


//  dp[i]=dp[j] && check(s[j..i−1])
//  对于边界条件，我们定义 dp[0]=true\textit{dp}[0]=truedp[0]=true 表示空串且合法。
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //    dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
//  该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中，例如下面的 dict 就不够组成字符串 “leetcode”： ["lee", "tc", "cod"]
//  求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }




}
