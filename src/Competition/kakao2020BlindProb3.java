package Competition;

public class kakao2020BlindProb3 {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		System.out.println(solution(key, lock));
	}

	static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;

		int N = key.length * 2 + lock.length;
		int M = key[0].length * 2 + lock[0].length;

		int[][] virtualMap = new int[N][M];
		int[][] cmpMap = new int[N][M];
		for (int i = key.length; i < key.length + lock.length; i++) {
			for (int j = key[0].length; j < key[0].length + lock[0].length; j++) {
				virtualMap[i][j] = lock[i - key.length][j - key[0].length];
			}
		}

		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < key.length + lock.length; i++) {
				outer: for (int j = 0; j < key[0].length + lock[0].length; j++) {
					cmpMap = new int[N][M];
					int ii = i;
					int jj = j;
					for (int a = i; a < i + key.length; a++) {
						for (int b = j; b < j + key[1].length; b++) {
							cmpMap[a][b] = key[a - ii][b - jj] == 1 ? 1 : 0;
						}
					}

					for (int a = key.length; a < key.length + lock.length; a++) {
						for (int b = key[0].length; b < key[0].length + lock[0].length; b++) {
							int n1 = cmpMap[a][b] + virtualMap[a][b];
							if (n1 == 0 || n1 == 2)
								continue outer;
						}
					}
					return true;
				}
			}
			turn(key);
		}
		return false;
	}

	static void turn(int[][] arr) {
		int n = arr.length;
		int[][] tmp = new int[arr.length][arr.length];
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				tmp[i][j] = arr[n-1-j][i];
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}
}
