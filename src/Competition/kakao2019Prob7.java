package Competition;

public class kakao2019Prob7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 4, 4, 0, 0, 0 }, { 0, 0, 0, 0, 3, 0, 4, 0, 0, 0 }, { 0, 0, 0, 2, 3, 0, 0, 0, 5, 5 },
				{ 1, 2, 2, 2, 3, 3, 0, 0, 0, 5 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 5 } };
		System.out.println(solution(arr));
	}

	private static int solution(int[][] board) {
		int answer = 0;

//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}System.out.println();
//		}

		loop : while (true) {
			boolean check = false;
			for (int j = 0; j < board[0].length; j++) {
				for (int i = 0; i < board.length; i++) {
					if (board[i][j] != 0) {
						if (caseOne(i, j, board)) {
							answer++;
							check = false;
							continue loop;
						} else if (caseTwo(i, j, board)) {
							answer++;
							check = false;
							continue loop;
						} else if (caseThree(i, j, board)) {
							answer++;
							check = false;
							continue loop;
						} else if (caseFour(i, j, board)) {
							answer++;
							check = false;
							continue loop;
						} else if (caseFive(i, j, board)) {
							answer++;
							check = false;
							continue loop;
						} 
					}
				}
			}
			if(!check) {
//				for (int i = 0; i < board.length; i++) {
//					for (int j = 0; j < board[0].length; j++) {
//						System.out.print(board[i][j] + " ");
//					}System.out.println();
//				}				
				return answer;
			}
		}
	}

	static boolean caseOne(int i, int j, int[][] board) {
		int num = board[i][j];

		if (i + 1 >= board.length || j + 1 >= board[0].length || j + 2 >= board[0].length)
			return false;

		if (board[i + 1][j] != num)
			return false;
		if (board[i + 1][j + 1] != num)
			return false;
		if (board[i + 1][j + 2] != num)
			return false;
		for(int ii = i ; ii >= 0 ; ii--) {
			if(board[ii][j+1] != 0 || board[ii][j+2] != 0)
				return false;
		}

		board[i][j] = 0;
		board[i + 1][j] = 0;
		board[i + 1][j + 1] = 0;
		board[i + 1][j + 2] = 0;

		return true;
	}

	static boolean caseTwo(int i, int j, int[][] board) {
		int num = board[i][j];

		if (i + 1 >= board.length || i + 2 >= board.length || j - 1 < 0)
			return false;
		if (board[i + 1][j] != num)
			return false;
		if (board[i + 2][j] != num)
			return false;
		if (board[i + 2][j - 1] != num)
			return false;
		for(int ii = i+1 ; ii >= 0 ; ii--) {
			if(board[ii][j-1] != 0)
				return false;
		}

		board[i][j] = 0;
		board[i + 1][j] = 0;
		board[i + 2][j] = 0;
		board[i + 2][j - 1] = 0;

		return true;
	}

	static boolean caseThree(int i, int j, int[][] board) {

		int num = board[i][j];

		if (i + 1 >= board.length || i + 2 >= board.length || j + 1 >= board[0].length)
			return false;

		if (board[i + 1][j] != num)
			return false;
		if (board[i + 2][j] != num)
			return false;
		if (board[i + 2][j + 1] != num)
			return false;
		
		for(int ii = i+1 ; ii >= 0 ; ii--) {
			if(board[ii][j+1] != 0)
				return false;
		}
		
		board[i][j] = 0;
		board[i + 1][j] = 0;
		board[i + 2][j] = 0;
		board[i + 2][j + 1] = 0;
		return true;
	}

	static boolean caseFour(int i, int j, int[][] board) {
		int num = board[i][j];
		if (i + 1 >= board.length || j - 1 < 0 || j - 2 < 0)
			return false;
		
		if (board[i + 1][j] != num)
			return false;
		if (board[i + 1][j - 1] != num)
			return false;
		if (board[i + 1][j - 2] != num)
			return false;
		for(int ii = i ; ii >= 0 ; ii--) {
			if(board[ii][j-1] != 0 || board[ii][j-2] != 0)
				return false;
		}
		board[i][j] = 0;
		board[i + 1][j] = 0;
		board[i + 1][j - 1] = 0;
		board[i + 1][j - 2] = 0;

		return true;
	}

	static boolean caseFive(int i, int j, int[][] board) {
		int num = board[i][j];

		if (i + 1 >= board.length || j - 1 < 0 || j + 1 >= board[0].length)
			return false;

		if (board[i + 1][j] != num)
			return false;
		if (board[i + 1][j - 1] != num)
			return false;
		if (board[i + 1][j + 1] != num)
			return false;
		for(int ii = i ; ii >= 0 ; ii--) {
			if(board[ii][j-1] != 0 || board[ii][j+1] != 0)
				return false;
		}

		board[i][j] = 0;
		board[i + 1][j] = 0;
		board[i + 1][j - 1] = 0;
		board[i + 1][j + 1] = 0;

		return true;
	}

}
