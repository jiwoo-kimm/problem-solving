import java.util.*;

public class OpenChat {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]
                {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";

    private static List<String> messages = new ArrayList<>();
    private static Map<String, String> users = new HashMap<>();

    public static String[] solution(String[] records) {
        getUsersFromRecords(records);
        writeMessages(records);
        return messages.toArray(new String[0]);
    }

    private static void getUsersFromRecords(String[] records) {
        for (String record : records)
            parseLine(record);
    }

    private static void parseLine(String record) {
        StringTokenizer tk = new StringTokenizer(record);
        switch (tk.nextToken()) {
            case ENTER, CHANGE -> addUser(tk);
        }
    }

    private static void addUser(StringTokenizer tk) {
        String userId = tk.nextToken();
        String userName = tk.nextToken();
        users.put(userId, userName);
    }

    private static void writeMessages(String[] records) {
        for (String record : records)
            writeMessage(record);
    }

    private static void writeMessage(String record) {
        StringTokenizer tk = new StringTokenizer(record);
        switch (tk.nextToken()) {
            case ENTER -> writeEnter(tk.nextToken());
            case LEAVE -> writeLeave(tk.nextToken());
        }
    }

    private static void writeEnter(String userId) {
        String userName = users.get(userId);
        messages.add(userName+"님이 들어왔습니다.");
    }

    private static void writeLeave(String userId) {
        String userName = users.get(userId);
        messages.add(userName+"님이 나갔습니다.");
    }
}