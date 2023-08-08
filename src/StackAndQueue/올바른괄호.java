package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 올바른괄호 {
    boolean solution(String s) {
        //왼쪽 괄호 n개 오른쪽 괄호 n개 의 패턴이 반복 되어야 함.
        Queue<Character> queue = new LinkedList<>();
        if(s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')'){
            return false;
        }
        else{
            for(int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if(c == '('){
                    if(queue.contains(')')){
                        return false;
                    }
                    else{
                        queue.offer(c);
                    }
                }
                else{
                    if(queue.isEmpty()){
                        return false;
                    }
                    else{
                        queue.remove();
                    }
                }
            }
            return true;
        }
    }
}
