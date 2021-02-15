// 프로그래머스 '다리를 지나는 트럭'
// 2021.02.13

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {

    public static void main(String[] args) {
        System.out.println(solution(1, 2, new int[]{1, 1, 1}));
        System.out.println(solution(1, 1, new int[]{1, 1, 1}));
        System.out.println(solution(4, 2, new int[]{1, 1, 1, 1}));
        System.out.println(solution(3, 3, new int[]{1, 1, 1}));
        System.out.println(solution(3, 1, new int[]{1, 1, 1}));
        System.out.println(solution(5, 5, new int[]{1, 1, 1, 1, 2, 2}));
        System.out.println(solution(7, 7, new int[]{1, 1, 1, 1, 3, 3}));
        System.out.println(solution(5, 5, new int[]{1, 1, 1, 1, 2, 2, 2, 2}));
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1}));
//        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
//        System.out.println(solution(100, 100, new int[]{10}));
//        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    private static final int EMPTY = 0;
    private static int weightSum;
    private static Queue<Integer> bridge;
    private static int answer;

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        answer = 0;
        weightSum = 0;
        bridge = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    addTruckOnBridge(truck);
                    break;
                }

                if (bridge.size() == bridge_length) {
                    weightSum -= bridge.poll();
                } else if (weightSum + truck <= weight) {
                    addTruckOnBridge(truck);
                    break;
                } else {
                    addTruckOnBridge(EMPTY);
                }
            }
        }

        return answer + bridge_length;
    }

    private static void addTruckOnBridge(int truck) {
        bridge.offer(truck);
        weightSum += truck;
        answer++;
    }
}