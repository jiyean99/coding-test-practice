package programmers;

import java.util.HashMap;
import java.util.Map;

// 해시 | 베스트앨범
public class H42579 {
    public static void main(String[] args) {
//        genres : 노래의 장르 배열
//        plays : 노래별 재생 횟수
        // output: 장르별로 많이 재생된 노래의 고유값 두개씩 모아 출력
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 1. 장르별 총 재생횟수
        Map<String, Integer> genreTotal = new HashMap<>();

        // 2. 장르별 {인덱스:재생횟수} 맵
        Map<String, Map<Integer, Integer>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], plays[i]);
//            genreSongs.put(genres[i], genreTotal.get(i));
        }
//        for(int i = 0 ; i < genres.length; i++){
//            index_map.put(i, plays[i]);
//        }
//        System.out.println(index_map);

    }
}
