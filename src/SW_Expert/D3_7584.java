package SW_Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_7584 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int result = 0;
		for (int tc = 1; tc <= TC; tc++) {
			long k = Long.parseLong(br.readLine()) - 1;
			result = 0;
			while (k > 0) {
				if (k % 2 == 1)
					k = (k - 1) / 2;
				if (k % 4 == 0) {
					result = 0;
					break;
				} else if (k % 2 == 0) {
					result = 1;
					break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
