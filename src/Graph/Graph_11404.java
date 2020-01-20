package Graph;

/*
 *  �÷��̵� �ͼ� �˰��� - '��� �������� ��� ����������' �ִ� ��θ� ���ϴ� �˰���
 *  			-> ���İ��� ������ �������� �˰����� ����
 *  
 *  ���ͽ�Ʈ�� �˰��� - '�ϳ��� �������� �ٸ� ��� ����������' �ִ� ��θ� ���ϴ� �˰���
 *  			-> ���� ���� ����� �ϳ��� ����
 *  
 *  for (int k = 1; k <= n; k++) {
	// ����ϴ� ��� i
		for (int i = 1; i <= n; i++) {
		// �����ϴ� ��� j
			for (int j = 1; j <= n; j++) {
			// i���� k�� ���ƴٰ� k���� j ���� ���� �Ÿ��� i���� j ���� ���� �Ÿ��� ���ؼ� ���� ���� �ּҰŸ��̴�.
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
			// ����ϴ� ��� i
			for (int i = 1; i <= n; i++) {
				// �����ϴ� ��� j
				for (int j = 1; j <= n; j++) {
					// i���� k�� ���ƴٰ� k���� j ���� ���� �Ÿ��� i���� j ���� ���� �Ÿ��� ���ؼ� ���� ���� �ּҰŸ��̴�.
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
