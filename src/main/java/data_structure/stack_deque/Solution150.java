package data_structure.stack_deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname Solution150
 * @Description TODO
 * @Date 2020/11/27 17:26
 * @Created by laohuang
 */
public class Solution150 {
    private Deque<Integer> deque = new LinkedList<>();

    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }

        for(String token:tokens){
            if(token.equals("+")){
                deque.addFirst(deque.removeFirst()+deque.removeFirst());
            }else if(token.equals("-")){
                int tokenTop = deque.removeFirst();
                int tokenSecond = deque.removeFirst();
                deque.addFirst(tokenSecond-tokenTop);
            }else if(token.equals("*")){
                deque.addFirst(deque.removeFirst()*deque.removeFirst());
            }else if(token.equals("/")){
                int tokenTop = deque.removeFirst();
                int tokenSecond = deque.removeFirst();
                deque.addFirst(tokenSecond/tokenTop);
            }else{
                deque.addFirst(Integer.parseInt(token));
            }

        }

        return deque.removeFirst();
    }

    public static void main(String[] args){
        Solution150 solution150 = new Solution150();
        System.out.println(solution150.evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
