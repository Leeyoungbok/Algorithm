package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_7728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			String s = br.readLine();
			boolean[] nCheck = new boolean[10];
			int total = 0;
			for (int i = 0; i < s.length(); i++) {
				if (nCheck[Integer.parseInt(s.charAt(i) + "")] == false) {
					total++;
					nCheck[Integer.parseInt(s.charAt(i) + "")] = true;
				}
			}
			System.out.println("#" + tc + " " + total);
		}
	}
}
