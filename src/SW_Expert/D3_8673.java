package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_8673 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = (int) Math.pow(2, N);
			int[] member = new int[cnt];
			int total = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0 ; n < cnt ; n++) {
				member[n] = Integer.parseInt(st.nextToken());
			}
			while (cnt > 1) {
				for (int i = 0; i < cnt/2; i++) {
					total += Math.abs(member[2 * i] - member[(2 * i) + 1]);
					member[i] = Math.max(member[2 * i], member[2 * i + 1]);
					
				} 
				cnt = cnt/2;
			}
			System.out.println("#" + tc + " " + total);
		}
	}
}
