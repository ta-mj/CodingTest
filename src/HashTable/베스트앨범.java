package HashTable;

import java.lang.reflect.Array;
import java.util.*;

public class 베스트앨범 {
    //장르별로 가장 많이 재생된 2개의 노래를 모아서 앨범으로 출시
    //장르별 정렬 후 그 장르 안의 많이 재생된 노래 2개 수록
    //재생횟수 같으면 고유번호 낮은 노래를 먼저 수록
    //장르에 곡이 하나만 속해있다면 하나의 곡만 수록
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Genre> hashMap = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            Song s = new Song(i,plays[i]);
            if(!hashMap.containsKey(genres[i])){
                hashMap.put(genres[i],new Genre(genres[i]));

            }
            hashMap.get(genres[i]).addSong(s);
        }
        List<Map.Entry<String,Genre>> sortedList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(sortedList,new GenreComparator());

        ArrayList<Integer> answerList = new ArrayList<>();
        for(Map.Entry<String,Genre> e : sortedList){
            Genre g = e.getValue();
            g.sort();
            System.out.println(g.name);
            for(Song i : g.songs){
                System.out.println(i.num);
            }
            if(g.numSong == 1){
                answerList.add(g.getFirst().num);
            }
            else{
                answerList.add(g.getFirst().num);
                answerList.add(g.getSecond().num);
            }

        }
        System.out.println("!!!");
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public class Genre{
        String name;
        int numSong;
        int totalPlay;
        ArrayList<Song> songs;
        public Genre(String n){
            name = n;
            numSong = 0;
            totalPlay = 0;
            songs = new ArrayList<>();
        }
        public void sort(){
            Collections.sort(songs, new SongComparator());
        }
        public void addSong(Song s){
            songs.add(s);
            s.addGenre(this);
            numSong++;
            totalPlay += s.play;
        }
        public Song getFirst(){
            return songs.get(0);
        }
        public Song getSecond(){
            return songs.get(1);
        }
    }
    public class GenreComparator implements Comparator<Map.Entry<String,Genre>>{
        @Override
        public int compare(Map.Entry<String, Genre> o1, Map.Entry<String, Genre> o2) {
            int g1 = o1.getValue().totalPlay;
            int g2 = o2.getValue().totalPlay;
            if(g1>g2){
                return -1;
            }
            else if(g1 == g2){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
    public class Song{
        Genre genre;
        int num;
        int play;
        public Song(int num, int play){
            this.num = num;
            this.play = play;
        }
        public void addGenre(Genre s){
            genre = s;
        }
    }
    public class SongComparator implements Comparator<Song>{
        @Override
        public int compare(Song o1, Song o2) {
            if(o1.play > o2.play){
                return -1;
            }
            else if(o1.play == o2.play){
                return 0;
            }
            else{
                return 1;
            }
        }
    }

}
