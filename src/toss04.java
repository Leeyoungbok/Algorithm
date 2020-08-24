import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class toss04 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] str = input.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0 ; i < str.length ; i++) {
			int cnt = 0;
			map.clear();
			for(int j = i ; j >= 0 ; j--) {
				if(!map.containsKey(str[j])) {
					System.out.print(str[j] + " ");
					map.put(str[j], 1);
					cnt++;
				}
				if(cnt == 5) {
					break;
				}
			}
			System.out.println();
		}

	}
}
