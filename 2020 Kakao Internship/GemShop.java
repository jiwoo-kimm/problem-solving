package kakaointern2020;

import java.util.*;
import java.util.stream.Collectors;

public class GemShop {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "DIA", "EM", "EM", "RUB", "DIA"
        })));
        System.out.println(Arrays.toString(solution(new String[]{
                "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "RUBY"
        })));
        System.out.println(Arrays.toString(solution(new String[]{
                "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
        })));
        System.out.println(Arrays.toString(solution(new String[]{
                "AA", "AB", "AC", "AA", "AC"
        })));
        System.out.println(Arrays.toString(solution(new String[]{
                "XYZ", "XYZ", "XYZ"
        })));
        System.out.println(Arrays.toString(solution(new String[]{
                "ZZZ", "YYY", "NNNN", "YYY", "BBB"
        })));
    }

    private static final int START = 0;
    private static final int END = 1;

    private static Set<String> targetGems = new HashSet<>();
    private static int[] answer = new int[2];

    public static int[] solution(String[] gems) {
        targetGems.addAll(Arrays.stream(gems).collect(Collectors.toList()));
        findMinSection(gems);
        return answer;
    }

    private static void findMinSection(String[] gems) {
        Set<String> types = new HashSet<>();
        Queue<Gem> queue = new LinkedList<>();
        for (int i = 0; i < gems.length; i++) {
            Gem gem = new Gem(gems[i], i + 1);
            if (!queue.isEmpty())
                if (queue.peek().name.equals(gem.name))
                    queue.poll();
            queue.offer(gem);
            verifyMinSection(queue);

            types.add(gem.name);
            if (types.size() == targetGems.size()) {
                int minLength = answer[END] - answer[START] + 1;
                int newStart = (queue.isEmpty() ? gem.index : queue.peek().index);
                int newEnd = gem.index;
                if (answer[START] == 0 && answer[END] == 0) {
                    answer[START] = newStart;
                    answer[END] = newEnd;
                } else if (newEnd - newStart + 1 < minLength) {
                    answer[START] = newStart;
                    answer[END] = newEnd;
                }
            }
        }
    }

    private static void verifyMinSection(Queue<Gem> queue) {
        if (queue.isEmpty()) return;

        Queue<Gem> tmp = new LinkedList<>(queue);
        Gem before = tmp.poll();
        Gem current;
        while (!tmp.isEmpty()) {
            current = tmp.poll();
            if (before.name.equals(current.name)) {
                queue.poll();
                before = current;
            } else return;
        }
    }
}

class Gem {
    String name;
    int index;

    public Gem(String name, int index) {
        this.name = name;
        this.index = index;
    }
}