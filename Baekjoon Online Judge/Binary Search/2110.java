// 백준 2110 '공유기 설치'
// Binary Search
// 2020.08.11

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;               // 집의 개수
    static int C;               // 공유기 개수
    static int[] houses;        // 집의 좌표
    static int maxDistance;    // 가장 인접한 두 공유기 사이 최대 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input (N, C, array)
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            houses[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(houses);
        getMaxDistance(1, getDistance(0, N - 1));

        bw.write(Integer.toString(maxDistance));

        br.close();
        bw.close();
    }

    private static void getMaxDistance(int min, int max) {
        if (min > max)
            return;

        int mid = (min + max) / 2;
        int houseCountOnMid = getHouseCountForCurrentDistance(mid);

        if (houseCountOnMid >= C) {
            maxDistance = mid;
            getMaxDistance(mid + 1, max);
        } else {
            getMaxDistance(min, mid - 1);
        }
    }

    private static int getHouseCountForCurrentDistance(int currentDistance) {
        int houseCount = 1;
        int previousHouseIndex = 0;
        for (int i = 1; i < N; i++) {
            if (getDistance(previousHouseIndex, i) >= currentDistance) {
                houseCount++;
                previousHouseIndex = i;
            }
        }
        return houseCount;
    }

    private static int getDistance(int leftIndex, int rightIndex) {
        return houses[rightIndex] - houses[leftIndex];
    }
}
