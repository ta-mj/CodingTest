package HashTable;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String person : participant){
            if(hashMap.containsKey(person)){
                hashMap.put(person,hashMap.get(person) + 1);
            }
            else{
                hashMap.put(person, 1);
            }
        }
        for(String person : completion){
            hashMap.put(person,hashMap.get(person) - 1);
        }
        for(String person : hashMap.keySet()){
            if(hashMap.get(person) != 0){
                return person;
            }
        }
        return "";
    }
}
