package DFSBFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {

    public static void main(String args[]){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numbers[0]);
        queue.add(-numbers[0]);
        for(int i = 1 ; i < numbers.length; i++){
            ArrayList<Integer> for_next = new ArrayList<>();
            while (!queue.isEmpty()){
                for_next.add(queue.poll());
            }
            for(int j = 0 ; j < for_next.size() ; j++){
                queue.add(for_next.get(j) + numbers[i]);
                queue.add(for_next.get(j) - numbers[i]);
            }
        }
        return (int)queue.stream()
                .filter(t -> t == target)
                .count();
    }



}
