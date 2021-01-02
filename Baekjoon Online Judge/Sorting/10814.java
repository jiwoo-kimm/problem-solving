// 백준 10814 '나이순 정렬'
// Comparable

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Member implements Comparable<Member>{

	int age;
	String name;
	
	public Member(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Member anotherMember) {
		
		if (this.age < anotherMember.age)
			return -1;
		else if (this.age == anotherMember.age)
			return 0;
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
		ArrayList<Member> list = new ArrayList<Member>();
		
		int age;
		String name;
		for (int i=0 ; i<n ; i++){
			tk = new StringTokenizer(br.readLine());
			age = Integer.parseInt(tk.nextToken());
			name = tk.nextToken().toString();
			list.add(new Member(age, name));
		}
		
		Collections.sort(list);
		
		for (int i=0 ; i<n ; i++){
			bw.write(list.get(i).age+" "+list.get(i).name+"\n");
		}
		bw.close();
	}
}
