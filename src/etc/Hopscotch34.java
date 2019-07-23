package etc;

/**
영희는 땅따먹기 게임에 푹 빠졌습니다. 땅따먹기 게임의 땅은 총 N행 4열로 나누어져 있고, 
모든 칸에는 점수가 쓰여 있습니다. 
땅을 밟으면서 한 행씩 내려올 때, 영희는 각 행의 4칸 중 1칸만 밟으면서 내려올 수 있습니다. 
땅따먹기 게임에는 같은 열을 연속해서 밟을 수가 없는 특수 규칙이 있습니다. 
즉, 1행에서 (5)를 밟았다면, 2행의 (8)은 밟을 수가 없게 됩니다. 
마지막 행까지 모두 내려왔을 때, 점수가 가장 높은 사람이 게임의 승자가 됩니다.
여러분이 hopscotch 함수를 제작하여 영희가 최대 몇 점을 얻을 수 있는지 알려주세요. 
예를 들어
1 2 3 5
5 6 7 8
4 3 2 1
의 땅이 있다면, 영희는 각 줄에서 (5), (7), (4) 땅을 밟아 16점을 최고점으로 받을 수 있으며, 
hopscotch 함수에서는 16을 반환해주면 됩니다.
 */

public class Hopscotch34 {
	int hopscotch(int[][] board, int size) {
		   
        int result = 0;
        int tp = 4;
        int cp = 0;
        int mp = 0;
        int sum = 0;
        // 함수를 완성하세요.
        
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < 4; j++) {
			if (j != tp) {
				if (i + 1 < board.length) {
					if (mp <= board[i][j] && ((i > 1 && (board[i + 1][j] == board[i + 1][tp])) || (board[i][j] - board[i][cp]) >= (board[i + 1][j] - board[i + 1][cp]))) {
						mp = board[i][j];
						cp = j;
					}
				}
				else if (mp <= board[i][j]) {
					mp = board[i][j];
					cp = j;
				}

			}
		}
		System.out.println("이전선 : " + tp + ",열 :" + cp + ",선택  :" + mp);
		tp = cp;
		result += mp;
		mp = 0;
		cp = 0;
	}
        

        return result;
    }

	    public static void main(String[] args) {
	    	Hopscotch34 c = new Hopscotch34();
	        int[][] test = {{10, 6, 3, 7}, 
	        		        {2, 3, 3, 6}, 
	        		        {8, 8, 10, 3}, 
	        		        {5, 2, 6, 2}, 
	        		        {5, 6, 6, 9}, 
	        		        {5, 7, 9, 3}, 
	        		        {5, 1, 6, 7}, 
	        		        {4, 7, 5, 6}, 
	        		        {4, 1, 6, 9}, 
	        		        {4, 10, 8, 3}
	        };
	        //아래는 테스트로 출력해 보기 위한 코드입니다.
	        System.out.println(c.hopscotch(test, 3));
	    }
}