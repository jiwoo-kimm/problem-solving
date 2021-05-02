package kakaointern2020;

public class Keypad {

    public static void main(String[] args) {
//        System.out.println(solution(
//                new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
//                "right"
//        ));
        System.out.println(solution(
                new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                "left"
        ));
        System.out.println(solution(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                "right"
        ));
    }

    private static final int ROW = 0;
    private static final int COL = 1;

    private static int[] currentLeft = {3, 0};
    private static int[] currentRight = {3, 2};

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers)
            sb.append(push(number, hand));
        return sb.toString();
    }

    private static char push(int number, String handed) {
        int[] target = getPosition(number);
        char hand = whichHand(target, handed);
        moveHandToNumber(target, hand);
        return hand;
    }

    private static char whichHand(int[] target, String handed) {
        if (target[COL] == 0) return 'L';
        else if (target[COL] == 2) return 'R';

        char hand;
        int leftDist = dist(currentLeft, target);
        int rightDist = dist(currentRight, target);
        if (leftDist < rightDist) hand = 'L';
        else if (leftDist > rightDist) hand = 'R';
        else hand = (handed.equals("left") ? 'L' : 'R');
        return hand;
    }

    private static int dist(int[] current, int[] target) {
        return Math.abs(current[ROW] - target[ROW])
                + Math.abs(current[COL] - target[COL]);
    }

    private static int[] getPosition(int targetNumber) {
        int[] position = new int[2];
        if (targetNumber == 0) {
            position[ROW] = 3;
            position[COL] = 1;
        } else if (targetNumber % 3 == 1) {
            position[ROW] = targetNumber / 3;
            position[COL] = 0;
        } else if (targetNumber % 3 == 2) {
            position[ROW] = targetNumber / 3;
            position[COL] = 1;
        } else if (targetNumber % 3 == 0) {
            position[ROW] = targetNumber / 3 - 1;
            position[COL] = 2;
        }
        return position;
    }

    private static void moveHandToNumber(int[] target, char hand) {
        if (hand == 'L') currentLeft = target;
        else if (hand == 'R') currentRight = target;
    }
}
