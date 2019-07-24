package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //나무의 수
        int M = Integer.parseInt(st.nextToken()); //나무의 길이

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int lo = 0;
        int hi = input[input.length-1];
        int answer = 0;

        while(lo <= hi) {
            int mid = (lo+hi)/2;

            long cal = calculate(mid,input,M);

            if(cal >= M) { //계산된 나무가 가져갈 것 보다 많으면
                answer = mid;
                lo = mid+1;
            }else { //계산 된 나무가 가져갈 것보다 적으면
                hi = mid-1;
            }
        }

        System.out.println(answer);
    }

    private static long calculate(int mid, int[] input,int M) {

        long cal = 0;

        for(int i=input.length-1;i>=0;i--) {
            if(input[i] < mid) { // 작은거 부턴 그냥 계산 안하고 넘기기
                break;
            }else {
                cal += (input[i]-mid); // 나무길이 - 자르는 위치를 빼고 더함
                if(cal > M) { //가져 갈 것보다 많으면 끝
                    break;
                }
            }
        }
        return cal;
    }
}
