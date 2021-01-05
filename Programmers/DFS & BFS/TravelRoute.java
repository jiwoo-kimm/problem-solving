// 프로그래머스 '여행 경로'
// DFS & BFS
// 2021.01.05

import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {

    public static void main(String[] args) {
        for (String airport : solution(new String[][]{{"ICN", "ATL"}, {"SFO", "ICN"}, {"ICN", "SFO"}}))
            System.out.println(airport);
    }

    private static final int SRC = 0;
    private static final int DST = 1;

    private static ArrayList<String> answer = new ArrayList<>();
    private static String route = "";
    private static boolean[] visit;

    public static String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            visit = new boolean[tickets.length];
            String src = tickets[i][SRC];
            String dst = tickets[i][DST];

            if (src.equals("ICN")) {
                route = src + ",";
                visit[i] = true;
                dfs(tickets, dst, 1);
            }
        }
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    private static void dfs(String[][] tickets, String dst, int visitCount) {
        route += dst + ",";

        if (visitCount == tickets.length) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String nextSrc = tickets[i][SRC];
            String nextDst = tickets[i][DST];
            if (nextSrc.equals(dst) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, nextDst, visitCount + 1);
                visit[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}