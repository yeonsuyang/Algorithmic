package etc;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Solution17678{
	
	// n회	t분간격 m명이 탈 수 있음
	public static void main(String[] args) throws ParseException {
		
	 Scanner sc = new Scanner(System.in);
	 
	 int n = sc.nextInt();
	 int t = sc.nextInt();
	 int m = sc.nextInt();
	 
	 String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
	 
	 String ans = solution(n,t,m,timetable);
	 
	 System.out.println(ans);
		
		
	}
	
	 public static String solution(int n, int t, int m, String[] timetable) throws ParseException {
		
	      String answer = "";
	      String nowtime = "09:00";
	      
	      int count = 0;
	      int temp = 0;
	      
	      Arrays.sort(timetable);
	      
	      SimpleDateFormat sdformat = new SimpleDateFormat("HH:mm"); 
	      
	      Date nowdate = sdformat.parse(nowtime); //현재시간을 우선 데이트 형식으루 만들어주기. 
	      Calendar nowcal = Calendar.getInstance();
	      nowcal.setTime(nowdate);
	      
	      Calendar concal = Calendar.getInstance();
	  
	      for(int i=0;i<n;i++) {//셔틀버스 회차 만큼
	    
		      count = 0;
	    	 for(int j=temp;j<timetable.length;j++) {
	    		 
	    	  Date tdate = sdformat.parse(timetable[j]); //현재시간을 우선 데이트 형식으루 만들어주기. 
   		      Calendar tcal = Calendar.getInstance();
   		      tcal.setTime(tdate);
   		      
   		      if(nowcal.compareTo(tcal) >= 0) {//셔틀버스 시간이 같거나 더 크다면 
	    		 if(m > count) { //탈 수 있는 인원이 남아있다면
	    				 count++; //탑승
	    				 temp++; //타임테이블도.
	    			     concal = tcal;
	    		 }else {
	    			 break;
	    		 }
   		      }else {//셔틀버스시간보다 크다면 pass
   		    	  continue;
   		      }
	    	 }
	    	 
	    	 if(i == n-1) { //마지막회차라면 
	    		 //탈 수 있는 인원이 아직 남았다면 	
	    		if(count < m) {
	    			//셔틀버스 시간이 그냥 오면되는 시간
	    		    concal = nowcal;
	    		}else {//없다면 
	    		  concal.add(Calendar.MINUTE, -1 ); //1분더빨리와서 타버리기 
	    		}
	    	 }else {
	    		   nowcal.add(Calendar.MINUTE, t); //회차 더 해주기
	    	 }
	      }
	      
	     answer = sdformat.format(concal.getTime());
	      
	      return answer;
	  }
}
