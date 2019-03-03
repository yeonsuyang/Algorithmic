package study;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution42587_2 {
	
	public static void main(String[] args) {
		int[] priorities = {3, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(priorities,location));
		
	}
    public static int solution(int[] priorities, int location) {
    	int answer = 0;
    	
    	Queue<Point> q = new LinkedList<Point>();
    	
    	for(int i=0;i<priorities.length;i++) {
    		q.add(new Point(i,priorities[i])); //로케이션과 우선순위를 넣어줌
    	}
    	
        ArrayList<Integer> print = new ArrayList<Integer>();
        
        while(!q.isEmpty()) {
        	
        	Point p = q.poll();
        	int printFlag = 1;
        	
        	int size = q.size();
        	for(int i=0;i<size;i++) { //뒤에 더 큰게 없으면 리스트에 넣고. 아니면 큐에 넣고 다시넣
        		Point temp = q.poll();
        		if(temp.y > p.y) {
        			printFlag = 0;
        		}
        		q.add(temp); //플래그만 확인하고 다시 넣음 
        	}
        	
            if(printFlag == 1) { //사이즈 다 비교할 때까지 큰게 업었으면
            	print.add(p.x); //로케이션을 넣어줌 
            }else { //프린트할 거 아니면 다시 넣어줌 	
            	q.add(p);
            }
            	
        	
        }
        
        for(int i=0; i< print.size();i++) {
        	  System.out.print(print.get(i)  + " ,");
        	if(print.get(i) == location) {
        		answer = i+1;
        	}
        }
    	
    	
	    return answer;
    }
}
