// 백준 12015 '가장 긴 증가하는 부분 수열 2'
// Binary Search
// 2020.08.13, 2021.04.21

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        int answer = findLISLength();
        bw.append(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(line[i]);
    }

    private static int findLISLength() {
        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        for (int i = 0; i < n; i++)
            if (arr[i] > lis.get(lis.size() - 1)) lis.add(arr[i]);
            else lis.set(findIndex(lis, arr[i]), arr[i]);
        return lis.size() - 1;
    }

    private static int findIndex(List<Integer> lis, int current) {
        int left = 0, right = lis.size() - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (current > lis.get(mid)) left = mid + 1;
            else right = mid;
        }
        return (left + right) / 2;
    }
}