package NextPermu;

import java.util.Arrays;
import java.util.Scanner;

public class NP_9081 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n = 0 ; n < N ; n++) {
			char[] arr = sc.next().toCharArray();
			
			solve(arr);
		}
		sc.close();
	}
	
	static void solve(char[] arr) {
		int idx = -1;
		for(int i = 0 ; i < arr.length-1 ; i++) {
			if((int)arr[i] < (int)arr[i+1])
				idx = i;
		}
		if(idx == -1) {
			System.out.println(String.copyValueOf(arr));
			return;
		}
		for(int i = arr.length - 1 ; i > idx ; i--) {
			if(arr[idx] < arr[i]) {
				char tmp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = tmp;
				break;
			}
		}
		
		Arrays.parallelSort(arr, idx+1, arr.length);
		System.out.println(String.copyValueOf(arr));
	}
}
