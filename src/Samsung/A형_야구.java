package Samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class A형_야구 {
	static int[][] hit;
	static int[] person = new int[10];
	static int N;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		hit = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				hit[i][j] = sc.nextInt();
			}
		}
		int[] toSort = { 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] sortPerson = new int[toSort.length];
		boolean[] check = new boolean[toSort.length];
		perm(toSort, sortPerson, check, 0);
		System.out.println(ans);
		sc.close();
	}

	static void perm(int[] toSort, int[] sortPerson, boolean[] check, int idx) {
		if (idx == toSort.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < toSort.length; i++) {
				if (i == 3)
					list.add(1);
				list.add(sortPerson[i]);
			}
			int score = 0;		        
			 int batting_order = 0; // Ÿ��
			for (int i = 1; i <= N; i++) {
//				 int out_cnt = 0;
//		         boolean[] base = new boolean[4];
//				 while (true) {
//		                // Ÿ���� ���� �Ѱ��� ������ �´�
//		                int infor = hit[i][list.get(batting_order)];
//		                
//		                // Ÿ���� �ٲ��ش�
//		                if (batting_order == 8) {
//		                    batting_order = 0;
//		                } else
//		                    batting_order++;
//		                
//		                // Ÿ���� �������� �ٸ� ������ �Ѵ�.
//		                if (infor == 0) {
//		                    out_cnt++;
//		                    if (out_cnt >= 3) {
//		                        break;
//		                    }
//		                } else if (infor == 1) {
//		                    if(base[3]) {
//		                        score++;
//		                        base[3] = false;
//		                    }
//		                    for (int j = 2; j >= 0; j--) {
//		                        if(base[j]) {
//		                            base[j] = false;
//		                            base[j+1] = true;
//		                        }
//		                    }
//		                    base[1] = true;
//		                } else if (infor == 2) {
//		                    if(base[3]) {
//		                        score++;
//		                        base[3] = false;
//		                    }
//		                    if(base[2]) {
//		                        score++;
//		                        base[2] = false;
//		                    }
//		                    if(base[1]) {
//		                        base[1] = false;
//		                        base[3] = true;
//		                    }
//		                    base[2] = true;
//		                } else if (infor == 3) {
//		                    for (int j = 1; j <= 3; j++) {
//		                        if(base[j]) {
//		                            score++;
//		                            base[j] = false;
//		                        }
//		                    }
//		                    base[3] = true;
//		                } else if (infor == 4) {
//		                    for (int j = 1; j <= 3; j++) {
//		                        if(base[j]) {
//		                            score++;
//		                            base[j] = false;
//		                        }
//		                    }
//		                    score++;
//		                }
//		            }
				int outCnt = 0;
				boolean[] round = new boolean[4];
				while (true) {
					int who = list.get(batting_order);
					int run = hit[i][who];
					if (batting_order == 8) {
	                    batting_order = 0;
	                } else
	                    batting_order++;
					if (run == 0) {
						outCnt++;{
							if (outCnt == 3)
								break;
						}
					} else {
						if (run == 4)
							score++;
						for (int j = 1; j <= 3; j++) {
							if (round[j]) {
								if (j + run > 3) {
									score++;
									round[j] = false;
								} else {
									round[j + run] = true;
									round[j] = false;
								}
							}
							if (j == run)
								round[j] = true;
						}
					}
					
				}
			}
			if (ans < score)
				ans = score;
			return;
		}

		for (int i = 0; i < toSort.length; i++) {
			if (!check[i]) {
				sortPerson[idx] = toSort[i];
				check[i] = true;
				perm(toSort, sortPerson, check, idx + 1);
				check[i] = false;
			}
		}
	}
}
