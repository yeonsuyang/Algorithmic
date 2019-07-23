package etc;

import java.util.Arrays;

public class Solution17679 {
	
	 static char[][] input;
	 static int[][]	b;
	 static int[] dx = { 1, 0, 1};
	 static int[] dy = { 0, 1, 1};
	 static int answer = 0;
	 
	public static void main(String[] args) {

		int m = 4;
		int n = 5;
		
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		int temp = solution(m,n,board);
		System.out.println(temp);
	}
	
	 public static int solution(int m, int n, String[] board) {
		 int answer = 0;

		 input = new char[m][n];
		 b = new int[m][n];
		 
	      for(int i=0; i< m; i++) {
	    	  char[] t = board[i].toCharArray();
	    	  for(int j=0;j<n;j++) {
	    		  input[i][j] = t[j];
	    	  }
	      }
	      
	      answer = puzzle(m,n);
	    
	      return answer;
	  }
	 
	 private static int puzzle(int m, int n) {
		 
		 
		 int ans = 0;

		  for(int i=0;i<m-1;i++) {
		    	 for(int j=0;j<n-1;j++) {// 1 더해야 하므로 
		    		if(input[i][j] != 'X') {
		    			ans += calculate(i,j);
		    		}
		    	 }
		     }
	      
	      if(ans != 0) {
	    	  answer += ans;
	    	  change(m,n);
	    	  puzzle(m,n);
	      }
	      
	      return answer;
	}

	private static void change(int m, int n) {
		
		for(int i=0;i<m-1;i++) {
			for(int j=0;j<n;j++) {
				if(b[i+1][j] == -1) {
					if(b[i][j] != 'X' ) {
		 			input[i+1][j] = input[i][j];
		 			b[i+1][j] = 0;
					}
					input[i][j] = 'X';
				}
			}
		}
		
		for(int i=0;i<n;i++) {//안내려간 거 한번 더 내려주기.
			for(int j=m-2;j>=0;j--) {
				if(input[j][i] != 'X') {
					int temp=j;
					for(int c=m-1;c>j;c--) {
						if(input[c][i] != 'X') {
							if(temp > c) {
								temp = j;
							}
						}else {
							if(c > temp) {
							temp = c;
							}
						}
					}
					if(input[temp][i] == 'X') {
						input[temp][i] = input[j][i];
						input[j][i] = 'X';
					}
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			Arrays.fill(b[i],0);
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}

	private static int calculate(int y, int x) {
		 
		boolean temp = true;
		int ans = 0;
		
		for(int i=0;i<3;i++) {
			int hx = x + dx[i];
			int hy = y + dy[i];
			
			
			
			if(input[hy][hx] != input[y][x]) { //다르면
				temp = false;
				break;
			}
		}
		
		if(temp == true) {
			if(b[y][x] != -1) {
				ans++;
				b[y][x] = -1;
			}
			for(int i=0;i<3;i++) { //같으면 
				int hx = x + dx[i];
				int hy = y + dy[i];
				if(b[hy][hx] != -1) {
					ans++;
					b[hy][hx] = -1; //지워진 곳은 다 -1로 바꿔주기
				}
			}
		}
		return ans;
	 }
}


