package etc;

import java.util.ArrayList;

public class Solution42889 {
	public static void main(String[] args) {
			int N = 5;
			int[] stages = {2,1,2,6,2,4,3,3};
			
			int[] ans = solution(N,stages);
			for(int i = 0;i<ans.length;i++) {
				System.out.print(ans[i]);
				if(i != ans.length -1) {
					System.out.print(",");
				}
			}
	}
	 public static int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        float[] result = new float[N];
	        int[] sum = new int[N];

	        for(int i=0;i<stages.length;i++) {
	        	if(stages[i] <= N) {
	        		sum[(stages[i]-1)]++;
	        	}
	        }
	        int nSum = 0;
	        for(int i=0;i<N;i++) {
	        
	        	result[i] = (float)sum[i]/(stages.length - nSum);
	        	
	        	nSum += sum[i];
	        }
	        
	        ArrayList<Integer> numbers = new ArrayList<>();
	        numbers.add(0);
	      
	        for(int i=1;i<result.length;i++) { 
	        	for(int j=0;j<i;j++) {
	        		if(result[i]-result[numbers.get(j)] > 0) {
	        			numbers.add(j, i);
	        			break;
	        		}
	        		if(j == (i-1)) {
	        			numbers.add(i);
	        		}
	        	}
	        	
	        }
	        for(int i=0;i<numbers.size();i++) {
	        	System.out.println("");
	        	answer[i] = numbers.get(i)+1;
	        }
	        
	        
	        
	        return answer;
	 }
}
