package Samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A형_2048Easy {
	static int N, answer = 0;
	static int[][] map;
	static Queue<int[][]> queue = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// solution

		queue.add(map);
		int cnt = 0;
		while (!queue.isEmpty()) {
			if (cnt++ == 5) {
				System.out.println(answer);
				break;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[][] queuePollMap = copy(queue.poll());
				
				
				
				for (int k = 0; k < 4; k++) { // 상하좌우 이동
					int[][] copyMap = move(queuePollMap);
					
//					for(int i= 0 ; i < N ; i++) {
//						for(int j = 0 ; j < N ; j++) {
//							System.out.print(copyMap[i][j] + " ");
//						}System.out.println();
//					}System.out.println("----------");
					int max = getMaxNum(copyMap);
					answer = answer > max ? answer : max;
					queue.add(copyMap);
					queuePollMap = rotate(queuePollMap);
				}
			}
		}
	}

	private static int[][] move(int[][] map) {
		
		int[][] moveMap = copy(map);
		for (int i = 0; i < N; i++) {
			int used = -1;
			for (int j = 0; j < N; j++) {
				if (moveMap[i][j] == 0)
					continue;
				int idx = j;
			
				while (j != 0) {
					if((j - 1) >= 0 && moveMap[i][j - 1] != 0) {
						if(moveMap[i][j - 1] == moveMap[i][idx] && used != j - 1) { // 같을때
							used = j - 1;
							moveMap[i][j - 1] *= 2;
							moveMap[i][idx] = 0;
						}else if(moveMap[i][j] == 0){
							moveMap[i][j] = moveMap[i][idx];
							moveMap[i][idx] = 0;
						}
						
						break;
					}
					if(j == 1 && moveMap[i][0] == 0) {
						moveMap[i][0] = moveMap[i][idx];
						moveMap[i][idx] = 0;
						break;
					}
						
					j--;
				}
			}
		}
		
		return moveMap;
	}

	private static int[][] rotate(int[][] rotateMap) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = rotateMap[N - 1 - j][i];
			}
		}

		return temp;
	}

	private static int[][] copy(int[][] map) {
		int[][] ret = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret[i][j] = map[i][j];
			}
		}
		return ret;
	}

	private static int getMaxNum(int[][] copyMap) {
		int ret = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret = copyMap[i][j] > ret ? copyMap[i][j] : ret;
			}
		}

		return ret;
	}

}
