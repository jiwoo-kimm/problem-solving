import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2798 {
	
	static ArrayList<Integer> cards = new ArrayList<Integer>();
	static int numOfCards;
	static int maxSum;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer tk = new StringTokenizer(str);
		numOfCards = Integer.parseInt(tk.nextToken());
		maxSum = Integer.parseInt(tk.nextToken());
		
		str = br.readLine();
		tk = new StringTokenizer(str);
		for (int i=0 ; i<numOfCards ; i++){
			cards.add(Integer.parseInt(tk.nextToken()));
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(findSum()));
		bw.flush();
		bw.close();
	}

	private static int findSum() {
				
		for (int i=0 ; i<cards.size() ; i++){
			if (cards.get(i) > maxSum - 2){
				cards.remove(i);
				i--;
			}
		}
		
		int res = 0;
		int minGap = maxSum;
		
		int sum, gap;
		for (int i=0 ; i<cards.size()-2 ; i++){
			for (int j=i+1 ; j<cards.size()-1 ; j++){
				for (int k=j+1 ; k<cards.size() ; k++){
					sum = cards.get(i) + cards.get(j) + cards.get(k);
					gap = maxSum - sum;
					if (gap >= 0 && gap < minGap){
						minGap = gap;
						res = sum;
					}
				}
			}
		}
		
		return res;
	}
}
