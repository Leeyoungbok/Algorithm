package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1039 {

	static Queue<Integer> queue = new LinkedList<>();
	static int numSize;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		numSize =(N + "").length();
		System.out.println(solution(N, K));
	}

	static private int solution(int N, int K) {
		if(numSize == 1) // 조건 1.
			return -1;
		
		int maxVal = -1;

		queue.add(N);

		while (!queue.isEmpty()) {
			int size = queue.size();
			if(K-- == 0) break;
			boolean[] used = new boolean[10000000];
			for(int s = 0 ; s < size ; s++) {
				int n1 = queue.poll();
				// exchange and find maxValue
				// 이중 for 사용해서 하나씩 돌림
				for(int i = 0 ; i < numSize - 1 ; i++) {
					String s1 = n1 + ""; 
					for(int j = i + 1 ; j < numSize ; j++) {
						if(i == 0 && s1.charAt(j) == '0') continue;
						char c1 = s1.charAt(i);
						char c2 = s1.charAt(j);// 2913 1
						int n2 = Integer.parseInt(s1.substring(0, i) + c2 + s1.substring(i+1, j) + c1 + s1.substring(j+1, numSize));
						if(used[n2]) continue;
						used[n2] = true;
						queue.add(n2);
						if(K == 0) {
							maxVal = maxVal < n2 ? n2 : maxVal;
						}
					}
				}
				// maxVal 보다 크면 저장. 아니면 중복 체크하고 넣어버림.
			}
		}
		return maxVal;
	}
}
