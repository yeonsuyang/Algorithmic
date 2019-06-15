package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {
	
	static int[][] cache = new int[501][501];
	static int[][] tri = new int[501][501];
	
	public static void main(String arg[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 삼각형 크기
	     StringTokenizer st=null;
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<(i+1);j++) {
				tri[i][j] =Integer.parseInt(st.nextToken());
			}
		}
			
			cache[1][1] = tri[1][1];
			
			for(int i=2;i<=N;i++) {
				for(int j=1;j<=i;j++) {
					if(j==1) {
						cache[i][j] = cache[i-1][j] + tri [i][j];
					}else if(j==i) {
						cache[i][j] = cache[i-1][j-1] + tri[i][j];
					}else {
						cache[i][j] = max(cache[i-1][j],cache[i-1][j-1]) + tri[i][j];
					}
				}
			}
			
			int ans = 0;
			for(int i=1;i<=N;i++) {
				ans = max(ans,cache[N][i]);
			}
			
			System.out.println(ans);
	}
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
}