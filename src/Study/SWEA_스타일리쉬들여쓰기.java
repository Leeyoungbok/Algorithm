package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
�ذ� ���1 : ���нð�ó�� Ǯ���Ѵ�.
������ ����
({abc	0
....})a	4
[ab		0
.]		1

R + C = 4
S = 1

������ �ظ� ���ϱ����� �������� �����ϴ�
�׷��ٰ� -1 �̶�� �ٷ� ǥ���ϴ°��� �ƴ϶�, �� ���������ε� �ذ��� �� �ִ� �鿩���� �ڵ尡 ������ �ֽ��ϴ�.
�������
(({{abc			0
........}}))a	8
[[ab			0
..]]			2
(ab				0
???			   -1

�̿ܿ� ����ؾ��ϴ� �͵��� ������ ����
�ϳ��� ��츦 ã�Ƽ� �����ϱ⿣ ������ �� �ִ�. Greedy

�ذ� ���2 :
1 <= R,C,S <= 20 ���� ��� ������ Ȱ�� (������ �����ϰ�, ����)
������ ��� R,C,S �� ���� ���غ��� (������ ���� �����°͵� �����ϹǷ� �ߺ�����)
 *
 */
public class SWEA_��Ÿ�ϸ����鿩���� {
	private static int[][] m;
	private static int[][] dap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // p ��Ÿ�ϸ����� �������� ����� �ڵ� �� �� (1 �� p, q �� 10)
			int q = Integer.parseInt(st.nextToken()); // q ��� �ڵ��� �� �� (1 �� p, q �� 10)
			m = new int[p][4];
			
			for (int i = 0; i < p; i++) { 
				String line = br.readLine();
				
				int index = 0;
				while(line.charAt(index) == '.') { 
					index++;
				}
				m[i][0] = index; // .�� ���� 
				if (i > 0) { 
					m[i][1] = m[i-1][1];
					m[i][2] = m[i-1][2];
					m[i][3] = m[i-1][3];
				}

				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': m[i][1]++; break;
					case ')': m[i][1]--; break;
					case '{': m[i][2]++; break;
					case '}': m[i][2]--; break;
					case '[': m[i][3]++; break;
					case ']': m[i][3]--; break;
					}
				}
			} 
			dap = new int[q][4];
			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0;
				if (i > 0) {
					dap[i][1] = dap[i-1][1];
					dap[i][2] = dap[i-1][2];
					dap[i][3] = dap[i-1][3];
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': dap[i][1]++; break;
					case ')': dap[i][1]--; break;
					case '{': dap[i][2]++; break;
					case '}': dap[i][2]--; break;
					case '[': dap[i][3]++; break;
					case ']': dap[i][3]--; break;
					}
				}
			}
			
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2; // �ʱⰪ 
			}

			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R,C,S)) {
							cal(R,C,S);
						}
					}
				}
			}
			
			sb.append('#').append(testCase).append(" 0"); 
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			sb.append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
	public static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i-1][1]*R+dap[i-1][2]*C+dap[i-1][3]*S;
			if (dap[i][0] == -2) {
				dap[i][0] = x;
			} else if (dap[i][0] != x) {
				dap[i][0] = -1;
			}
		}
	}
	public static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] != m[i-1][1]*R+m[i-1][2]*C+m[i-1][3]*S) { 
				return false;
			}
		}
		return true;
	}
} // end of class