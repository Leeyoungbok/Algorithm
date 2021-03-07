package SW_Expert;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SWEA_보물상자비밀번호 {
	static int N, K, cnt;
	static String str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			str = sc.next();
			cnt = str.length();
			int sideCnt = cnt / 4;
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < sideCnt; i++) {
				for (int k = 0; k < N; k = k + sideCnt) {
					set.add(str.substring(k, k + sideCnt));
				}
				str = str.charAt(cnt - 1) + str.substring(0, cnt - 1);
			}
			ArrayList<String> sss = new ArrayList<>();
			String[] s = new String[set.size()];
			sss.toArray(s);
			set.toArray(s);
			System.out.println("#" + tc + " " + Integer.parseInt(s[set.size() - K], 16));
		}
		sc.close();
	}

}
