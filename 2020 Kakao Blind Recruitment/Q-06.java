// 2020 카카오 블라인드 채용
// 외벽 점검
// 2021.01.27

public class WallCheck {

    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println(solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }

    private static int wall;
    private static int[] distances;
    private static int[][] rotatedWeak;
    private static int[] friends;
    private static int count;
    private static boolean isFinished = false;

    public static int solution(int n, int[] weak, int[] dist) {
        wall = n;
        distances = dist;
        initRotatedWeak(weak);

        for (int i = 1; i <= dist.length; i++) {
            count = i;
            friends = new int[count];
            permutation(0, new boolean[dist.length]);
            if (isFinished) break;
        }

        return (isFinished) ? count : -1;
    }

    private static void initRotatedWeak(int[] weak) {
        rotatedWeak = new int[weak.length][weak.length];
        for (int i = 0; i < weak.length; i++) rotatedWeak[i] = rotate(weak, i);
    }

    private static int[] rotate(int[] weak, int count) {
        int[] result = new int[weak.length];
        for (int i = 0; i < weak.length; i++)
            if (i + count < weak.length) result[i] = weak[i + count];
            else result[i] = weak[i + count - weak.length] + wall;
        return result;
    }

    private static void permutation(int depth, boolean[] visit) {
        if (isFinished) return;

        if (depth == count) {
            validateCase();
            return;
        }

        for (int i = 0; i < distances.length; i++) {
            if (!visit[i]) {
                friends[depth] = distances[i];
                visit[i] = true;
                permutation(depth + 1, visit);
                visit[i] = false;
            }
        }
    }

    private static void validateCase() {
        for (int[] weak : rotatedWeak) {
            boolean[] visited = new boolean[weak.length];
            int index = 0, start = 0;

            while (index != count) {
                int i = start;
                int value = friends[index++];

                for (int j = start; j < weak.length; j++) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) break;
                    visited[j] = true;
                    start++;
                }

                if (isFinish(visited)) {
                    isFinished = true;
                    return;
                }
            }
        }
    }

    private static boolean isFinish(boolean[] visited) {
        for (boolean bool : visited)
            if (!bool) return false;
        return true;
    }
}
