package study;

/*
 * 
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

 genres : 노래의 장르를 나타내는 문자열 배열 
 plays : 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution42579 {
   public static void main(String[] args){
      
      String[] genres = {"classic", "pop","classic", "classic", "pop","danse"};
      int[] plays = {500, 600,150, 800, 2500,500};
         
      int[] answer = solution(genres,plays);
      
      for(int i=0;i<answer.length;i++){
         System.out.print(answer[i]);
         if(i<answer.length-1){
            System.out.print(",");
         }
      }
   }
   
    public static int[] solution(String[] genres, int[] plays) {
       

        HashMap<String, Integer> playCount = new HashMap<String, Integer>();
        
        for(int i=0;i<genres.length;i++){ //재생 횟 수 계산
           if(!playCount.containsKey(genres[i])){//없으면
              playCount.put(genres[i], plays[i]);
           }else{//이미 있으면 더해주기. 
              int count = playCount.get(genres[i]);
              count += plays[i];
              playCount.remove(genres[i]);
              playCount.put(genres[i], count);
           }
        }
        
        TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(new ValueComparator(playCount)); //재생횟수로 정렬
        sortedMap.putAll(playCount);
       
        String[] genreArray = sortedMap.keySet().toArray(new String[0]); //장르 배열
        ArrayList<Integer> BestList = new ArrayList<Integer>();
        
       for(int i=0;i<genreArray.length;i++) { //장르 순으로 
     	  ArrayList<Integer> tempList = new ArrayList<Integer>();
     	  for(int j=0;j<plays.length;j++) {
     		 if(genres[j] == genreArray[i]) { //장르가 같다면 
     			 int tempSize = tempList.size(); //아직 하나도 없다면 0이겠고 있다면 1이상 
     			 if(tempSize == 0) {
     				 tempList.add(j); //tempList 에 인덱스 추가.	 
     			 }else {
     				 for(int z=0; z<tempSize;z++)//크기 비교해서 넣기.
     					 
     					if(plays[tempList.get(z)] < plays[j]) {
     						tempList.add(z,j); //tempList 에 인덱스 추가.
     						break;
     					}else {
     						if(z == tempSize-1) {
     							tempList.add(j); //tempList 에 인덱스 추가.
     						}
     					}
     			 }
     		 }
     	  }//한 장르가 끝나면 
     	  for(int k=0;k<2;k++) {//2개만 빼서 넣기.
     		 if(tempList.size() > k) {
     			 BestList.add(tempList.get(k));
     		 }
     	  }
       }
  
        
        int[] answer = new int[BestList.size()];
        for(int i=0;i<answer.length;i++) {
     	   answer[i] = BestList.get(i);
        }

         return answer;
     }
     
     static class ValueComparator implements Comparator<String> {

         Map<String, Integer> base;
         public ValueComparator(Map<String, Integer> base) {
             this.base = base;
         }

         public int compare(String ipA, String ipB) {
             if (base.get(ipA) >= base.get(ipB)) {
                 return -1;
             } else {
                 return 1;
             }
         }
     }
}