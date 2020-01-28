package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7227 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			long total = 0;
			boolean[] check = new boolean[n];
			check[0] = true;
			int min = 400001;
			for (int i = 0; i < n; i++) { // input
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i= 0 ; i < n-1 ; i++) {
				if(check[i] == true) continue;
				int cnt = 0;
				int c;
				for(int j = i+1 ; j < n ; j++) {
					int a = Math.min(x[i] - x[j] + y[i] - y[j], x[j] - x[i] + y[j] - y[i]);
					if(min > a) {
						cnt = j;
					}
					check[i] = true;
					check[cnt] = true;
				}
			}
			
			System.out.println(total);
		}
	}
}
