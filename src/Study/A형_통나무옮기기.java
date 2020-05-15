package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class treeMove{
	int x;
	int y;
	int cur; // 0�̸� ���� 1�̸� ����
	int cnt;
	treeMove(int x, int y, int cur, int cnt){
		this.x = x;
		this.y = y;
		this.cur = cur;
		this.cnt = cnt;
	}
}

public class A형_통나무옮기기 {
	static int N, ECnt, ECur, EX, EY;
	static int[][] map;
	static boolean[][][] used;
	static Deque<treeMove> queue = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		used = new boolean[N+1][N+1][2]; // 0�ΰ��  : ���� üũ  , 1�ΰ�� : ���� üũ
		int BCnt = 0;
		int BCur = 0;
		for(int i = 1 ; i <= N ; i++) {
			String str = br.readLine();
			for(int j = 1 ; j <= N ; j++) {
				if(str.charAt(j-1) == 'B') {
					map[i][j] = 9;
					BCnt++;
					if(BCnt == 2) {
						if(i-1 >= 1 && map[i-1][j] == 9) {
							BCur = 1;
						}
						queue.add(new treeMove(i,j,BCur,0));
						used[i][j][BCur] = true;
					}
				}
				else if(str.charAt(j-1) == 'E') {
					map[i][j] = -1;
					ECnt++;
					if(ECnt==2) {
						if(i-1 >= 1 && map[i-1][j] == -1) {
							ECur = 1;
						}
						EX = i;
						EY = j;
					}
				}
				else
					map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
			}
		}
		if(!bfs())
			System.out.println(0);
		
	}
	
	static boolean bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0 ; s < size ; s++) {
				treeMove tree = queue.poll();
				for(int k = 0 ; k < 4 ; k++) { // turn���� �ʰ� �׳� �̵��ϴ� ���
					int ax = tree.x + dx[k];
					int ay = tree.y + dy[k];
					if(!isPossibleGo(ax, ay, k, tree.cur) || used[ax][ay][tree.cur]) continue;
					if(ax == EX && ay == EY) {
						if(tree.cur == ECur) {
							System.out.println(tree.cnt+1);
							System.exit(0);
						}else {
							if(isPossibleTurn(ax, ay, tree.cur)){
								System.out.println(tree.cnt+2);
								System.exit(0);
							}
						}
					}
					used[ax][ay][tree.cur] = true;
					queue.add(new treeMove(ax, ay, tree.cur, tree.cnt+1));
				}
				
				if(isPossibleTurn(tree.x, tree.y, tree.cur)) { // turn �ϰ� ������ �� �ִ��� �˻��ϰ� turn �Ѵ��� ����
					int changeCur = 0;
					if(tree.cur == 0)
						changeCur = 1;
					if(used[tree.x][tree.y][changeCur]) continue;
					queue.add(new treeMove(tree.x, tree.y, changeCur, tree.cnt+1));
				}
			}
		}
		return false;
	}
	
	static boolean isPossibleGo(int ax, int ay, int dir, int cur) {
		if(cur == 0) {
			if(dir == 0) {
				if(ax >= 1 && map[ax][ay-1] != 1 && map[ax][ay] != 1 && map[ax][ay+1] != 1)
					return true;
			}else if(dir == 1) {
				if(ax <= N  && map[ax][ay-1] != 1 && map[ax][ay] != 1 && map[ax][ay+1] != 1)
					return true;
			}else if(dir == 2) {
				if(ay-1 >= 1  && map[ax][ay-1] != 1)
					return true;
			}else if(dir == 3) {
				if(ay+1 <= N && map[ax][ay+1] != 1)
					return true;
			}
		}else {
			if(dir == 0) {
				if(ax-1 >= 1 && map[ax-1][ay] != 1)
					return true;
			}else if(dir == 1) {
				if(ax+1 <= N  && map[ax+1][ay] != 1)
					return true;
			}else if(dir == 2) {
				if(ay >= 1  && map[ax-1][ay] != 1 && map[ax][ay] != 1 && map[ax+1][ay] != 1)
					return true;
			}else if(dir == 3) {
				if(ay <= N &&  map[ax-1][ay] != 1 && map[ax][ay] != 1 && map[ax+1][ay] != 1)
					return true;
			}
		}
		
		
		return false;
	}
	
	static boolean isPossibleTurn(int x, int y, int cur) {
		if(cur == 0) {
			if(x-1 < 1 || x + 1 > N) return false;
			if(map[x-1][y-1] == 1 || map[x-1][y] == 1 || map[x-1][y+1] == 1) return false;
			if(map[x+1][y-1] == 1 || map[x+1][y] == 1 || map[x+1][y+1] == 1) return false;
		}else {
			if(y-1 < 1 || y + 1 > N) return false;
			if(map[x-1][y-1] == 1 || map[x][y-1] == 1 || map[x+1][y-1] == 1) return false;
			if(map[x-1][y+1] == 1 || map[x][y+1] == 1 || map[x+1][y+1] == 1) return false;
		}
		return true;
	}
}

//4
//000E
//BBBE
//000E
//0000
//
//4
//0B00
//EB00
//EB00
//E000
//
//4
//BBB0
//0E00
//0E00
//0E00
