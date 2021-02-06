// 2018 카카오 블라인드 채용
// 추석 트래픽
// 2021.02.06

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Thanksgiving {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));

        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));

        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        }));

        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));
    }

    private static final int UNIT = 999;

    private static List<Log> logs;
    private static int answer;

    public static int solution(String[] lines) {
        parseLogs(lines);
        checkLogs();
        return answer;
    }

    private static void parseLogs(String[] lines) {
        logs = new ArrayList<>();
        for (String line : lines) {
            StringTokenizer tk = new StringTokenizer(line);
            tk.nextToken();
            logs.add(new Log(tk.nextToken(), tk.nextToken()));
        }
    }

    private static void checkLogs() {
        for (Log log : logs) answer = Math.max(countMaximum(log), answer);
    }

    private static int countMaximum(Log standard) {
        int onStart = 0, onEnd = 0;
        for (Log log : logs) {
            if (isInRange(log, standard.startTime.value)) onStart++;
            if (isInRange(log, standard.endTime.value)) onEnd++;
        }
        return Math.max(onStart, onEnd);
    }

    private static boolean isInRange(Log log, long start) {
        long end = start + UNIT;
        return (log.endTime.value >= start && log.endTime.value <= end) || (log.startTime.value >= start && log.startTime.value <= end) || (log.startTime.value <= start && log.endTime.value >= end);
    }
}

class Log {
    MyTime startTime;
    MyTime endTime;
    long duration;

    public Log(String endTime, String duration) {
        this.endTime = parseTime(endTime);
        this.duration = parseDuration(duration);
        this.startTime = new MyTime(this.endTime.value - this.duration + 1);
    }

    private MyTime parseTime(String time) {
        return new MyTime(Time.valueOf(time.substring(0, 8)), time.substring(9));
    }

    private long parseDuration(String chunk) {
        return (long) (Double.parseDouble(chunk.substring(0, chunk.length() - 1)) * 1000);
    }
}

class MyTime {
    long value;

    public MyTime(Time time, String millisecond) {
        this.value = time.getTime() + Long.parseLong(millisecond);
    }

    public MyTime(long value) {
        this.value = value;
    }
}