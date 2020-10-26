import java.util.Arrays;

public class oneonebeongaProb3 {
	public static void main(String[] args) {
		int[] A = { 1, 2, 1 };
		System.out.println(solution(A));
		int[] A1 = { 2, 1, 4, 4 };
		System.out.println(solution(A1));
		int[] A2 = { 6, 2, 3, 5, 6, 3 };
		System.out.println(solution(A2));
		int[] A3 = { 1,1,1,1 };
		System.out.println(solution(A3));
		int[] A4 = { 4,4,4,4 };
		System.out.println(solution(A4));
	}

	public static int solution(int[] A) {
	int ret = 0;
	Arrays.sort(A);
	for(int i = 0 ; i < A.length ; i++) {
		ret += Math.abs(A[i] - (i+1));
		if(ret > 1000000000)
			return -1;
	}
	return ret;
	}
}
