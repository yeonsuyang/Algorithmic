package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수

입력 : 문자의 개수를 나타내는 정수 k
그 다음 줄에는 k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시된다. k의 범위는 2 ≤ k ≤ 9 이다.

출력 : 제시된 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째 줄과 둘째 줄에 각각 출력해야 한다.

 */
public class Main2529 {

        static String[] bu;
        static int k;
        static ArrayList<Integer> big = new ArrayList<>();
        static ArrayList<Integer> small = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        bu = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            bu[i] = st.nextToken();
        }

        //큰 수
       calculateBig(0);
        for(int i=0;i<big.size();i++){
            System.out.print(big.get(i));
        }
       System.out.println();
        //작은 수
        calculateSmall(0);
        for(int i=0;i<small.size();i++){
            System.out.print(small.get(i));
        }
    }


    public static void calculateBig(int count){

        for(int i = 9; i>=0; i--){

            if(big.contains(i)){
                continue;
            }

            if(count == 0){
                big.add(i); // 9
            }else{
                if(bu[count-1].equals("<")){  //부등호가 더 크면
                    if(big.get(big.size()-1) < i){
                        big.add(i);
                    }else{
                        break;
                    }
                }else{ //부등호가 더 작으면
                    if(big.get(big.size()-1) > i){
                        big.add(i);
                    }else{
                        break;
                      }
                }
            }

            if(big.size() < k+1 && big.size() > count){
                calculateBig(count + 1);
            }

            if(big.size() == k+1){
                break;
            }

            if(big.size() == count + 1){
                big.remove(big.size() -1);
            }
        }
    }

    public static void calculateSmall(int count){
        for(int i = 0; i<=9; i++){

            if(small.contains(i)){
                continue;
            }

            if(count == 0){
                small.add(i); // 0
            }else{
                if(bu[count-1].equals("<")){  //부등호가 더 크면
                    if(small.get(small.size()-1) < i){
                        small.add(i);
                    }else{
                        break;
                    }
                }else{ //부등호가 더 작으면
                    if(small.get(small.size()-1) > i){
                        small.add(i);
                    }else{
                        break;
                    }
                }
            }

            if(small.size() < k+1 && small.size() > count){
                calculateSmall(count + 1);
            }

            if(small.size() == k+1){
                break;
            }

            if(small.size() == count + 1){
                small.remove(small.size() -1);
            }
        }
    }
}
