// 2021 카카오 블라인드 채용
// 순위 검색
// 2021.03.24-25

import java.util.*;

class Solution {
    
    private static final String BLANK = " ";
    private static final String NULL = "";

    private static final int LANGUAGE = 0;
    private static final int POSITION = 1;
    private static final int CAREER = 2;
    private static final int SOUL_FOOD = 3;
    private static final int TEST_SCORE = 4;
    private static final int CONDITION_COUNT = 4;

    private Map<String, List<Integer>> testScoresPerCondition = new HashMap<>();
    private List<Integer> queryResults = new ArrayList<>();

    public int[] solution(String[] infos, String[] queries) {
        parseApplicantsInfo(infos);
        queryForResults(queries);
        return queryResults.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void parseApplicantsInfo(String[] infos) {
        for (String info : infos) {
            String[] chunks = info.split(BLANK);
            int testScore = Integer.parseInt(chunks[TEST_SCORE]);
            List<String> conditions = getCombinationOfInfo(chunks);
            for (String condition : conditions) addInfo(condition, testScore);
        }
        for (List<Integer> applicants : testScoresPerCondition.values()) applicants.sort(Integer::compareTo);
    }

    private List<String> getCombinationOfInfo(String[] chunks) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= CONDITION_COUNT; i++)
            dfs(new String[i], new boolean[CONDITION_COUNT], 0, 0, i, result, chunks);
        return result;
    }

    private void dfs(String[] tmp, boolean[] visited, int start, int depth, int targetLength, List<String> result, String[] chunks) {
        if (depth == targetLength) {
            result.add(createConditionString(tmp));
            return;
        }

        for (int i = start; i < CONDITION_COUNT; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = chunks[i];
                dfs(tmp, visited, i + 1, depth + 1, targetLength, result, chunks);
                visited[i] = false;
                tmp[depth] = BLANK;
            }
        }
    }

    private String createConditionString(String[] tmp) {
        StringBuilder sb = new StringBuilder();
        for (String str : tmp) sb.append(str);
        return sb.toString().strip();
    }

    private void addInfo(String condition, int testScore) {
        if (testScoresPerCondition.containsKey(condition)) {
            testScoresPerCondition.get(condition).add(testScore);
        } else {
            List<Integer> testScores = new ArrayList<>();
            testScores.add(testScore);
            testScoresPerCondition.put(condition, testScores);
        }
    }

    private void queryForResults(String[] queries) {
        for (String query : queries) {
            int testScore = parseTestScore(query);
            String condition = parseQueryIntoConditionString(query.replace(Integer.toString(testScore), NULL));
            if (!testScoresPerCondition.containsKey(condition))
                queryResults.add(0);
            else
                queryResults.add(countAvailableApplicants(testScoresPerCondition.get(condition), testScore));
        }
    }

    private int parseTestScore(String query) {
        String[] chunks = query.split(BLANK);
        return Integer.parseInt(chunks[chunks.length - 1]);
    }

    private String parseQueryIntoConditionString(String query) {
        String[] chunks = query.replace("-", NULL).split("and");
        return chunks[LANGUAGE].strip() + chunks[POSITION].strip()
                + chunks[CAREER].strip() + chunks[SOUL_FOOD].strip();
    }

    private int countAvailableApplicants(List<Integer> applicants, int testScore) {
        int left = 0, right = applicants.size() - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (applicants.get(mid) < testScore) left = mid + 1;
            else right = mid - 1;
        }
        return applicants.size() - left;
    }
}