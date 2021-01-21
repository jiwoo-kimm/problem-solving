// 프로그래머스 '전화번호 목록'
// 해시
// 2021.01.21

import java.util.Arrays;

public class Phone {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public static boolean solution(String[] phone_book) {
        for (String phone : phone_book)
            if (Arrays.stream(phone_book).anyMatch(number -> !number.equals(phone) && number.startsWith(phone)))
                return false;
        return true;
    }
}
