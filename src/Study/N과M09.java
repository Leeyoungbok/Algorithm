package Study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class N과M09 {
	static Set<String> res = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] copy = new int[m];
		
		boolean[] check = new boolean[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(arr, copy, check, 0);
		List<String> list = new ArrayList<String>(res);
		Collections.sort(list);
		
		for(String s : list)
			System.out.println(s);
		sc.close();
	}

	static void solve(int[] arr,int[] copy, boolean[] check, int idx) {
		if (idx == copy.length) {
			String str = "";
			for(int i = 0 ; i < idx; i ++) {
				str+= copy[i] + " ";
			}
			res.add(str.trim());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!check[i]) {
				copy[idx] = arr[i];
				check[i] = true;
				solve(arr, copy,check, idx + 1);
				check[i] = false;
			}
		}
	}

}
