// ���� 1427 '��Ʈ�λ��̵�'

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
		
		// 1. �迭�� �� �ڸ��� ����
		ArrayList<Integer> digits = new ArrayList<Integer>();
		String tmp;
		for (int i=0 ; i<length; i++){
			tmp = String.valueOf(num.charAt(i));
			digits.add(Integer.parseInt(tmp));
		}
		
		// 2. �������� ����
		digits.sort(null);
		
		// 3. �������� ���
		for (int i=0 ; i<length ; i++){
			bw.write(Integer.toString(digits.get(length-i-1)));
		}
		
		bw.close();
	}
}
