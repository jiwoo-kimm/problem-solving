// 2018 카카오 블라인드 채용
// 셔틀버스
// 2021.03.10

import java.util.*;

class Solution {
    
    private static final int TIME = 0;
    private static final int MINUTE = 1;
    private static final int TIME_UNIT = 60;
    private static final int FIRST_BUS_TIME = 9 * TIME_UNIT;

    private int busCount;
    private int busInterval;
    private int maxCrewCountPerBus;
    private PriorityQueue<Integer> crews = new PriorityQueue<>();

    public String solution(int n, int t, int m, String[] timetable) {
        initParams(n, t, m, timetable);
        int timeValue = findTheLatestInLineTime();
        return parseTimeValueToString(timeValue);
    }

    private void initParams(int n, int t, int m, String[] timetable) {
        busCount = n;
        busInterval = t;
        maxCrewCountPerBus = m;
        parseTimetable(timetable);
    }

    private void parseTimetable(String[] timetable) {
        for (String time : timetable)
            crews.offer(parseTimeStringToValue(time));
    }

    private int parseTimeStringToValue(String timeStr) {
        String[] result = timeStr.split(":");
        return Integer.parseInt(result[TIME]) * TIME_UNIT + Integer.parseInt(result[MINUTE]);
    }

    private int findTheLatestInLineTime() {
        int busArrival = FIRST_BUS_TIME;
        int corn = FIRST_BUS_TIME;

        for (int currentBusIndex = 0; currentBusIndex < busCount; currentBusIndex++) {
            int crewOnBus = 0;
            for (int i = 0; i < maxCrewCountPerBus; i++) {
                if (!crews.isEmpty()) {
                    int nextCrew = crews.peek();
                    if (nextCrew <= busArrival) {
                        corn = crews.poll();
                        crewOnBus++;
                    }
                }
                if (currentBusIndex == busCount - 1) {
                    if (crewOnBus == maxCrewCountPerBus) corn--;
                    else if (crewOnBus < maxCrewCountPerBus) corn = busArrival;
                }
            }
            busArrival += busInterval;
        }
        return corn;
    }

    private String parseTimeValueToString(int timeValue) {
        StringBuilder sb = new StringBuilder();
        if ((timeValue / TIME_UNIT < 10)) sb.append("0" + timeValue / TIME_UNIT);
        else sb.append(timeValue / TIME_UNIT);
        sb.append(":");
        if ((timeValue % TIME_UNIT < 10)) sb.append("0" + timeValue % TIME_UNIT);
        else sb.append(timeValue % TIME_UNIT);
        return sb.toString();
    }
}