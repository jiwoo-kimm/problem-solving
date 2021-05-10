import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VirtualMachineError {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        bw.append(String.valueOf(countSets(target)));

        br.close();
        bw.close();
    }

    private static int countSets(String target) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
            int num = target.charAt(i) - '0';
            if (num == 9) num = 6;
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (int num : counts.keySet()) {
            int count = counts.get(num);
            if (num == 6) count = (int) Math.ceil((double) count / 2);
            result = Math.max(result, count);
        }
        return result;
    }
}