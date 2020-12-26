package algortihm_mind.recursion;

/**
 * @Classname Solution24
 * @Description TODO
 * @Date 2020/12/26 15:40
 * @Created by laohuang
 */



public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode next = head.next;

        ListNode nextNext = next.next;

        next.next = head;

        head.next=swapPairs(nextNext);

        return next;

    }
}
