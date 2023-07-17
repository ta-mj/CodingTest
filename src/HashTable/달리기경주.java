package HashTable;


import java.util.HashMap;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();
        int rank = 0;
        for(String player : players){
            hashMap.put(player,rank);
            rank++;
        }
        for(String call : callings){
            int index = hashMap.get(call);
            String caught = players[index - 1];
            players[index] = caught;
            players[index - 1] = call;
            hashMap.put(call,index - 1);
            hashMap.put(caught,index);
        }
        answer = players.clone();
        return answer;
    }
}
