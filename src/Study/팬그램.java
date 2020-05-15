package Study;

import java.util.Scanner;

public class 팬그램 {
	static int N;
	static int[] alphabet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		for (int n = 1; n <= N; n++) {
			alphabet = new int[26];
			String str = sc.nextLine();

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(Character.isAlphabetic(ch)) {
					alphabet[Character.toLowerCase(ch) - 97]++;
				}
			}
			int min = 3;
			for(int i = 0 ; i < 26 ; i ++) {
				if(alphabet[i] < min)
					min = alphabet[i];
			}
			
			System.out.print("Case " + n +": ");
			if(min == 0)
				System.out.println("Not a pangram");
			else if(min == 1)
				System.out.println("Pangram!");
			else if(min == 2)
				System.out.println("Double pangram!!");
			else
				System.out.println("Triple pangram!!!");
		}
		sc.close();
	}

}
