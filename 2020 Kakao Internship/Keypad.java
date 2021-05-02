// 2020 카카오 인턴십 : 키패드 누르기
// 2021.05.02

class Solution {
    
    private static final int ROW = 0;
    private static final int COL = 1;

    private int[] currentLeft = {3, 0};
    private int[] currentRight = {3, 2};

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers)
            sb.append(push(number, hand));
        return sb.toString();
    }

    private char push(int number, String handed) {
        int[] target = getPosition(number);
        char hand = whichHand(target, handed);
        moveHandToNumber(target, hand);
        return hand;
    }

    private char whichHand(int[] target, String handed) {
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

    private int dist(int[] current, int[] target) {
        return Math.abs(current[ROW] - target[ROW])
                + Math.abs(current[COL] - target[COL]);
    }

    private int[] getPosition(int targetNumber) {
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

    private void moveHandToNumber(int[] target, char hand) {
        if (hand == 'L') currentLeft = target;
        else if (hand == 'R') currentRight = target;
    }
}