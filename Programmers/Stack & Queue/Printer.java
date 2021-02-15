// 프로그래머스 '프린터'
// 2021.02.16

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    private static Queue<Document> queue;
    private static int answer;

    public static int solution(int[] priorities, int location) {
        queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) queue.offer(new Document(priorities[i], i));
        while (!queue.isEmpty()) {
            Document head = queue.poll();
            if (isPrintable(head)) {
                answer++;
                if (head.index == location) break;
            } else queue.offer(head);
        }
        return answer;
    }

    private static boolean isPrintable(Document head) {
        return queue.stream().noneMatch(document -> document.priority > head.priority);
    }
}

class Document {
    int priority;
    int index;

    public Document(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}