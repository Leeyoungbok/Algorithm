package SW_Expert;

import java.util.Scanner;

public class D2_2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc = 1; tc <= TC ; tc++) {
			String input = sc.next();
			
			for(int i = 2 ; i < 10; i++) {
				if(input.substring(0,i).equals(input.substring(i,2*i))) {
					System.out.println("#"+tc+" " + i);
					break;
				}
			}
		}
		sc.close();
	}
}
