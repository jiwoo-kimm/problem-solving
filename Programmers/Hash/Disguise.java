// 프로그래머스 '위장'
// 해시
// 2021.01.21

import java.util.HashMap;
import java.util.Map;

public class Disguise {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    private static final int CATEGORY = 1;

    public static int solution(String[][] clothes) {
        Map<String, Integer> collection = new HashMap<>();
        for (String[] element : clothes)
            collection.put(element[CATEGORY], collection.getOrDefault(element[CATEGORY], 0) + 1);
        return collection.values().stream().mapToInt(value -> value + 1).reduce(1, (a, b) -> a * b) - 1;
    }
}
