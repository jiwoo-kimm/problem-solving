// 백준 10989 '수 정렬하기 3'
// Counting Sort

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			int arr[] = new int[10000001];
			
			int n = Integer.parseInt(tk.nextToken());
			
			// 1. 입력받기
			int num;
			for (int i=0 ; i<n ; i++){
				tk = new StringTokenizer(br.readLine());
				num = Integer.parseInt(tk.nextToken());
				arr[num+1]++;
			}
			
			// 2. 출력하기
			for (int i=0 ; i<arr.length ; i++){
				if (arr[i] != 0){
					for (int j=0 ; j<arr[i] ; j++){
						bw.write((i-1)+"\n");
					}
				}
			}
			
			bw.close();
	}
}
