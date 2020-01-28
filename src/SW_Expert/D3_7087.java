package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_7087 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[26];
			int cnt = 0;
			for(int n = 0 ; n < N ; n++) {
				check[(int)br.readLine().charAt(0) - 65] = true; 
			}
			for(int i = 0 ; i < 26; i++) {
				if(check[i] == true) cnt++;
				else break;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
