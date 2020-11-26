package data_structure.linked_list;

/**
 * @Classname Solution141
 * @Description TODO
 * @Date 2020/11/26 11:27
 * @Created by laohuang
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head, q = head;
        boolean flag = false;
        while (p.next != null && q.next != null) {
            p = p.next;
            if (q.next.next != null) {
                q = q.next.next;
            } else {
                break;
            }
            if (p == q) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
