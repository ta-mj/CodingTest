package HashTable;

import java.util.HashMap;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            if(!hashMap.containsKey(num)){
                hashMap.put(num,1);
            }
            else{
                hashMap.put(num,hashMap.get(num) + 1);
            }
        }
        if(hashMap.keySet().size() >= nums.length / 2){
            return answer;
        }
        else{
            return hashMap.keySet().size();
        }
    }
}
