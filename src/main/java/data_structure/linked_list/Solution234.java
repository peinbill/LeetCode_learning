package data_structure.linked_list;

/**
 * @Classname Solution234
 * @Description TODO
 * @Date 2020/11/26 16:40
 * @Created by laohuang
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        while(head==null||head.next==null){
            return true;
        }
        ListNode middleNodeList = middleNode(head);
        ListNode reverseNodeList = reverseList(middleNodeList.next);
        middleNodeList.next = null;
        while(head!=null&&reverseNodeList!=null){
            if(head.val!=reverseNodeList.val){
                return false;
            }
            head = head.next;
            reverseNodeList = reverseNodeList.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }
}
