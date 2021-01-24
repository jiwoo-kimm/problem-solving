// 2020 카카오 블라인드 채용 '문자열 압축'
// 2021.01.22

public class SummarizeString {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        if (s.length() == 1) return 1;

        int answer = 1001;
        for (int length = s.length() / 2; length > 0; length--) {
            String current, next = "", result = "";
            int repeat = 1;
            for (int count = 0; count <= s.length() / length; count++) {
                current = next;
                int start = count * length;
                int end = Math.min(length * (count + 1), s.length());
                next = s.substring(start, end);

                if (current.equals(next)) {
                    repeat++;
                } else {
                    result += (getRepeatCount(repeat) + current);
                    repeat = 1;
                }
            }
            result += (getRepeatCount(repeat) + next);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    private static String getRepeatCount(int hit) {
        return hit > 1 ? String.valueOf(hit) : "";
    }
}