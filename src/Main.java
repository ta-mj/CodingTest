import java.util.Arrays;
import HashTable.베스트앨범;
public class Main {
    public static void main(String[] args) {
        베스트앨범 bestalbum = new 베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = bestalbum.solution(genres,plays);
        for(int i : result){
            System.out.println(i);
        }
    }
}