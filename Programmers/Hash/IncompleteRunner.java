// 프로그래머스 '완주하지 못한 선수'
// 해시
// 2021.01.20

import java.util.HashMap;
import java.util.Map;

public class IncompleteRunner {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        for (String person : participant) participants.put(person, participants.getOrDefault(person, 0) + 1);
        for (String person : completion) participants.put(person, participants.get(person) - 1);
        return participants.entrySet().stream().filter(entry -> entry.getValue() != 0).findFirst().get().getKey();
    }
}
