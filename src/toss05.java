import java.io.BufferedReader;
import java.io.InputStreamReader;

public class toss05 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String input2 = br.readLine();
		String[] str1 = input.split(" ");
		String[] str2 = input2.split(" ");
		
		int cost = 0;
		int cost2 = 0;
		for(int i = 0 ; i < str1.length ; i++) {
//			System.out.println(Integer.parseInt(str1[i]));
//			System.out.println(Integer.parseInt(str2[i]));
			int n1 = Integer.parseInt(str1[i]) - Integer.parseInt(str2[i]) - cost2; // 김이 줄수있는돈
			if(n1 < 0) {
				cost2 = n1 * -1;
				n1 = 0;
			}else
				cost2 = 0;
			
			System.out.print(n1 + " ");
		}
	}
}
