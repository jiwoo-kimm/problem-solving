// 프로그래머스 Summer/Winter Coding(~2018)
// 스킬트리
// 2021.02.05


import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static int answer;
    private static List<Character> order = new ArrayList<>();

    public static int solution(String skill, String[] skill_trees) {
        for (char ch : skill.toCharArray()) order.add(ch);
        for (String skills : skill_trees) if (isAvailable(skills)) answer++;
        return answer;
    }

    private static boolean isAvailable(String skills) {
        boolean[] learned = new boolean[order.size()];
        for (char skill : skills.toCharArray()) {
            if (!order.contains(skill)) continue;
            for (int i = 0; i < order.indexOf(skill); i++) if (!learned[i]) return false;
            learned[order.indexOf(skill)] = true;
        }
        return true;
    }
}
