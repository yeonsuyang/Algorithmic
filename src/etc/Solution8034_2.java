package etc;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution8034_2 {
	public static void main(String[] args) {
		
		int[] people = {2,3,4};
		int[] tshirts = {1,2,3};
		
		System.out.println(solution(people,tshirts));
	}
	
    public static int solution(int[] people, int[] tshirts) {
    	
    	Arrays.sort(people);
    	Arrays.sort(tshirts);
    	
    	ArrayList<Integer> ts = new ArrayList<Integer>();
    	
    	for(int i=0;i<tshirts.length;i++) {
    		ts.add(tshirts[i]);
    	}
    	int answer = 0;
    	
    	for(int i=0;i<people.length;i++) {
    		int n = ts.size();
    		for(int j =0;j<n;j++) {
    			if(people[i] <= ts.get(j)) {
    				answer++;
    				ts.remove(j);
    				break;
    			}
    		}
    	}
    	
        return answer;
    }
}
