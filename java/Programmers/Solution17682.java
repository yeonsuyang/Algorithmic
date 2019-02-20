package study;

public class Solution17682 {
	public static void main(String[] args) {
		
		String dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));
		
	}
	public static int solution(String dartResult) {
	      int answer = 0;
	      
	      char[] result = dartResult.toCharArray();
	      int[] score = new int[3];
	      
	      int temp = -1;
	      String cal = "";
	      
	      for(int i=0;i<result.length;i++) {

	    	  if(result[i] != 'S' && result[i] != 'D' && result[i] != 'T' && result[i] != '*'  && result[i] != '#') {
	    		 cal += result[i];
	    	  }else if(result[i] == 'S' || result[i] == 'D' || result[i] == 'T'){
	    		 temp++;
	    		 score[temp] = Integer.parseInt(cal);
	    		 cal = "";
	    	  }
	    	  if(result[i] == 'S') {
	    		 score[temp] = (int)Math.pow(score[temp], 1);
	    	  }else if(result[i] == 'D') {
	    		  score[temp] = (int)Math.pow(score[temp], 2);
	    	  }else if(result[i] == 'T') {
	    		  score[temp] = (int)Math.pow(score[temp], 3);
	    	  }else if(result[i] == '*') {
	    		  if(temp > 0) {
	    			  score[temp-1] = score[temp-1] * 2;
	    		  }
	    		  score[temp] = score[temp] * 2;
	    	  }else if(result[i] == '#') {
	    		  score[temp] = score[temp] * (-1);
	    	  }
	      }
	      
	      for(int i=0;i<score.length;i++) {
	    	  answer += score[i];
	      }
	      return answer;
	  }
}
