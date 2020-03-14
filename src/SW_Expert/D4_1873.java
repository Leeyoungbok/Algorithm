package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1873 {
	static int H, W;
	static char[][] map;
	static Tank tank;
	static int[] di = {-1,1,0,0}; // 0:�� 1:�� 2:�� 3:��
	static int[] dj = {0,0,-1,1};
	static final int UP=0, DOWN=1, LEFT=2, RIGHT=3;
	static int orderCnt;
	static String order;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i=0; i<H; i++) { // �� ������ �Է¹���.
				String line = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
					switch(map[i][j]) { // ������ �Է� ������ ?! ������ ��ǥ, ������ ����ϰ� ���ڸ��� ������.
					case '^': 
						tank = new Tank(i,j);
						tank.dir = UP;
						map[i][j] = '.';
						break;
					case 'v':
						tank = new Tank(i,j);
						tank.dir = DOWN;
						map[i][j] = '.';
						break;
					case '<':
						tank = new Tank(i,j);
						tank.dir = LEFT;
						map[i][j] = '.';
						break;
					case '>':
						tank = new Tank(i,j);
						tank.dir = RIGHT;
						map[i][j] = '.';
						break;
					}
				}
			} // �Է� ��
			
			orderCnt = Integer.parseInt(br.readLine()); // ��� ����
			order = br.readLine(); // ��ɾ� ����.
			
			for(int i=0; i<orderCnt; i++) {
				char op = order.charAt(i); // ��ɾ� ���ڸ� ����
				if(op=='S') { // ��ź �߻� ����� ���
					int ni = tank.i; // ���� ��ġ���� ��ź�� �����.
					int nj = tank.j;
					while(true) { // ��ź�� �󸶳� ���ư��� �����ϱ�
						ni = ni + di[tank.dir]; // �ϴ� ���� �������� ��ĭ �̵��� ��ǥ
						nj = nj + dj[tank.dir];
						if(ni>=H || ni<0 || nj>=W || nj<0 || map[ni][nj]=='#') // �ʹ� or ��ö��
							break;
						
						if(map[ni][nj]=='*') { // ���� if�� �Ȱɷ����� �ϴ� �� �ȿ� ����. �������� ���.
							map[ni][nj]='.';
							break;
						}
					}					
				}else { // �̵� ����� ���
					switch(op) { // �ϴ� ���� ������ ������ �����ϰ�.
					case 'U': tank.dir = UP; break;
					case 'D': tank.dir = DOWN; break;
					case 'L': tank.dir = LEFT; break;
					case 'R': tank.dir = RIGHT; break;
					} // ���� ������.
					int ni = tank.i + di[tank.dir];
					int nj = tank.j + dj[tank.dir];
					if(ni>=0 && ni<H && nj>=0 && nj<W && map[ni][nj]=='.') { // �ٲ� ���⿡�� ĭ �̵�
						tank.i = ni; 
						tank.j = nj;
					}
				}
			} // ��ɾ� ���� loop
			
			switch(tank.dir) {
			case UP: 	map[tank.i][tank.j]='^';break;
			case DOWN: 	map[tank.i][tank.j]='v';break;
			case LEFT: 	map[tank.i][tank.j]='<';break;
			case RIGHT: map[tank.i][tank.j]='>';break;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static class Tank{
		int i, j, dir;
		Tank(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}









