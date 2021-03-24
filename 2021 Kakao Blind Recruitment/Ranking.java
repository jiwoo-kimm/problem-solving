import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }

    private static final int LANGUAGE = 0;
    private static final int POSITION = 1;
    private static final int CAREER = 2;
    private static final int SOUL_FOOD = 3;
    private static final int TEST_SCORE = 4;

    private static Set<Applicant> applicants = new HashSet<>();
    private static List<Integer> queryResults = new ArrayList<>();

    public static int[] solution(String[] infos, String[] queries) {
        parseApplicantsInfo(infos);
        queryForResults(queries);
        return queryResults.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static void parseApplicantsInfo(String[] infos) {
        for (String info : infos) {
            String[] chunks = info.split(" ");
            applicants.add(new Applicant(new Condition(
                    chunks[LANGUAGE], chunks[POSITION], chunks[CAREER],
                    chunks[SOUL_FOOD], Integer.parseInt(chunks[TEST_SCORE]))));
        }
    }

    private static void queryForResults(String[] queries) {
        for (String query : queries) {
            Condition condition = parseQueryToCondition(query);
            queryResults.add((int) applicants.stream()
                    .filter(applicant -> applicant.meetsCondition(condition))
                    .count());
        }
    }

    private static Condition parseQueryToCondition(String query) {
        String[] conditions = query.split("and");
        int testScore = parseTestScore(conditions[SOUL_FOOD].strip().split(" ")[1]);
        String soulFood = conditions[SOUL_FOOD].strip().split(" ")[0];
        return new Condition(conditions[LANGUAGE].strip(), conditions[POSITION].strip(),
                conditions[CAREER].strip(), soulFood.strip(), testScore);
    }

    private static int parseTestScore(String str) {
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