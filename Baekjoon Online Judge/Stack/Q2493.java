// 백준 2493번 탑
// Stack
// 2021.04.06

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q2493 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static List<Tower> towers = new ArrayList<>();
    private static List<Integer> receivers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput();
        countReceivers();
        writeAnswer();

        br.close();
        bw.close();
    }

    private static void parseInput() throws IOException {
        br.readLine();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++)
            towers.add(new Tower(i + 1, Integer.parseInt(line[i])));
    }

    private static void countReceivers() {
        Stack<Tower> stack = new Stack<>();
        for (Tower tower : towers) {
            while (!stack.isEmpty()) {
                if (stack.peek().height >= tower.height) {
                    receivers.add(stack.peek().index);
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) receivers.add(0);
            stack.push(tower);
        }
    }

    private static void writeAnswer() throws IOException {
        for (int receiver : receivers)
            bw.append(Integer.toString(receiver)).append(" ");
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}