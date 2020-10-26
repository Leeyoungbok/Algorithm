import java.util.Arrays;

public class coupangProb1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10)));
		System.out.println(Arrays.toString(solution(14)));
		System.out.println(Arrays.toString(solution(1000000)));
		System.out.println(Arrays.toString(solution(10)));
	}
	public static int[] solution(int N) {
		int[] answer = new int[2];
		int n = 0;
		int m = 0;
		
		for(int i = 2 ; i < 10 ; i++) {
			int sum = 1;
			int memo = N;
			while(memo != 0) {
				int k = memo % i;
				if(k != 0) {
					sum *= k;
				}
				memo /= i;
			}
			if(sum >= m) {
				answer[0] = i;
				answer[1] = sum;
				m = sum;
			}
		}
		return answer;
	}

}
