package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_7227 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] x = new long[n];
			long[] y = new long[n];
			boolean[] check = new boolean[n];
			long total = 0;
			for (int i = 0; i < n; i++) { // input
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				x[i] = Long.parseLong(st.nextToken());
				y[i] = Long.parseLong(st.nextToken());
			}

			for (int i = 0; i < n - 1; i++) { // calculate
				for (int j = i + 1; j < n; j++) {
				}
			}
			System.out.println(total);
		}
	}
}
