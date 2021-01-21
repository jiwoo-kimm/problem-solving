// 프로그래머스 '베스트앨범'
// 해시
// 2021.01.21

import java.util.*;

public class BestAlbum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCounts = new HashMap<>();
        Map<String, ArrayList<Song>> songsPerGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCounts.put(genres[i], genreCounts.getOrDefault(genres[i], 0) + plays[i]);
            if (!songsPerGenre.containsKey(genres[i])) {
                ArrayList<Song> newGenre = new ArrayList<>();
                newGenre.add(new Song(i, genres[i], plays[i]));
                songsPerGenre.put(genres[i], newGenre);
            } else songsPerGenre.get(genres[i]).add(new Song(i, genres[i], plays[i]));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        genreCounts.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue()))
                .forEach(entry -> {
                    ArrayList<Song> targets = songsPerGenre.get(entry.getKey());
                    targets.sort(Comparator.comparingInt(o -> -o.play));
                    answer.add(targets.get(0).index);
                    if (targets.size() > 1) answer.add(targets.get(1).index);
                });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {

    int index;
    String genre;
    int play;

    public Song(int index, String genre, int play) {
        this.index = index;
        this.genre = genre;
        this.play = play;
    }
}
