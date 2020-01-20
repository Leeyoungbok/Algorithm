package Graph;

/*
 *  플로이드 와샬 알고리즘 - '모든 정점에서 모든 정점으로의' 최단 경로를 구하는 알고리즘
 *  			-> 거쳐가는 정점을 기준으로 알고리즘을 수행
 *  
 *  다익스트라 알고리즘 - '하나의 정점에서 다른 모든 정점으로의' 최단 경로를 구하는 알고리즘
 *  			-> 가장 적은 비용을 하나씩 선택
 *  
 *  for (int k = 1; k <= n; k++) {
	// 출발하는 노드 i
		for (int i = 1; i <= n; i++) {
		// 도착하는 노드 j
			for (int j = 1; j <= n; j++) {
			// i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
				bus[i][j] = Math.min(bus[i][k] + bus[k][j], bus[i][j]);
			}
		}
	}
 */
import java.util.Scanner;

public class Graph_11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] bus = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				bus[i][j] = 1000000000;
			}
		}
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();

			if (bus[start][end] == 0)
				bus[start][end] = cost;
			else
				bus[start][end] = bus[start][end] > cost ? cost : bus[start][end];
		}
		sc.close();
//		=====================================================

		for (int k = 1; k <= n; k++) {
			// 출발하는 노드 i
			for (int i = 1; i <= n; i++) {
				// 도착하는 노드 j
				for (int j = 1; j <= n; j++) {
					// i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
					bus[i][j] = Math.min(bus[i][k] + bus[k][j], bus[i][j]);
				}
			}
		}
//		=====================================================

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j)
					System.out.print("0" + " ");
				else
					System.out.print(bus[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
