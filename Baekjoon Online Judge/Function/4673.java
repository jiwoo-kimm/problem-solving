import java.util.HashSet;

public class Main {

	public static HashSet<Integer> s = new HashSet<Integer>();
	
	public static void main(String[] args) {
		
		int i;
		for (i=1 ; i<10000 ; i++){
			s.add(d(i));
		}
		
		for (i=1 ; i<10000 ; i++){
			if (isSelfNum(i)) System.out.println(i);
		}
	}
	
	public static boolean isSelfNum(int n){
		
		if (s.contains(n)) return false;
		else return true;
	}
	
	public static int d(int n){
		
		int res = n;
		int x = 10;
		boolean cont = true;
		while(cont){
			res += n % x;
			if (n / x == 0) cont = false;
			else n /= 10;
		}
		return res;
	}

}
