package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7102 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] total = new int[N + M +1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					total[i+j]++;
				}
			}
			int max = Math.min(1+N, 1+M);
			System.out.print("#" + tc + " ");
			for(int i = 2 ; i <= N+M ; i++) {
				if(total[i] == total[max]) System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
