// 2021 카카오 블라인드 채용 : 광고 삽입
// 2021.05.11

class Solution {

    private static final int MAX = 59 + 59 * 60 + 99 * 3600;
    private static final int START = 0;
    private static final int END = 1;

    private int playDuration;
    private int advDuration;
    private long[] viewers = new long[MAX + 1];

    public String solution(String play_time, String adv_time, String[] logs) {
        parseInputs(play_time, adv_time, logs);
        return findBestAdvStartTime();
    }

    private void parseInputs(String play_time, String adv_time, String[] logs) {
        playDuration = Time.parseTextToSeconds(play_time);
        advDuration = Time.parseTextToSeconds(adv_time);
        parseLogs(logs);
    }

    private void parseLogs(String[] logs) {
        for (String log : logs) {
            String[] times = log.split("-");
            viewers[Time.parseTextToSeconds(times[START])]++;
            viewers[Time.parseTextToSeconds(times[END])]--;
        }
        updateViewers();
    }

    private void updateViewers() {
        for (int time = 1; time <= playDuration; time++)
            viewers[time] += viewers[time - 1];
        for (int time = 1; time <= playDuration; time++)
            viewers[time] += viewers[time - 1];
    }

    private String findBestAdvStartTime() {
        int advStartSeconds = 0;
        long max = viewers[advDuration];

        int startTime = 0, endTime = startTime + advDuration;
        while (endTime <= playDuration) {
            long current = viewers[endTime] - viewers[startTime];
            if (current > max) {
                advStartSeconds = startTime + 1;
                max = current;
            }

            startTime++;
            endTime++;
        }
        return Time.parseSecondsToText(advStartSeconds);
    }
}

class Time {

    private static final int HOUR = 0;
    private static final int MINUTE = 1;
    private static final int SECOND = 2;
    private static final int MINUTE_UNIT = 60;
    private static final int HOUR_UNIT = MINUTE_UNIT * MINUTE_UNIT;
    private static final String SPLITTER = ":";
    private static final String ZERO = "0";

    public static int parseTextToSeconds(String text) {
        String[] chunks = text.split(SPLITTER);
        return Integer.parseInt(chunks[HOUR]) * HOUR_UNIT
                + Integer.parseInt(chunks[MINUTE]) * MINUTE_UNIT
                + Integer.parseInt(chunks[SECOND]);
    }

    public static String parseSecondsToText(int value) {
        StringBuilder sb = new StringBuilder();

        int hour = value / HOUR_UNIT;
        if (hour < 10) sb.append(ZERO);
        sb.append(value / HOUR_UNIT).append(SPLITTER);

        int minute = value % HOUR_UNIT / MINUTE_UNIT;
        if (minute < 10) sb.append(ZERO);
        sb.append(minute).append(SPLITTER);

        int second = value % MINUTE_UNIT;
        if (second < 10) sb.append(ZERO);
        sb.append(value % MINUTE_UNIT);

        return sb.toString();
    }
}