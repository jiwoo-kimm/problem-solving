// 2019 카카오 블라인드
// 후보키
// 2021.03.15

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private String[][] table;
    private int colCount;
    private Set<Key> candidates = new HashSet<>();

    public int solution(String[][] relation) {
        initParams(relation);
        findCandidateKeys();
        return candidates.size();
    }

    private void initParams(String[][] relation) {
        table = relation;
        colCount = relation[0].length;
    }

    private void findCandidateKeys() {
        for (int i = 1; i <= colCount; i++)
            dfs(new int[i], new boolean[colCount], 0, 0, i);
    }

    private void dfs(int[] result, boolean[] visited, int start, int depth, int targetLength) {
        if (depth == targetLength) {
            Key newKey = new Key(Arrays.stream(result).boxed().collect(Collectors.toList()));
            if (isCandidate(newKey)) candidates.add(newKey);
            return;
        }

        for (int i = start; i < colCount; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(result, visited, i + 1, depth + 1, targetLength);
                visited[i] = false;
                result[depth] = 0;
            }
        }
    }

    private boolean isCandidate(Key key) {
        return isUnique(key) && isMinimum(key);
    }

    private boolean isUnique(Key key) {
        Set<String> rows = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            String current = "";
            for (int attribute : key.attributes) current += table[i][attribute];
            if (rows.contains(current)) return false;
            rows.add(current);
        }
        return true;
    }

    private boolean isMinimum(Key key) {
        for (Key candidate : candidates)
            if (key.contains(candidate)) return false;
        return true;
    }
}


class Key {
    
    List<Integer> attributes;

    public Key(List<Integer> attributes) {
        this.attributes = attributes;
        attributes.sort(Integer::compareTo);
    }

    public boolean contains(Key target) {
        for (int attribute : target.attributes)
            if (!this.attributes.contains(attribute)) return false;
        return true;
    }
}