// ���� 2108 '�����'
// IO & HashMap

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static int nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		nums = new int[n];
		
		int sum = 0;	// �������� ���� sum
		for (int i=0 ; i<n ; i++){
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
		}
		
		Arrays.sort(nums);	// �߾Ӱ�, ������ ���� sorting
		
		bw.write(Long.toString(Math.round((float)sum / n)) + "\n");	// ������
		bw.write(Integer.toString(nums[(n - 1) / 2]) + "\n");		// �߰���
		bw.write(getMode() + "\n");									// �ֺ�
		bw.write(Integer.toString(nums[n - 1] - nums[0]));			// ����
		bw.flush();
		bw.close();
	}
	
	private static String getMode(){

		int len = nums.length;
		
		/* 1. �󵵰� ī��Ʈ */
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();	// countMap(��, ��)
		int key;
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.containsKey(key)){
				countMap.replace(key, countMap.get(key) + 1);
			}
			else countMap.put(nums[i], 1);
		}
		
		/* 2. Max count ã�� */
		int maxCount = 0;
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.get(key) > maxCount)
				maxCount = countMap.get(key);
		}
		
		/* 3. �ֺ� ã�� */
		ArrayList<Integer> modeList = new ArrayList<Integer>();
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.get(key) == maxCount && !modeList.contains(key))
				modeList.add(key);
		}
		
		/* 4. mode ��ȯ */
		if (modeList.size() == 1)
			return Integer.toString(modeList.get(0));
		else {
			return Integer.toString(modeList.get(1));
		}
	}
}
