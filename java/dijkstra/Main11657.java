package dijkstra;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다. 
각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다. 
시간 C가 양수가 아닌 경우가 있다. C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.

1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다. 
둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다. 

만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다. 
그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다. 
만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.

3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

4
3

3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

-1

3 3
1 2 3
2 1 -1000
2 1 5
-1

3 2
2 3 -2
3 2 -2
-1
-1

3 1
2 3 -10000
-1
-1

3 2
1 2 4
1 2 3
3
-1

 */
public class Main11657 {
	static ArrayList<Point> nosun[];
	static int N;
	static int[] time;
	static int tFlag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시 N개
		int M = Integer.parseInt(st.nextToken()); // 버스의 노선 개수

		time = new int[N + 1];
		nosun = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nosun[i] = new ArrayList<Point>();
			time[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()); // 도착 도시
			int t = Integer.parseInt(st.nextToken()); // 걸리는 시간
			
			nosun[start].add(new Point(end, t));
		}
		if(nosun[1].size() == 0) {
			
		}
		
		calculate();
		if (time[1] < 0 || tFlag == 1) {
			System.out.println(-1);
		}else if(nosun[1].size() == 0) {
			for (int i = 2; i <= N; i++) {
				System.out.println(-1);
			}
		}
		else {
		
			for (int i = 2; i <= N; i++) {
				System.out.println(time[i] == Integer.MAX_VALUE || time[i] < 0 ? -1 : time[i]);
			}

		}

	}

	private static void calculate() {

		int changeFlag = 1;
		time[1] = 0;

		while (changeFlag == 1) {
			changeFlag = 0;

			if (time[1] < 0) {
				break;
			}

			for (int i = 1; i < N + 1; i++) {// 도시의 갯수만큼 계속 돌기. 변한게 없을때까
				for (int j = 0; j < nosun[i].size(); j++) {// 돌 수 있는거 다 돌기.
					
					if(i==1 && time[nosun[i].get(j).x] <0) {
						changeFlag = 0;
						tFlag = 1;
						break;
					}
					if (time[nosun[i].get(j).x] > time[i] + nosun[i].get(j).y) {
						time[nosun[i].get(j).x] = time[i] + nosun[i].get(j).y;
						changeFlag = 1;
					}
					if(time[i] < 0 && nosun[i].get(j).y < 0) {
						changeFlag = 0;
						break;
					}
				}
			}
		}
	}
}
