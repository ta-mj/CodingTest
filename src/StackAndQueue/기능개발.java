package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            int date = (int)Math.ceil((100 - progresses[i])/ (double) speeds[i]);
            if(!queue.isEmpty() && queue.peek() < date){
                arrayList.add(queue.size());
                queue.clear();
            }
            queue.offer(date);

        }
        arrayList.add(queue.size());
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
