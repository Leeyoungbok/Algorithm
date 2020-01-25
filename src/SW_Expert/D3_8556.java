package SW_Expert;

import java.util.Scanner;

public class D3_8556 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0 ; i < tc ; i++) {
			String s = sc.nextLine();
			int cnt = 1;
			double dir = 45;
			
			for(int j = 0 ; j < s.length() ; j++) {
				if(s.charAt(j) == 'n') {
					dir -= (90 / (Math.pow(2, cnt))); 
					cnt++;
				} else if(s.charAt(j) == 'w') {
					dir += (90 / (Math.pow(2, cnt))); 
					cnt++;
				}
			}
			System.out.println(dir);
		}
		sc.close();
	}

}
