import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int res[] = new int[t];
		
		int x, y, leftDist, moveDist, max;
		for (int i=0 ; i<t ; i++){
			
			x = sc.nextInt();
			y = sc.nextInt();
			leftDist = y - x;
			
			max = (int) Math.sqrt(leftDist);
			moveDist = (int) Math.pow(max, 2);
			res[i] = max * 2 - 1;
			leftDist -= moveDist;
			
			while(leftDist > 0){
				
				if (leftDist - max >= 0){
					moveDist = max;
					leftDist -= moveDist;
					res[i]++;
				}
				else{
					max--;
				}
			}
		}
		sc.close();
		
		for (int i=0 ; i<t ; i++){
			System.out.println(res[i]);
		}
		
	}

}
