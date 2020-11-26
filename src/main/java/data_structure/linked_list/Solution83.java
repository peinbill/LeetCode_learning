package data_structure.linked_list;

/**
 * @Classname Solution83
 * @Description TODO
 * @Date 2020/11/21 9:42
 * @Created by laohuang
 */
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
