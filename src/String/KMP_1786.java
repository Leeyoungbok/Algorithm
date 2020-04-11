package String;

import java.util.ArrayList;
import java.util.Scanner;

public class KMP_1786 {
	static String input, kmp;
	static int ans;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] pattern;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextLine();
		kmp = sc.nextLine();
		
		pattern = new int[kmp.length()];
		pattern = getPattern(kmp);

		
		int j = 0;
		for(int i = 0 ; i < input.length() ; i++) {
			while(j > 0 && input.charAt(i) != kmp.charAt(j)) {
				j = pattern[j - 1];
			}
			if(input.charAt(i) == kmp.charAt(j)) {
				if(j == kmp.length()-1) {
					ans++;
					list.add(i-kmp.length()+2);
					j = pattern[j];
				}else
					j++;
			}
		}
		System.out.println(ans);
		for(int n1 : list)
			System.out.print(n1 + " ");
		sc.close();
	}
	
	static int[] getPattern(String kmp) {
		int j = 0;
		int[] pi = new int[kmp.length()];
		for(int i = 1 ; i < kmp.length() ; i++) {
			while(j > 0 && kmp.charAt(j) != kmp.charAt(i)) {
				j = pi[j-1];
			}
			if(kmp.charAt(j) == kmp.charAt(i)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
