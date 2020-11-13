class Solution {

    static final int ROW = 0;
    static final int COL = 1;

    static int[] currentLeft = {3, 0};
    static int[] currentRight = {3, 2};
    static int[] target = new int[2];
    static String handed;

    public String solution(int[] numbers, String hand) {
        setHanded(hand);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            setTargetPosition(number);
            String nextMoveHand = getNextMoveHand(number);
            moveHandToTarget(nextMoveHand);
            sb.append(nextMoveHand);
        }
        return sb.toString();
    }

    private void setHanded(String hand) {
        if (hand.equals("right")) handed = "R";
        else handed = "L";
    }

    private String getNextMoveHand(int number) {
        switch (number) {
            case 1:
            case 4:
            case 7:
                return "L";
            case 3:
            case 6:
            case 9:
                return "R";
            default:
                return getNextMoveHandByDistance();
        }
    }

    private String getNextMoveHandByDistance() {
        int leftDistance = getDistanceForLeft();
        int rightDistance = getDistanceForRight();
        return getCloserHand(leftDistance, rightDistance);
    }

    private void setTargetPosition(int number) {
        target[ROW] = (number - 1) / 3;
        target[COL] = (number + 2) % 3;
        if (number == 0) {
            target[ROW] = 3;
            target[COL] = 1;
        }
    }

    private int getDistanceForLeft() {
        int rowDistance = Math.abs(currentLeft[ROW] - target[ROW]);
        int colDistance = Math.abs(currentLeft[COL] - target[COL]);
        return rowDistance + colDistance;
    }

    private int getDistanceForRight() {
        int rowDistance = Math.abs(currentRight[ROW] - target[ROW]);
        int colDistance = Math.abs(currentRight[COL] - target[COL]);
        return rowDistance + colDistance;
    }

    private String getCloserHand(int leftDistance, int rightDistance) {
        if (leftDistance > rightDistance) return "R";
        else if (leftDistance < rightDistance) return "L";
        else return handed;
    }

    private void moveHandToTarget(String nextMove) {
        if (nextMove.equals("R")) {
            currentRight[ROW] = target[ROW];
            currentRight[COL] = target[COL];
        } else if (nextMove.equals("L")) {
            currentLeft[ROW] = target[ROW];
            currentLeft[COL] = target[COL];
        }
    }
}