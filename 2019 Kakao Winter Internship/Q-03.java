// 2019 카카오 겨울 인턴십
// 불량 사용자
// 2021.01.06

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    private static String[] userId;
    private static String[] bannedId;
    private static Set<Set<String>> result = new HashSet<>();

    public static int solution(String[] user_id, String[] banned_id) {
        initParams(user_id, banned_id);
        dfs(new LinkedHashSet<>());
        return result.size();
    }

    private static void initParams(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
    }

    private static void dfs(Set<String> set) {
        if (set.size() == bannedId.length) {
            if (setMatches(set))
                result.add(new HashSet<>(set));
            return;
        }

        for (String user : userId) {
            if (!set.contains(user)) {
                set.add(user);
                dfs(set);
                set.remove(user);
            }
        }
    }

    private static boolean setMatches(Set<String> set) {
        int i = 0;
        for (String user : set)
            if (!stringMatches(user, bannedId[i++]))
                return false;
        return true;
    }

    private static boolean stringMatches(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}
