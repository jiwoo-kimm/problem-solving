// 프로그래머스 '베스트앨범'
// 해시
// 2021.01.21, 2021.08.24

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Set<String> distinctGenres = new HashSet<>();
        Map<String, Integer> countPerGenre = new HashMap<>();
        Map<String, PriorityQueue<Integer>> songsPerGenre = new HashMap<>();
        
        for (String each : genres) {
            distinctGenres.add(each);
            songsPerGenre.put(each, new PriorityQueue<>((o1, o2) -> plays[o2] - plays[o1]));
        }
        
        for (int i=0 ; i<n ; i++) {
            countPerGenre.put(genres[i], countPerGenre.getOrDefault(genres[i], 0) + plays[i]);
            songsPerGenre.get(genres[i]).offer(i);
        }
        
        List<String> genresInOrder = new ArrayList<>(distinctGenres);
        Collections.sort(genresInOrder, (o1, o2) -> countPerGenre.get(o2) - countPerGenre.get(o1));
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : genresInOrder) {
            PriorityQueue<Integer> pq = songsPerGenre.get(genre);
            answer.add(pq.poll());
            if (!pq.isEmpty()) {
                answer.add(pq.poll());
            }
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}