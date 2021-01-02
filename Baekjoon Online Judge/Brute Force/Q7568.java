import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Q7568 {
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		int weights[] = new int[n];
		int heights[] = new int[n];
		int ranks[] = new int[n];
		
		for (int i=0 ; i<n ; i++){
			StringTokenizer tk = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(tk.nextToken());
			heights[i] = Integer.parseInt(tk.nextToken());
			ranks[i] = 1;
		}
		
		for (int i=0 ; i<n ; i++){
			for (int j=0 ; j<n ; j++){
				if (i != j && weights[i] < weights[j] && heights[i] < heights[j]){
					ranks[i]++;
				}
			}
		}
		
		for (int i=0 ; i<n ; i++){
			bw.write(Integer.toString(ranks[i])+' ');
		}	
		
		bw.flush();
		bw.close();
	}
}
