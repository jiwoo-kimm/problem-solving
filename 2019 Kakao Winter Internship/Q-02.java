import java.util.HashSet;
import java.util.Set;

public class Tuple {

    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }

    public static int[] solution(String s) {
        String[] parsedChunks = parseChunks(s);
        int[] result = new int[parsedChunks.length];
        int index = 0;
        Set<String> numbers = new HashSet<>();
        for (String chunk : parsedChunks)
            for (String element : chunk.split(","))
                if (numbers.add(element)) result[index++] = Integer.parseInt(element);
        return result;
    }

    private static String[] parseChunks(String s) {
        String[] chunks = s.substring(2, s.length() - 2).split("},\\{");
        return orderChunks(chunks);
    }

    private static String[] orderChunks(String[] chunks) {
        String[] result = new String[chunks.length];
        for (String chunk : chunks) {
            String[] elements = chunk.split(",");
            result[elements.length - 1] = chunk;
        }
        return result;
    }
}
