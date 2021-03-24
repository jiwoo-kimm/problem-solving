// 2021 카카오 블라인드 채용
// 순위 검색
// 2021.03.24

import java.util.*;

class Solution {    
    
    private static final int LANGUAGE = 0;
    private static final int POSITION = 1;
    private static final int CAREER = 2;
    private static final int SOUL_FOOD = 3;
    private static final int TEST_SCORE = 4;

    private Set<Applicant> applicants = new HashSet<>();
    private List<Integer> queryResults = new ArrayList<>();

    public int[] solution(String[] infos, String[] queries) {
        parseApplicantsInfo(infos);
        queryForResults(queries);
        return queryResults.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void parseApplicantsInfo(String[] infos) {
        for (String info : infos) {
            String[] chunks = info.split(" ");
            applicants.add(new Applicant(new Condition(
                    chunks[LANGUAGE], chunks[POSITION], chunks[CAREER],
                    chunks[SOUL_FOOD], Integer.parseInt(chunks[TEST_SCORE]))));
        }
    }

    private void queryForResults(String[] queries) {
        for (String query : queries) {
            Condition condition = parseQueryToCondition(query);
            queryResults.add((int) applicants.stream()
                    .filter(applicant -> applicant.meetsCondition(condition))
                    .count());
        }
    }

    private Condition parseQueryToCondition(String query) {
        String[] conditions = query.split("and");
        int testScore = parseTestScore(conditions[SOUL_FOOD].strip().split(" ")[1]);
        String soulFood = conditions[SOUL_FOOD].strip().split(" ")[0];
        return new Condition(conditions[LANGUAGE].strip(), conditions[POSITION].strip(),
                conditions[CAREER].strip(), soulFood.strip(), testScore);
    }

    private int parseTestScore(String str) {
        if (str.equals(Condition.NULL)) return Condition.NO_TEST_SCORE;
        else return Integer.parseInt(str);
    }
}

class Applicant {
    Condition condition;

    public Applicant(Condition condition) {
        this.condition = condition;
    }

    public boolean meetsCondition(Condition condition) {
        return this.condition.equals(condition);
    }
}

class Condition {

    static final int NO_TEST_SCORE = -1;
    static final String NULL = "-";

    String language;
    String position;
    String career;
    String soulFood;
    int testScore;

    public Condition(String language, String position, String career, String soulFood, int testScore) {
        this.language = language;
        this.position = position;
        this.career = career;
        this.soulFood = soulFood;
        this.testScore = testScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Condition)) return false;
        Condition target = (Condition) o;
        if (target.testScore != NO_TEST_SCORE && this.testScore < target.testScore) return false;
        if (!target.language.equals(NULL) && !this.language.equals(target.language)) return false;
        if (!target.position.equals(NULL) && !this.position.equals(target.position)) return false;
        if (!target.career.equals(NULL) && !this.career.equals(target.career)) return false;
        if (!target.soulFood.equals(NULL) && !this.soulFood.equals(target.soulFood)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, position, career, soulFood, testScore);
    }
}