// 백준 11650 '좌표 정렬하기'
// Merge Sort

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
	public static int sorted_x[];
	public static int sorted_y[];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tk.nextToken());
		
		int x[] = new int[n];
		int y[] = new int[n];
		sorted_x = new int[n];
		sorted_y = new int[n];
		
		// 1. 점 입력받기
		for (int i=0 ; i<n ; i++){
			tk = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(tk.nextToken());
			y[i] = Integer.parseInt(tk.nextToken());
		}
		
		// 2. x,y 같이 정렬하기		
		merge_sort(x, y, 0, n - 1);
		
		// 3. 출력하기
		for (int i=0 ; i<n ; i++){
			bw.write(x[i]+" "+y[i]+"\n");
		}
		
		bw.close();
	}

	private static void merge_sort(int[] x, int[] y, int left, int right) {
		
		if (left < right){
			int mid = (left + right) / 2;
			merge_sort(x, y, left, mid);
			merge_sort(x, y, mid+1, right);
			merge(x, y, left, mid, right);
		}
	}
	
	private static void merge(int[] x, int[] y, int left, int mid, int right){
		
		int i = left, j = mid+1;
		int idx = left;
		
		while(i <= mid && j <= right){
			if (x[i] < x[j]){
				sorted_x[idx] = x[i];
				sorted_y[idx++] = y[i++];
			}
			else if (x[i] == x[j] && y[i] < y[j]){
				sorted_x[idx] = x[i];
				sorted_y[idx++] = y[i++];
			}
			else{
				sorted_x[idx] = x[j];
				sorted_y[idx++] = y[j++];
			}
		}
		
		while(i <= mid){
			sorted_x[idx] = x[i];
			sorted_y[idx++] = y[i++];
		}
		
		while(j <= right){
			sorted_x[idx] = x[j];
			sorted_y[idx++] = y[j++]; 
		}
		
		for (int k=left ; k<=right ; k++){
			x[k] = sorted_x[k];
			y[k] = sorted_y[k];
		}
	}
	
	
}
