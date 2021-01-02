// 백준 1181 '단어 정렬'
// Comparator

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(tk.nextToken());
		ArrayList<String> list = new ArrayList<String>();
		
		String tmp;
		for (int i=0 ; i<n ; i++){
			tmp = br.readLine().toString();
			if (!list.contains(tmp))
				list.add(tmp);
		}
		
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				
				int len1 = o1.length();
				int len2 = o2.length();
				
				if (len1 < len2){
					return -1;
				}
				else if (len1 > len2){
					return 1;
				}
				else{
					return o1.compareTo(o2);
				}
			}
		});
		
		for (int i=0 ; i<list.size() ; i++){
			bw.write(list.get(i)+"\n");
		}
		bw.close();
	}
}
