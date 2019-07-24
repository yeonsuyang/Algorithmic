package etc;

import java.util.ArrayList;
import java.util.Scanner;

/*
어떤 수를 서로 다른 소수 3개의 합으로 표현하는 경우의 수를 구하려 합니다.
 예를 들어 33은 총 4가지 방법으로 표현할 수 있습니다.

3+7+23
3+11+19
3+13+17
5+11+17
자연수 n이 매개변수로 주어질 때, 
n을 서로 다른 소수 3개의 합으로 표현하는 경우의 수를 return 하는 solution 함수를 작성해주세요.
 */

public class Solution8034 {

	static ArrayList<Integer> decimal;
	static int answerCount = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println(solution(num));

		// 그 소수들로 덧셈 이루어지는 방법

	}

	public static int solution(int n) {
		int answer = 0;
		getDecimal(n); // n 이하의 소수들을 구하기.
		
	
		for(int i=0;i<decimal.size();i++) {
			int sum = 0;
			
			sum += decimal.get(i); //첫 숫자를 더하고 
	
			if(sum >= n) {
				break; //처음에서 숫자가 n보다 크거나 같으면 다음으로 넘어가
			}else {
				getPlusCount(2,n,sum,i+1);
			}
		}

		answer = answerCount;
		return answer;
	}

	private static void getPlusCount(int count,int n,int sum,int start) {
		
		if(count > 3) {
			return;
		}
		
		for(int j=start;j<decimal.size();j++) {
			int tsum = sum;
			tsum += decimal.get(j);	
			if(tsum > n) {
				return;
			}else if(tsum == n) {
				if(count == 3) {
					answerCount ++;
					System.out.println(decimal.get(j));
				}
			}else {
				getPlusCount(count+1,n,tsum,j+1);
			}
		}
	}

	
	private static ArrayList<Integer> getDecimal(int n) {

		decimal = new ArrayList<Integer>();

		decimal.add(2); // 2는 우선 소수

		for (int i = 2; i < n; i++) {
			for (int j = 0; decimal.size() > j; j++) {
				if (i % decimal.get(j) == 0) {
					break; // 소수로 나뉘면
				}

				if (j == decimal.size() - 1)
					decimal.add(i);// 나뉜게 없으면
			}
		}
		// TODO Auto-generated method stub
		return decimal;
	}

}
