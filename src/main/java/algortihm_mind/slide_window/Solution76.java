package algortihm_mind.slide_window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Classname Solution76
 * @Description TODO
 * @Date 2020/12/28 9:13
 * @Created by laohuang
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0, match = 0;

        // needs存储t的<字符,出现次数>,windows存储<s中与t中字符相同的字符,出现次数>
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        int sLength = s.length();

        // 初始化needs
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < sLength) {
            // 获取字符
            char temp = s.charAt(right);
            // 如果是t中字符，在windows里添加，累计出现次数
            if (needs.containsKey(temp)) {
                windows.put(temp, windows.getOrDefault(temp,0) + 1);
                // 注意：Integer不能用==比较，要用compareTo
                if (windows.get(temp).compareTo(needs.get(temp)) == 0 ) {
                    // 字符temp出现次数符合要求，match代表符合要求的字符个数
                    match++;
                }
            }
            // 优化到不满足情况，right继续前进找可行解
            right++;
            // 符合要求的字符个数正好是t中所有字符，获得一个可行解
            while (match == needs.size()) {
                // 更新结果
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // 开始进行优化，即缩小区间，删除s[left],
                char c = s.charAt(left);
                // 当前删除的字符包含于t,更新Windows中对应出现的次数，如果更新后的次数<t中出现的次数，符合要求的字符数减1，下次判断match==needs.size()时不满足情况，
                if (needs.containsKey(c)) {
                    windows.put(c, windows.getOrDefault(c, 1) - 1);
                    if (windows.get(c) < needs.get(c)){
                        match--;
                    }
                }
                left++;
            }
        }
        // 返回覆盖的最小串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, minLen + start);
    }


    public static void main(String[] args){
        Solution76 solution76 = new Solution76();
        solution76.minWindow("ADOBECODEBANC","ABC");
    }


}
