package HashTable;

import java.util.HashSet;
import java.util.Iterator;

public class 전화번호_목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hashSet = new HashSet<>();
        for(String number : phone_book){
            hashSet.add(number);
        }
        for(String number : phone_book){
            hashSet.remove(number);
            for(int i = 0 ; i < number.length() ; i++){
                if(hashSet.contains(number.substring(0,i))){
                    return false;
                }
            }
            hashSet.add(number);
        }
        return answer;
    }
    public static void main(String args[]){
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));

    }
}
