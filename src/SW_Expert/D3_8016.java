package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_8016 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			long n = Integer.parseInt(br.readLine());
			long f = 2*n*n - 4*n +3;
            long e = 2*(n+1)*(n+1) - 4*(n+1) + 1;
			System.out.println("#" + tc + " " + f + " " + e);
		}
	}
}
