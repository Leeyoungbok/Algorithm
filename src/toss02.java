import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class toss02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] str = input.split(" ");
		int cnt = 0;
		int cur = 0;
		boolean[] arr = new boolean[100];
		for(String s : str) {
			int n1 = Integer.parseInt(s);
			
			if(n1 < 45) {
				System.out.println(false);
				return;
			}
			
			if(!arr[n1]) {
				arr[n1] = true;
				cnt++;
			}
			else {
				System.out.println(false);
				return;
			}
			
			if(cur < n1) {
				cur = n1;
			}else {
				System.out.println(false);
				return;
			}
		}
		if (cnt != 6) {
			System.out.println(false);
			return;
		}
		System.out.println(true);
	}
}	

//		
//		
//		for(int i = 0 ; i < input.length() ; i = i+2) {
//			int n1 = Integer.parseInt(input.charAt(i)+"");
//			
//			
//		

//		

