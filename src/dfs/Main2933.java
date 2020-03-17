package dfs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 
창영과 상근은 한 동굴을 놓고 소유권을 주장하고 있다. 

두 사람은 막대기를 서로에게 던지는 방법을 이용해 누구의 소유인지를 결정하기로 했다. 
싸움은 동굴에서 벌어진다. 동굴에는 미네랄이 저장되어 있으며, 던진 막대기가 미네랄을 파괴할 수도 있다.

동굴은 R행 C열로 나타낼 수 있으며, R×C칸으로 이루어져 있다. 각 칸은 비어있거나 미네랄을 포함하고 있으며, 
네 방향 중 하나로 인접한 미네랄이 포함된 두 칸은 같은 클러스터이다.

창영은 동굴의 왼쪽에 서있고, 상근은 오른쪽에 서있다. 두 사람은 턴을 번갈아가며 막대기를 던진다. 
막대를 던지기 전에 던질 높이를 정해야 한다. 막대는 땅과 수평을 이루며 날아간다.

막대가 날아가다가 미네랄을 만나면, 그 칸에 있는 미네랄은 모두 파괴되고 막대는 그 자리에서 이동을 멈춘다.

미네랄이 파괴된 이후에 남은 클러스터가 분리될 수도 있다. 새롭게 생성된 클러스터가 떠 있는 경우에는 중력에 의해서 바닥으로 떨어지게 된다. 
떨어지는 동안 클러스터의 모양은 변하지 않는다. 클러스터는 다른 클러스터나 땅을 만나기 전까지 게속해서 떨어진다. 클러스터는 다른 클러스터 위에 떨어질 수 있고, 그 이후에는 합쳐지게 된다.

동굴에 있는 미네랄의 모양과 두 사람이 던진 막대의 높이가 주어진다. 모든 막대를 던지고 난 이후에 미네랄 모양을 구하는 프로그램을 작성하시오.
첫째 줄에 동굴의 크기 R과 C가 주어진다. (1 ≤ R,C ≤ 100)
다음 R개 줄에는 C개의 문자가 주어지며, '.'는 빈 칸, 'x'는 미네랄을 나타낸다.
다음 줄에는 막대를 던진 횟수 N이 주어진다. (1 ≤ N ≤ 100)

마지막 줄에는 막대를 던진 높이가 주어지며, 공백으로 구분되어져 있다. 모든 높이는 1과 R사이이며, 높이 1은 행렬의 가장 바닥, R은 가장 위를 의미한다. 
첫 번째 막대는 왼쪽에서 오른쪽으로 던졌으며, 두 번째는 오른쪽에서 왼쪽으로, 이와 같은 식으로 번갈아가며 던진다.
공중에 떠 있는 미네랄 클러스터는 없으며, 두 개 또는 그 이상의 클러스터가 동시에 떨어지는 경우도 없다.


8 8
........
........
...x.xx.
...xxx..
..xxx...
..x.xxx.
..x...x.
.xxx..x.
5
6 6 4 3 1

........
........
.....x.
...xxx..
..xx...
..x....
..x...x.
.xxxxxx.


........
........
........
........
.....x..
..xxxx..
..xxx.x.
..xxxxx.

10 20
..................xx
..................x.
.........xxxx...xxx.
.....xx.xx.xx..xxx..
......xxx..xx.xx....
.......x.....xxx....
.....xxx....xxx.....
...xxx...xxxx.......
...x...xxxxxx.......
.xxxxxxxxx..........
5
5 3 2 5 4

 */

public class Main2933 {
	static int R;
	static int C;
	static char[][] input;
	static int[][] movecount;
	static int[][] divide;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Integer> dmc = new ArrayList<Integer>();
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();// 세로
		C = sc.nextInt();// 가로
		input = new char[R][C];

		for (int i = 0; i < R; i++) {
			String st = sc.next();
			for (int j = 0; j < C; j++) {
				input[i][j] = st.charAt(j);
			} // 입력받고
		}

