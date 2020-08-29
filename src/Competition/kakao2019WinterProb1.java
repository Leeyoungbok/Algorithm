package Competition;

import java.util.ArrayList;

public class kakao2019WinterProb1 {
	public static void main(String[] args) {

		// parameter " int{}{} board, int{} moves
		int answer = 0;

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		int X = board.length;
		int Y = board[0].length;
		int cnt = moves.length;
		int ret = 0;

		int idx = 0;
		int[] box = new int[1001];

//		for (int i = 0; i < X; i++) {
//			for(int j = 0 ; j < Y ; j++) {
//				System.out.print(board[i][j] + " ");
//			}System.out.println();
//		}

		for (int k = 0; k < cnt; k++) {
			int n1 = moves[k] - 1;
			for (int j = 0; j < Y; j++) {
				if (board[j][n1] != 0) {
					int getNum = board[j][n1];
//					System.out.println(getNum);
					board[j][n1] = 0;
					if (idx > 0 && box[idx - 1] == getNum) {
						box[idx - 1] = 0;
						idx--;
						ret += 2;
					} else {
						box[idx] = getNum;
						idx++;
					}
					break;
				}
			}
		}

		System.out.println(ret);

		// return answer;

	}
}
