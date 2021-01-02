import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int count = 0;
	static StringBuffer record = new StringBuffer();
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		move(n, 1, 3, 2);
		
		System.out.println(count);
		System.out.println(record.toString());
	}
	
	private static void move(int n, int from, int to, int by){
		
		if (n == 1){
			record.append(from+" "+to+"\n");
			count++;
			return;
		}
		move(n-1, from, by, to);
		record.append(from+" "+to+"\n");
		count++;
		move(n-1, by, to, from);
	}
}
