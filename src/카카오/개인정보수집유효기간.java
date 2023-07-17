package 카카오;

import java.util.ArrayList;
import java.util.HashMap;

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int year_today = Integer.parseInt(today.split("\\.")[0]) * 12 * 28;
        int month_today = Integer.parseInt(today.split("\\.")[1]) * 28;
        int day_today = Integer.parseInt(today.split("\\.")[2]);
        int days_today = year_today + month_today + day_today;
        HashMap<String,Integer> term_map = new HashMap<>();
        for(String term : terms){
            term_map.put(term.split(" ")[0],Integer.parseInt(term.split(" ")[1]) * 28);
        }
        //개인정보 번호를 저장하기 위한 ArrayLIst와 index
        ArrayList<Integer> privacy_list = new ArrayList<>();
        int index = 1;
        for(String privacy : privacies){
            String date = privacy.split(" ")[0];
            int term = term_map.get(privacy.split(" ")[1]);
            int year = Integer.parseInt(date.split("\\.")[0]) * 12 * 28;
            int month = Integer.parseInt(date.split("\\.")[0]) * 28;
            int day = Integer.parseInt(date.split("\\.")[0]);
            int days_term = year + month + day + term;
            if(days_today >= days_term) {
                privacy_list.add(index);
            }
            index++;
        }
        answer = new int[privacy_list.size()];
        for(int i = 0; i < privacy_list.size() ; i++){
            answer[i] = privacy_list.get(i);
        }
        return answer;
    }
}
