package etc;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution8034_3 {
	public static void main(String[] args) {
		int[] healths = {300,200,500};
	    int[][] items = {{400, 500},{1000, 600},{300, 100}};
	    
	   int[]answer = solution(healths,items);
	    
	    for(int i=0;i<answer.length;i++) {
	    	System.out.print(answer[i]);
	    }
	}
	
	 public static int[] solution(int[] healths, int[][] items) {
	        
		 	Arrays.sort(healths);
		 	
	        ArrayList<Integer> itemList = new ArrayList<Integer>();
	        itemList.add(0);
	        
	        for(int i=1;i<items.length;i++) {
	        	for(int j=0;j<itemList.size();j++) {
	        		int temp = itemList.get(j);
	        		if(items[i][0] > items[temp][0]) {
	        			itemList.add(j, i);
	        			break;
	        		}
	        		
	        		if(j == itemList.size() -1) {
	        			itemList.add(i);
	        			break;
	        		}
	        		
	        	}
	        }
	        
	        ArrayList<Integer> useList = new ArrayList<Integer>();
	        
	        for(int i=0;i<healths.length;i++) {
	        	for(int j=0;j<itemList.size();j++) {
	        		int temp = itemList.get(j);
	        		if(healths[i] - items[temp][1] >= 100) {
	        			useList.add(temp+1);
	        			itemList.remove(j);
	        			break;
	        		}
	        	}
	        }

	        int[] answer = new int[useList.size()];
	        for(int i=0;i<useList.size();i++) {
	        	answer[i] = useList.get(i);
	        }
	        
	        Arrays.sort(answer);
	        return answer;
	  }
}
