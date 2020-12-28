滑动窗格


/* 滑动窗口算法框架 */
class Solution {
    void slidingWindow(string s, string t) {
        HashMap<Character, Integer> need, window;
        for (char c : t) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            ...

            /*** debug 输出的位置 ***/
            System.out.print("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (window needs shrink) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                ...
            }
        }
    }
}
    1、右指针右移之后窗口数据更新
    2、判断窗口是否要收缩
    3、左指针右移之后窗口数据更新
    4、根据题意计算结果

    和双指针题目类似，更像双指针的升级版，滑动窗口核心点是维护一个窗口集，根据窗口集来进行处理
    核心步骤
        right 右移
        收缩
        left 右移
        求结果

子串问题优先选择滑动窗格——准确说是没有顺序的子串问题


Solution76:照着模板进行即可。先往右扩展，符合条件后再往左进行收缩
Solution567: 还是套用模板，当最小窗格的长度=s2长度时，返回true，否则为false
Solution438：返回这些子串的起始索引，即找到多个最小窗格的left值
Solution3: 使用滑动窗格的思想，如果不包含重复的，right++，如果有重复的，剔除掉所有重复值（left++）再进行下去



