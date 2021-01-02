// 백준 11650 '좌표 정렬하기'
// Comparable, Comparator

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point anotherPoint) {
		
		if (this.x < anotherPoint.x)
			return -1;
		else if (this.x == anotherPoint.x && this.y < anotherPoint.y)
			return -1;
		else
			return 1;
	}
	
}
public class Main2 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tk.nextToken());
		
		Point list[] = new Point[n];
		
		// 1. 입력받기
		int x, y;
		for (int i=0 ; i<n ; i++){
			tk = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tk.nextToken());
			y = Integer.parseInt(tk.nextToken());
			list[i] = new Point(x, y);
		}
		
		// 2. 정렬하기
		Arrays.sort(list);
		
		// 3. 출력하기
		for (int i=0 ; i<n ; i++){
			bw.write(list[i].x+" "+list[i].y+"\n");
		}
		bw.close();
	}
}
