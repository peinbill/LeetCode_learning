package introduction;


/**
 * 解题思路
 *
 * 遍历进行字符串匹配
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for(int start=0;start<=haystackLength-needleLength;start++){
            if(needle.equals(haystack.substring(start,start+needleLength))){
                return start;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Solution28 solution28=new Solution28();
        System.out.println(solution28.strStr("hello","ll"));
    }
}
