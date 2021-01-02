// 백준 2108 '통계학'
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
		
		int sum = 0;	// 산술평균을 위한 sum
		for (int i=0 ; i<n ; i++){
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
		}
		
		Arrays.sort(nums);	// 중앙값, 범위를 위한 sorting
		
		bw.write(Long.toString(Math.round((float)sum / n)) + "\n");	// 산술평균
		bw.write(Integer.toString(nums[(n - 1) / 2]) + "\n");		// 중간값
		bw.write(getMode() + "\n");									// 최빈값
		bw.write(Integer.toString(nums[n - 1] - nums[0]));			// 범위
		bw.flush();
		bw.close();
	}
	
	private static String getMode(){

		int len = nums.length;
		
		/* 1. 빈도값 카운트 */
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();	// countMap(값, 빈도)
		int key;
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.containsKey(key)){
				countMap.replace(key, countMap.get(key) + 1);
			}
			else countMap.put(nums[i], 1);
		}
		
		/* 2. Max count 찾기 */
		int maxCount = 0;
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.get(key) > maxCount)
				maxCount = countMap.get(key);
		}
		
		/* 3. 최빈값 찾기 */
		ArrayList<Integer> modeList = new ArrayList<Integer>();
		for (int i=0 ; i<len ; i++){
			key = nums[i];
			if (countMap.get(key) == maxCount && !modeList.contains(key))
				modeList.add(key);
		}
		
		/* 4. mode 반환 */
		if (modeList.size() == 1)
			return Integer.toString(modeList.get(0));
		else {
			return Integer.toString(modeList.get(1));
		}
	}
}
