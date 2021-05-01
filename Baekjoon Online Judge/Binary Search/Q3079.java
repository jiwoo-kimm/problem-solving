// 백준 3079번 입국심사
// Binary Search
// 2021.05.01

import java.io.*;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int peopleCount;
    private static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        bw.append(String.valueOf(calcMinTime()));

        br.close();
        bw.close();
    }

    private static long calcMinTime() {
        long left = 1;
        long right = (long) peopleCount * times[times.length - 1];

        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long maxPeopleCount = getPeopleCount(mid, times);

            if (maxPeopleCount < peopleCount) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private static long getPeopleCount(long timeLimit, int[] times) {
        long count = 0;
        for (int time : times) count += timeLimit / time;
        return count;
    }

    private static void parseInput(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        peopleCount = Integer.parseInt(line[1]);

        times = new int[n];
        for (int i = 0; i < n; i++)
            times[i] = Integer.parseInt(br.readLine());
        Arrays.sort(times);
    }
}