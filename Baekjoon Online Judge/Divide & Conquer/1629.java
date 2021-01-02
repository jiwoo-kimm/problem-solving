import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1629 '곱셈'
// Divide & Conquer
// 2020.08.06

public class Main {

    static long base;
    static long mod;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        base = Integer.parseInt(tk.nextToken());
        long expCount = Integer.parseInt(tk.nextToken());
        mod = Integer.parseInt(tk.nextToken());

        bw.write(Long.toString(calcPow(expCount)));

        br.close();
        bw.close();
    }

    private static long calcPow(long expCount) {

        if (expCount == 0)
            return 1;
        else{
            long tempResult = calcPow(expCount / 2) % mod;
            if (expCount % 2 == 0)
                return tempResult * tempResult % mod;
            else
                return tempResult * tempResult % mod * base % mod;
        }
    }
}
