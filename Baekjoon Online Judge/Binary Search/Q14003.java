// 백준 14003번 가장 긴 증가하는 부분 수열 5
// Binary Search
// 2021.04.21

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int INITIAL = -1;

    private static int n;
    private static int[] arr;
    private static int[] before;
    private static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        findLIS();
        writeAnswer(bw);

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(line[i]);
    }

    private static void findLIS() {
        before = new int[n];
        before[0] = INITIAL;
        lis.add(0);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[lis.get(lis.size() - 1)]) {
                before[i] = lis.get(lis.size() - 1);
                lis.add(i);
            } else {
                int replaceIndex = findIndex(i);
                before[i] = (replaceIndex > 0 ? lis.get(replaceIndex - 1) : INITIAL);
                lis.set(replaceIndex, i);
            }
        }
    }

    private static int findIndex(int current) {
        int left = 0, right = lis.size() - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[current] > arr[lis.get(mid)]) left = mid + 1;
            else right = mid;
        }
        return (left + right) / 2;
    }

    private static void writeAnswer(BufferedWriter bw) throws IOException {
        bw.append(String.valueOf(lis.size())).append("\n");
        writeArr(bw, lis.get(lis.size() - 1));
    }

    private static void writeArr(BufferedWriter bw, int index) throws IOException {
        if (before[index] == INITIAL) {
            bw.append(String.valueOf(arr[index])).append(" ");
            return;
        }
        writeArr(bw, before[index]);
        bw.append(String.valueOf(arr[index])).append(" ");
    }
}