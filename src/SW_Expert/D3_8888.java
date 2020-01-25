package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_8888 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int[][] participant = new int[N + 1][T+1];
			int T_Score[] = new int[T+1];
			int P_Score[] = new int[N + 1];
			int count[] = new int[N + 1];
			int grade = 1;
			for (int n = 1; n <= N; n++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
				for (int t = 1; t <= T; t++) {
					participant[n][t] = Integer.parseInt(st1.nextToken());
					if (participant[n][t] == 0)
						T_Score[t]++;
				}
			}
			for (int n = 1; n <= N; n++) {
				for (int t = 1; t <= T; t++) {
					if (participant[n][t] == 1) {
						P_Score[n] += T_Score[t];
						count[n] += 1;
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				if (P != i) {
					if (P_Score[P] < P_Score[i]) {
						grade++;
					}

					if (P_Score[P] == P_Score[i] && count[P] < count[i]) {
						grade++;
					}

					if (P_Score[P] == P_Score[i] && count[P] == count[i] && P > i) {
						grade++;
					}
				}
			}
			System.out.println("#" + tc + " " + P_Score[P] + " " + grade);
		}
	}
}
