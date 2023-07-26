package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            p.offer(progresses[i]);
            s.offer(speeds[i]);
        }
        int day = 1;
        int num_progress = 0;
        while(!p.isEmpty()){
            int progress = p.poll();
            int speed = s.poll();
            if(num_progress == 0){
                while(progress + speed * day < 100){
                    day++;
                }
                num_progress++;
            }
            else{
                if(progress + speed * day >= 100){
                    num_progress++;
                }
                else{
                    arrayList.add(num_progress);
                    num_progress = 0;
                    while(progress + speed * day < 100){
                        day++;
                    }
                    num_progress++;
                }
            }
        }
        if(num_progress != 0){
            arrayList.add(num_progress);
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
