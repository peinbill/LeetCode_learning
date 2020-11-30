package data_structure.stack_deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution232
 * @Description TODO
 * @Date 2020/11/30 16:15
 * @Created by laohuang
 */
public class Solution232 {
    /** Initialize your data structure here. */
    public Solution232() {

    }

    private Deque<Integer> in = new LinkedList<>();
    private Deque<Integer> out = new LinkedList<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.addFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.addFirst(in.removeFirst());
            }
        }
    }
}
