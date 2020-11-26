package data_structure.linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution206
 * @Description TODO
 * @Date 2020/11/21 10:51
 * @Created by laohuang
 */
public class Solution206 {

    // 用队列的方法进行
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        Deque<Integer> deque = new LinkedList<>();

        ListNode current = head;

        while(current!=null){
            deque.addFirst(current.val);
            current=current.next;
        }

        ListNode res = new ListNode(deque.removeFirst());
        ListNode newHead = res;
        int size = deque.size();
        for(int i=0;i<size;i++){
            newHead.next = new ListNode(deque.removeFirst());
            newHead = newHead.next;
        }

        return res;

    }

    // 双指针的方法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
