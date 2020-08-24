import java.io.BufferedReader;
import java.io.InputStreamReader;

public class toss01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char ch = input.charAt(0);
		
		for(int i = 1 ; i < input.length() ; i++) {
			if(ch == '1') {
				if(input.charAt(i) == 1) {
					System.out.println(false);
					return;
				}else {
					ch = '2';
				}
			}
		}
		
		if(input.charAt(input.length()-1) == '1') {
			System.out.println(false);
			return;
		}
		System.out.println(true);
	}
}
