package String;

import java.util.Arrays;
import java.util.Scanner;

public class String_1157 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();

		int[] alpha = new int[26];
		int[] save = new int[26];

//		=============================================
		
		for (int i = 0; i < alpha.length; i++)
			alpha[i] = 0;
		
		st = st.toLowerCase();
		for (int i = 0; i < st.length(); i++) 
			alpha[(int)st.charAt(i) - 97]++;
		
		
		for(int i = 0 ; i < 26 ; i ++) save[i] = alpha[i];	
		Arrays.sort(alpha);
		if(alpha[25] == alpha[24]) System.out.println("?");
		else {
			for(int i = 0; i < alpha.length ; i++) {
				if(alpha[25] == save[i])
					System.out.println(Character.toUpperCase((char)(i+97)));
			}
		}
		sc.close();
	}
}
