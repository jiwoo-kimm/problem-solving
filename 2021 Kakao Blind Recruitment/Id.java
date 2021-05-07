// 2021 카카오 블라인드 채용 : 신규 아이디 추천
// 2021.05.07

class Solution {
    
    private static final char DOT = '.';
    private static final String BLANK = "";
    private static final String NEW_ID_FOR_EMPTY_STRING = "a";
    private static final int MAX_LENGTH = 15;
    private static final int MIN_LENGTH = 3;
    
    public String solution(String new_id) {
        // 1단계
        String result = new_id.toLowerCase();
        // 2단계
        result = result.replaceAll("[^-_.a-z0-9]", BLANK);
        // 3단계
        result = result.replaceAll("[.]{2,}", DOT + BLANK);
        // 4단계
        result = result.replaceAll("^[.]|[.]$", BLANK);
        // 5단계
        result = (result.isEmpty() ? NEW_ID_FOR_EMPTY_STRING : result);
        // 6단계
        result = (result.length() > MAX_LENGTH ? result.substring(0, MAX_LENGTH).replaceAll("^[.]|[.]$", BLANK) : result);
        // 7단계
        result = (result.length() < MIN_LENGTH ? extendToMinLength(result) : result);

        return result;
    }

    private String extendToMinLength(String result) {
        char ch = result.charAt(result.length() - 1);
        while (result.length() < MIN_LENGTH) result += ch;
        return result;
    }
}