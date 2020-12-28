package algortihm_mind.slide_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution438
 * @Description TODO
 * @Date 2020/12/28 10:39
 * @Created by laohuang
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 即是找到所有最小子串
        List<Integer> returnList = new LinkedList<>();

        int left=0,right=0;
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int valid = 0;

        for(char c:p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int len = s.length();

        while(right<len){
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).compareTo(need.get(c))==0){
                    valid++;
                }
            }

            right++;
            while (valid==need.size()){
                char q = s.charAt(left);

                if(right-left==p.length()){
                    returnList.add(left);
                }

                if(need.containsKey(q)){
                    window.put(q,window.getOrDefault(q,0)-1);
                    if(window.get(q)<need.get(q)){
                        valid--;
                    }
                }

                left++;

            }

        }


        return returnList;

    }
}
