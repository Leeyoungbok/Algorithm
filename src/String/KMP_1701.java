package String;

import java.util.Scanner;

public class KMP_1701 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		int max = 0;
		for(int s = 0 ; s < input.length() ; s++) {
			int j = 0;
			String subInput = input.substring(s, input.length());
			int[] pi = new int[subInput.length()];
			for(int i = 1 ; i < subInput.length() ; i++) {
				while(j > 0 && subInput.charAt(i) != subInput.charAt(j)) {
					j = pi[j-1];
				}
				if(subInput.charAt(i) == subInput.charAt(j)) {
					pi[i] = ++j;
					max = max < pi[i] ? pi[i] : max; 
				}
			}
		}
			
		System.out.println(max);
		sc.close();
	}

}
