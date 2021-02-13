// 프로그래머스 '124 나라의 숫자'
// 2021.02.13

public class World124 {

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
        System.out.println(solution(13));
        System.out.println(solution(14));
        System.out.println(solution(15));
    }

    private static final String[] letters = {"4", "1", "2"};

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % 3;
            if (remainder == 0) n--;
            sb.append(letters[remainder]);
            n /= 3;
        }
        return reverse(sb.toString());
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            sb.append(str.charAt(i));
        return sb.toString();
    }
}
