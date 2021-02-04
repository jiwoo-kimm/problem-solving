// 프로그래머스 스택/큐
// 기능개발
// 2021.02.04


import java.util.*;

public class FunctionDevelopment {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Function> functions = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) functions.offer(new Function(progresses[i], speeds[i]));

        int day = 0, count = 0;
        List<Integer> answer = new ArrayList<>();
        while (!functions.isEmpty()) {
            while (functions.peek().progress + day * functions.peek().speed >= 100) {
                functions.poll();
                count++;
                if (functions.isEmpty()) break;
            }
            if (count != 0) {
                answer.add(count);
                count = 0;
            }
            day++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Function {
    int progress;
    int speed;

    public Function(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}
