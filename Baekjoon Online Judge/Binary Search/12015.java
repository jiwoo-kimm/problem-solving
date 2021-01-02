// 백준 12015 '가장 긴 증가하는 부분 수열 2'
// Binary Search
// 2020.08.13

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
    static int[] A;

    static int newNum;
    static int newNumPosition;
    static ArrayList<Integer> listLIS;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getInputs();
        initListLIS();
        findLIS();
        writeAnswer();

        br.close();
        bw.close();
    }

    private static void getInputs() throws IOException {
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        A = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tk.nextToken());
        }
    }

    private static void initListLIS() {
        listLIS = new ArrayList<>();
        listLIS.add(0);
    }

    private static void findLIS() {
        for (int i = 0; i < N; i++) {
            newNum = A[i];
            if (newNum > getLastNumberOfLIS())
                listLIS.add(newNum);
            else {
                findPositionOfNewNum();
                listLIS.set(newNumPosition, newNum);
            }
        }
    }

    private static int getLastNumberOfLIS() {
        return listLIS.get(listLIS.size() - 1);
    }

    private static void findPositionOfNewNum() {
        binarySearch(0, listLIS.size() - 1);
    }

    private static void binarySearch(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            newNumPosition = startIndex;
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;

        if (listLIS.get(midIndex) >= newNum)
            binarySearch(startIndex, midIndex - 1);
        else
            binarySearch(midIndex + 1, endIndex);
    }

    private static void writeAnswer() throws IOException {
        bw.write(Integer.toString(listLIS.size() - 1));
    }
}
