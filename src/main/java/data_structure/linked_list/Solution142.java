package data_structure.linked_list;

/**
 * @Classname Solution142
 * @Description TODO
 * @Date 2020/11/26 16:06
 * @Created by laohuang
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

//    作者：jyd
//    链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    因为f = 2*s
//        f = s =nb
//    所以s = nb
//    又因为返回值 head = a+nb
}
