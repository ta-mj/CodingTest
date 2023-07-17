package HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<Integer,String> num_to_genre = new HashMap<>();
        HashMap<String,Integer> genre_to_play = new HashMap<>();
        for(int i = 0; i < genres.length ; i++) {
            num_to_genre.put(i, genres[i]);
            if (genre_to_play.containsKey(genres[i])) {
                genre_to_play.put(genres[i], genre_to_play.get(genres[i]) + plays[i]);
            } else {
                genre_to_play.put(genres[i], plays[i]);
            }
        }
        return answer;
    }
}
