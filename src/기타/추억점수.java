package 기타;

import java.util.ArrayList;
import java.util.HashMap;

public class 추억점수 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String,Integer> yearning_for_name = new HashMap<>();
        for(int i = 0 ; i < name.length ; i++){
            yearning_for_name.put(name[i],yearning[i]);
        }
        ArrayList<Integer> rateList = new ArrayList();
        for(String[] people : photo){
            int rate = 0;
            for(String person : people){
                if(yearning_for_name.containsKey(person)) {
                    rate += yearning_for_name.get(person);
                }
            }
            rateList.add(rate);
        }
        answer = new int[rateList.size()];
        for(int i = 0 ; i < rateList.size() ; i++){
            answer[i] = rateList.get(i);
        }
        return answer;
    }
    public static void main(String args[]){
        String[] name = {"kim","park","lee"};
        int[] yearning = {1,2,3};
        String[][] photo = {{"kim","park"},{"kim","lee","park"}};
        int[] result = solution(name,yearning,photo);
        for(int rate : result){
            System.out.println(rate);
        }
    }
}
