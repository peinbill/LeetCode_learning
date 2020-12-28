package algortihm_mind.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution567
 * @Description TODO
 * @Date 2020/12/28 10:00
 * @Created by laohuang
 */
public class Solution567 {


//    1、当窗口内包含s1的所有字母时，左指针移动，但此时窗口集合可能大于等于s1的排列
//    2、1的基础上，当窗口长度 === s1.length时，窗口即答案，返回
//    3、遍历结束，无符题答案，return false

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need=new HashMap<>(), window=new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        int len = s2.length();

        while (right < len) {
            // c 是将移入窗口的字符
            char c = s2.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).compareTo(window.get(c))==0){
                    valid++;
                }

            }

            // 判断左侧窗口是否要收缩
            while (valid==need.size()) {
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                if (right - left == s1.length()) {
                    return true;
                }

                if(need.containsKey(d)){
                    window.put(d,window.getOrDefault(d,0)-1);

                    if(window.get(d)<need.get(d)){
                        valid--;
                    }

                }

                // 左移窗口
                left++;
            }
        }


        return false;
    }

}
