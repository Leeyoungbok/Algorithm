package String;

import java.util.Scanner;


public class String_2804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		char[][] map = new char[str2.length()][str1.length()];
		int cross_X = 0;
		int cross_Y = 0;
		loop: for(int i = 0 ; i < str1.length() ; i++) {
			for(int j = 0 ; j < str2.length() ; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					cross_X = i;
					cross_Y = j;
					break loop;
				}
			}
		}
		
		for(int i = 0 ; i < str2.length() ; i++) {
			for(int j = 0 ; j < str1.length() ; j++) {
				if(i == cross_Y) {
					map[i][j] = str1.charAt(j);
				}else if(j == cross_X) {
					map[i][j] = str2.charAt(i);
				}else
					map[i][j] = '.';
			}
		}
		for(int i = 0 ; i < str2.length() ; i++) {
			for(int j = 0 ; j < str1.length() ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
                                  