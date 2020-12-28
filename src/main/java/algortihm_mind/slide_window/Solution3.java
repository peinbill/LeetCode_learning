package algortihm_mind.slide_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2020/12/28 11:26
 * @Created by laohuang
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;
        Set<Character> window = new HashSet<>();
        int max = 0;
        int currentSize = 0;

        while (right<s.length()){

            char ch = s.charAt(right);
            if(window.contains(ch)){
                // 此时包含，要移动left恢复到不包含这个字符
                while(true){
                    char leftChar = s.charAt(left);
                    left++;
                    if(leftChar==ch){
                        break;
                    }else {
                        window.remove(leftChar);
                    }

                }
            }else {
                window.add(ch);
            }


            max = Math.max(max,window.size());
            right++;
        }


        return max;
    }


}
