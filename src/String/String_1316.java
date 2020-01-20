package String;

import java.util.Scanner;

public class String_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String st = sc.next();
			int check = 0;
			
			for (int j = 0; j < st.length(); j++) {
				if(j+1 != st.length() && st.charAt(j) == st.charAt(j+1)) continue;
				else {
					if(st.substring(j+1, st.length()).contains(st.charAt(j)+"")) {
//						System.out.println(st);
						check++;
					}
				}
			}
			if(check == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
