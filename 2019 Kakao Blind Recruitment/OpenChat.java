// 2019 카카오 블라인드 채용
// 오픈채팅방
// 2021.03.04

import java.util.*;

class Solution {
        
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";

    private List<String> messages = new ArrayList<>();
    private Map<String, String> users = new HashMap<>();

    public String[] solution(String[] records) {
        getUsersFromRecords(records);
        writeMessages(records);
        return messages.toArray(new String[0]);
    }

    private void getUsersFromRecords(String[] records) {
        for (String record : records)
            parseLine(record);
    }

    private void parseLine(String record) {
        StringTokenizer tk = new StringTokenizer(record);
        switch (tk.nextToken()) {
            case ENTER, CHANGE -> addUser(tk);
        }
    }

    private void addUser(StringTokenizer tk) {
        String userId = tk.nextToken();
        String userName = tk.nextToken();
        users.put(userId, userName);
    }

    private void writeMessages(String[] records) {
        for (String record : records)
            writeMessage(record);
    }

    private void writeMessage(String record) {
        StringTokenizer tk = new StringTokenizer(record);
        switch (tk.nextToken()) {
            case ENTER -> writeEnter(tk.nextToken());
            case LEAVE -> writeLeave(tk.nextToken());
        }
    }

    private void writeEnter(String userId) {
        String userName = users.get(userId);
        messages.add(userName+"님이 들어왔습니다.");
    }

    private void writeLeave(String userId) {
        String userName = users.get(userId);
        messages.add(userName+"님이 나갔습니다.");
    }
}