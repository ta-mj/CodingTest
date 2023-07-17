package HashTable;

import java.util.HashSet;
import java.util.Iterator;

public class 전화번호_목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hashSet = new HashSet<>();
        for(String number : phone_book){
            Iterator<String> it = hashSet.iterator();
            while(it.hasNext()){
                String prefix = it.next();
                if(prefix.length() > number.length()){
                    if(prefix.startsWith(number)){
                        return false;
                    }
                }
                else if(prefix.length() == number.length()){
                    if(prefix.equals(number)){
                        return false;
                    }
                }
                else{
                    if(number.startsWith(prefix)){
                        return false;
                    }
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
