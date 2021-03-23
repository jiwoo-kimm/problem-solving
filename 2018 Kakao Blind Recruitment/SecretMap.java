// 2018 카카오 블라인드 채용
// 비밀지도
// 2021.03.23

class Solution {
    
    private int N;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        N = n;
        int[][] resultMap = mergeMaps(getMapFromArr(arr1), getMapFromArr(arr2));
        return parseMap(resultMap);
    }

    private int[][] getMapFromArr(int[] arr) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            int divider = (int) Math.pow(2, N - 1);
            for (int j = 0; j < N; j++) {
                if (arr[i] / divider > 0) {
                    result[i][j] = 1;
                    arr[i] -= divider;
                } else result[i][j] = 0;
                divider /= 2;
            }
        }
        return result;
    }

    private int[][] mergeMaps(int[][] map1, int[][] map2) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                result[i][j] = map1[i][j] + map2[i][j];
        return result;
    }

    private String[] parseMap(int[][] map) {
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++)
                if (map[i][j] == 0) sb.append(" ");
                else sb.append("#");
            result[i] = sb.toString();
        }
        return result;
    }
}