package data_structure.stack_deque;

/**
 * @Classname Solution155
 * @Description TODO
 * @Date 2020/11/27 16:49
 * @Created by laohuang
 */
public class Solution155 {
    class MinStack {
        /** initialize your data structure here. */
        private Node head;
        int min;
        int size=0;

        public MinStack() {

        }

        public void push(int x) {
            if(head==null){
                min = Integer.MAX_VALUE;
            }else{
                min = head.min;
            }

            int newMin = x>min?min:x;
            Node node = new Node(x,newMin,head);

            head=node;
            size++;
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;

        }

        public int getMin() {

            return head.min;
        }

        private class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
