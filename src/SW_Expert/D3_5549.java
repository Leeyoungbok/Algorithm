package SW_Expert;

import java.util.Scanner;

public class D3_5549 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC= sc.nextInt();
		for(int tc = 1 ; tc<=TC; tc++) {
			String str = sc.next();
			System.out.print("#" + tc + " ");
			if((Integer.parseInt(str.charAt(str.length()-1)+"")%10)%2 == 1) System.out.println("Odd");
			else System.out.println("Even");
		}
		sc.close();
	}

}
