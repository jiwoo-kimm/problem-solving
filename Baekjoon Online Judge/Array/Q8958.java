import java.util.Scanner;

public class Q8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		String input[] = new String[num];
		
		int k;
		for (k=0 ; k<num ; k++){
			input[k] = sc.nextLine();
		}
		
		for (k=0 ; k<num ; k++){
			int len = input[k].length();
			int tmp = 0;
			int score = 0;
			char res;
			
			int i, j;
			for (i=0 ; i<len ; i++){
				res = input[k].charAt(i);
				if (res == 'X'){
					for (j=0 ; j<tmp ; j++){
						score += (j+1);
					}
					tmp = 0;
				}
				else{
					tmp++;
				}
			}
			for (j=0 ; j<tmp ; j++){
				score += (j+1);
			}
			
			System.out.println(score);
		}
		
	}

}
