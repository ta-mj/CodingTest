package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int num : arr){
            if(queue.isEmpty()){
                queue.offer(num);
                arrayList.add(num);
            }
            else{
                if(queue.peek() != num){
                    queue.clear();
                    queue.offer(num);
                    arrayList.add(num);
                }
            }
        }

        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
