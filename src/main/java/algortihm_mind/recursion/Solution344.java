package algortihm_mind.recursion;

/**
 * @Classname Solution344
 * @Description TODO
 * @Date 2020/12/26 15:28
 * @Created by laohuang
 */
public class Solution344 {

    // 双指针
    public void reverseString(char[] s) {
        int len = s.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }

    public void reverseString2(char[] s) {
        swap(0, s.length-1, s);
    }

    public void swap(int start, int end, char[] s) {
        if(start >= end){
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start+1, end-1, s);
    }


}
