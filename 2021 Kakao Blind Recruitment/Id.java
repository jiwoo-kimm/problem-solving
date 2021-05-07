package kakaoblind2021;

public class Id {

    private static final char DOT = '.';
    private static final String NEW_ID_FOR_EMPTY_STRING = "a";
    private static final int MAX_LENGTH = 15;
    private static final int MIN_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    private static String solution(String new_id) {
        // 1단계
        String result = new_id.toLowerCase();
        System.out.println(result);
        // 2단계
        result = result.replaceAll("[^-_.a-z0-9]", "");
        System.out.println(result);
        // 3단계
        result = result.replaceAll("[.]{3}|[.]{2}", DOT + "");
        System.out.println(result);
        // 4단계
        result = removeDotAtFrontAndBack(result);
        System.out.println(result);
        // 5단계
        result = (result.isEmpty() ? NEW_ID_FOR_EMPTY_STRING : result);
        System.out.println(result);
        // 6단계
        result = (result.length() > MAX_LENGTH ? removeDotAtFrontAndBack(result.substring(0, MAX_LENGTH)) : result);
        System.out.println(result);
        // 7단계
        result = (result.length() < MIN_LENGTH ? extendToMinLength(result) : result);
        System.out.println(result);

        return result;
    }

    private static String removeDotAtFrontAndBack(String result) {
        if (result.charAt(0) == DOT) result = result.substring(1);

        if (result.length() > 0 && result.charAt(result.length() - 1) == DOT)
            result = result.substring(0, result.length() - 1);

        return result;
    }

    private static String extendToMinLength(String result) {
        char ch = result.charAt(result.length() - 1);
        while (result.length() < MIN_LENGTH) result += ch;
        return result;
    }
}
