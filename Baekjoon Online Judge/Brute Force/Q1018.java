import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1018 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		char board[][] = new char[N][M];
		for (int i=0 ; i<N ; i++){
			tk = new StringTokenizer(br.readLine());
			String line = tk.nextToken();
			for (int j=0 ; j<M ; j++){
				board[i][j] = line.charAt(j);
			}
		}
		
		int min = 64;
		
		for (int startX=0 ; startX+8 <= M ; startX++){
			for (int startY=0 ; startY+8 <= N ; startY++){
				int count = 0;
				// 베이스 'W'
				for (int i=startX ; i<startX+8 ; i++){
					for (int j=startY ; j<startY+8 ; j++){
						if ((i-startX + j-startY) % 2 == 0){
							if (board[j][i] == 'B'){
								count++;
							}
						}
						else {
							if (board[j][i] == 'W'){
								count++;
							}
						}
					}
				}
				if (count < min){
					min = count;
				}
				
				// 베이스 'B'
				count = 0;
				for (int i=startX ; i<startX+8 ; i++){
					for (int j=startY ; j<startY+8 ; j++){
						if ((i-startX + j-startY) % 2 == 0){
							if (board[j][i] == 'W'){
								count++;
							}
						}
						else {
							if (board[j][i] == 'B'){
								count++;
							}
						}
					}
				}
				if (count < min){
					min = count;
				}
			}
		}
		
		
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}
}
