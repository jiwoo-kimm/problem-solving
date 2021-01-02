import java.util.*;

public class Solution_gem {

    private static Set<String> gemType = new HashSet<>();
    private static Queue<String> gemsToBuy = new LinkedList<>();
    private static Map<String, Integer> gemsToBuyCount = new HashMap<>();
    private static int startIndex;

    private static int answerStartIndex;
    private static int answerSize = Integer.MAX_VALUE;

    public int[] solution(String[] gems) {

        countGemType(gems);
        shopGems(gems);
        return new int[]{answerStartIndex + 1, answerStartIndex + answerSize};
    }

    private void countGemType(String[] gems) {
        gemType.addAll(Arrays.asList(gems));
    }

    private void shopGems(String[] gems) {
        for (String gem : gems) {
            addGemsToBuy(gem);
            removeDuplicateStartGem();
            updateAnswer();
        }
    }

    private void addGemsToBuy(String gem) {
        gemsToBuy.add(gem);
        updateGemsToBuyCount(gem);
    }

    private void updateGemsToBuyCount(String gem) {
        if (gemsToBuyCount.containsKey(gem))
            gemsToBuyCount.put(gem, gemsToBuyCount.get(gem) + 1);
        else
            gemsToBuyCount.put(gem, 1);
    }

    private void removeDuplicateStartGem() {
        while (true) {
            String startGem = gemsToBuy.peek();
            int startGemCount = gemsToBuyCount.get(startGem);
            if (startGemCount > 1) {
                gemsToBuyCount.put(startGem, startGemCount - 1);
                gemsToBuy.poll();
                startIndex++;
            } else {
                break;
            }
        }
    }

    private void updateAnswer() {
        if (gemsToBuyCount.size() == gemType.size() && answerSize > gemsToBuy.size()) {
            answerStartIndex = startIndex;
            answerSize = gemsToBuy.size();
        }
    }
}
