// 프로그래머스 '멀쩡한 사각형'
// 2021.02.19

public class Square {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long total = (long) w * h;
        long gcd = calcGcd(Math.min(w, h), Math.max(w, h));
        long removed = ((w / gcd + h / gcd) - 1) * gcd;
        return total - removed;
    }

    private static long calcGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            if (r == 0) return b;
            a = b;
            b = r;
        }
        return 1;
    }
}