		int N = sc.nextInt(); // 막대 던질 횟 수
		int Ncount = N;

		while (Ncount > 0) {
			int mac = sc.nextInt();

			if ((N - Ncount) % 2 == 0) {// 왼쪽에서
				int h = R - mac;
				for (int j = 0; j < C; j++) {
					if (input[h][j] == 'x') {
						input[h][j] = '.';
						break;
					}

				}
			} else {// 오른쪽에서
				int h = R - mac;
				for (int j = C - 1; j >= 0; j--) {
					if (input[h][j] == 'x') {
						input[h][j] = '.';
						break;
					}
				}

			}

			change(input);// 한번만 내리면 됨

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(input[i][j]);
				} // 결과값 출력
				System.out.println();
			}
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ내린후 : " +Ncount);
			Ncount--;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(input[i][j]);
			} // 결과값 출력
			System.out.println();
		}
	}

	private static void change(char[][] input) {
		
		movecount = new int[R][C];
		divide = new int[R][C];
		visit = new int[R][C];

		// 내릴 수 있는 수 저장.

		for (int j = 0; j < C; j++) {
			int charEnd = -1;
			int charStart = -1;
			int blankEnd = -1;

			for (int i = 0; i < R; i++) {
				if (input[i][j] != '.') {
					charEnd = i;
					if (charStart == -1) {
						charStart = i;
					}
				} else {
					blankEnd = i;
					if (charStart != -1 && blankEnd - charEnd > 0) {
						for (int k = charEnd; k >= charStart; k--) {
							movecount[k][j]++;
						}
					}
				}
			} // 끝까지 정하고 나면
		}
		

		// 영역검사해서, 영역별로 내릴 수 있는 수 하고
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] != '.' && visit[i][j] == 0) {
					calculate(i, j); // 영역 계산하러 고
				}
			}
		};
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(divide[i][j]);
			} // 결과값 출력
			System.out.println();
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡdivide");
		
		// 진짜 영역이 계산 된 만큼 내릴 수 있는 지 검사.

		for (int i = 0; i < C; i++) {
			int last = -1;
			int clast = -1;
			int next = -1;
			int cnext = -1;
			for (int j = R - 1; j >= 0; j--) {
				if (input[j][i] == 'x') {
					if (last == -1) {
						last = j;
						int temp = divide[j][i] - 1;
						clast = j + dmc.get(temp);
					} else {
						if (next == -1) {
							next = j;
							int temp = divide[j][i] - 1;
							cnext = j + dmc.get(temp);

							if (cnext >= clast) {
								int change = dmc.get(temp) - ((cnext - clast) + 1);
								dmc.remove(temp);
								dmc.add(temp, change);
							}

							last = next;
							clast = cnext;
							next = -1;
							cnext = -1;
						}
					}
				}
			}
		}
		
		for(int i=0;i<dmc.size();i++) {
			System.out.print(dmc.get(i) + " ,");
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡdmc");
		// 영역이 계산 된 만큼 내림
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] == 'x') {
					int temp = divide[i][j] - 1;
					int movec = dmc.get(temp);
					if (movec > 0) {
						input[i + movec][j] = input[i][j];
						input[i][j] = '.';
					}
				}
			}
		}
	}

	private static void calculate(int y, int x) {

		count++;
		visit[y][x] = 1;
		divide[y][x] = count;

		int tempCount = movecount[y][x];
		int resultCount = 0;

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int hy = p.y + dy[i];
				int hx = p.x + dx[i];

				if (hy < 0 || hx < 0 || hy > R - 1 || hx > C - 1) {
					continue;
				}

				if (input[hy][hx] == '.' || visit[hy][hx] != 0) {
					continue;
				}

				divide[hy][hx] = count;
				visit[hy][hx] = 1;
				q.add(new Point(hx, hy));
				if (movecount[hy][hx] < tempCount) {
					tempCount = movecount[hy][hx];

				}
			}
		}
		resultCount = tempCount;
		dmc.add(resultCount);
	}
}