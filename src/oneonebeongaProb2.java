import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class oneonebeongaProb2 {

	public static void main(String[] args) {
		String[] S = { "abc", "bca", "dbe" };
		System.out.println(Arrays.toString(solution(S)));
		System.out.println(Arrays.toString(solution2(S)));
		String[] S1 = { "zzzz", "ferz", "zdsr", "fgtd" };
		System.out.println(Arrays.toString(solution(S1)));
		System.out.println(Arrays.toString(solution2(S1)));
		String[] S2 = { "gr", "sd", "rg" };
		System.out.println(Arrays.toString(solution(S2)));
		System.out.println(Arrays.toString(solution2(S2)));
		String[] S3 = { "bdcfgaadd", "ceagics" };
		System.out.println(Arrays.toString(solution(S3)));
		System.out.println(Arrays.toString(solution2(S3)));
	}

	public static int[] solution(String[] S) {
		for (int i = 0; i < S.length - 1; i++) {
			for (int j = i + 1; j < S.length; j++) {
				int nextLen = S[j].length();
				for (int k = 0; k < S[i].length(); k++) {
					if (nextLen > k && S[i].charAt(k) == S[j].charAt(k)) {
						int[] ret = { i, j, k };
						return ret;
					}
				}
			}
		}
		int[] ret = {};
		return ret;
	}
	
	public static int[] solution2(String[] S) {
		int[][] arr = new int[26][30000];
		
		for(int i = 0 ; i < S.length ; i++) {
			for(int j = 0 ; j < S[i].length() ; j++) {
				if(arr[S[i].charAt(j) - 97][j] != 0) {
					int[] ret = { arr[S[i].charAt(j) - 97][j] - 1 , i, j };
					return ret;
				}
				arr[S[i].charAt(j) - 97][j] = i + 1; 
			}
		}
		int[] ret = {};
		return ret;
	}
}
