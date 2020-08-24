import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class toss03 {
	public static void main(String[] args) throws Exception {
		// [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] str = input.split(" ");
		int[] arr = new int[500];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(String s : str) {
			int n1 = Integer.parseInt(s);
			
			System.out.print(map.get(n1)+ " ");
		}
	}
}
