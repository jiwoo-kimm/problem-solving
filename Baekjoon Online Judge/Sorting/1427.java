// 백준 1427 '소트인사이드'

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		String num = tk.nextToken();
		int length = num.length();
		
		// 1. 배열에 각 자릿수 저장
		ArrayList<Integer> digits = new ArrayList<Integer>();
		String tmp;
		for (int i=0 ; i<length; i++){
			tmp = String.valueOf(num.charAt(i));
			digits.add(Integer.parseInt(tmp));
		}
		
		// 2. 오름차순 정렬
		digits.sort(null);
		
		// 3. 내림차순 출력
		for (int i=0 ; i<length ; i++){
			bw.write(Integer.toString(digits.get(length-i-1)));
		}
		
		bw.close();
	}
}
