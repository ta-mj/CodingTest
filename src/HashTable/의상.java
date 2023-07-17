package HashTable;

import java.util.HashMap;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String[] cloth : clothes){
            System.out.println(cloth[0] + "," + cloth[1]);
            if(hashMap.containsKey(cloth[1])){
                hashMap.put(cloth[1],hashMap.get(cloth[1]) + 1);
            }
            else{
                hashMap.put(cloth[1],1);
            }
        }
        for(String catecory : hashMap.keySet()){
            answer *= hashMap.get(catecory) + 1;
        }
        return answer - 1;
    }
}
