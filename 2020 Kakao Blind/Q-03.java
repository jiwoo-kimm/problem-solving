// 2020 카카오 블라인드 채용 '자물쇠와 열쇠'
// 2021.01.24

import java.util.Arrays;

public class LockAndKey {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    private static int targetUnlockCount;
    private static int[][] paddingLock;

    public static boolean solution(int[][] key, int[][] lock) {
        getTargetUnlockCount(lock);
        getPaddingLock(key, lock);
        for (int i = 0; i < 4; i++) {
            key = rotateKey(key);
            if (movedKeyFitsLock(key)) return true;
        }
        return false;
    }

    private static void getTargetUnlockCount(int[][] lock) {
        for (int[] row : lock)
            for (int cell : row)
                if (cell == 0) targetUnlockCount++;
    }

    private static void getPaddingLock(int[][] key, int[][] lock) {
        int newLength = lock.length + 2 * (key.length - 1);
        paddingLock = new int[newLength][newLength];
        for (int[] row : paddingLock) Arrays.fill(row, -1);
        for (int i = 0; i < lock.length; i++)
            for (int j = 0; j < lock.length; j++)
                paddingLock[i + (key.length - 1)][j + (key.length - 1)] = lock[i][j];
    }

    private static int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; ++i)
            for (int j = 0; j < key.length; ++j)
                newKey[i][j] = key[key.length - 1 - j][i];
        return newKey;
    }

    private static boolean movedKeyFitsLock(int[][] key) {
        for (int i = -20; i <= paddingLock.length; i++)
            for (int j = -20; j <= paddingLock.length; j++)
                if (keyFitsLock(key, i, j)) return true;
        return false;
    }

    private static boolean keyFitsLock(int[][] key, int x, int y) {
        int unlockCount = 0;
        for (int i = 0; i < key.length; ++i)
            for (int j = 0; j < key.length; ++j) {
                int newY = y + i;
                int newX = x + j;
                if (isInRange(newY, newX, paddingLock))
                    if (key[i][j] == 1 && paddingLock[newY][newX] == 0) unlockCount++;
                    else if (key[i][j] == 1 && paddingLock[newY][newX] == 1) return false;
            }
        return unlockCount == targetUnlockCount;
    }

    private static boolean isInRange(int y, int x, int[][] lock) {
        return y >= 0 && y < lock.length && x >= 0 && x < lock.length;
    }
}