// 백준 11651 '좌표 정렬하기'
// Comparable

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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
		
		if (this.y < anotherPoint.y)
			return -1;
		else if (this.y == anotherPoint.y && this.x < anotherPoint.x)
			return -1;
		else
			return 1;
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tk.nextToken());
		
		ArrayList<Point> list = new ArrayList<Point>();
		
		// 1. 입력받기
		int x, y;
		for (int i=0 ; i<n ; i++){
			tk = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tk.nextToken());
			y = Integer.parseInt(tk.nextToken());
			list.add(new Point(x, y));
		}
		
		// 2. 정렬하기
		Collections.sort(list);
		
		// 3. 출력하기
		for (int i=0 ; i<n ; i++){
			bw.write(list.get(i).x+" "+list.get(i).y+"\n");
		}
		bw.close();
	}
}
