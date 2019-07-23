package dfs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * 세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다. 
 * 첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다. 
 * 첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다. 
 * 이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오. 예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.

1 2 3 4 5 6 7
3 1 1 5 5 4 6


이 경우에는 첫째 줄에서 1, 3, 5를 뽑는 것이 답이다. 
첫째 줄의 1, 3, 5밑에는 각각 3, 1, 5가 있으며 두 집합은 일치한다. 
이때 집합의 크기는 3이다. 만약 첫째 줄에서 1과 3을 뽑으면, 이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다. 
그러나, 이 경우에 뽑힌 정수의 개수는 최대가 아니므로 답이 될수 없다.

첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다. 그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.
첫째 줄에 뽑힌 정수들의 개수를 출력하고, 그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.

7
3
1
1
5
5
4
6

3
1
3
5

10 
2 
4 
1 
7 
7 
4 
4 
8 
2 
1

 */
public class Main2668 {
	
	static int[] input;
	static int[] ans = {};
	static int N;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N];
		
		for(int i=0; i<N;i++) {
			input[i] = sc.nextInt();
		}

		for(int i=1; i<=N; i++) {
			Stack<Integer> inputStack = new Stack<Integer>();
			Stack<Integer> outputStack = new Stack<Integer>();
			calculate(i,inputStack,outputStack);
		}
		
		Arrays.sort(ans);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		
	}

	private static void calculate(int i,Stack<Integer> inputStack,Stack<Integer> outputStack) {
		// TODO Auto-generated method stub
		
		if(inputStack.search(i) != -1) {
			ans(inputStack,outputStack);
			return;
		}
		
		inputStack.push(i);

		if(outputStack.search(input[i-1]) == -1) {
			outputStack.push(input[i-1]);
		}		
		calculate(input[i-1],inputStack,outputStack);
	}

	private static void ans(Stack<Integer> inputStack,Stack<Integer> outputStack) {
		// TODO Auto-generated method stub
		int n = inputStack.size();
		int count = 0;

		for(int i=0;i<n;i++) {
			int temp = inputStack.get(i);
			if(outputStack.search(temp) == -1) {
				break;
			}
			count++;
		}
		
		if(count == n) {

			for(int i=0;i<ans.length;i++) {
				if(outputStack.search(ans[i]) != -1) {
					break;
				}
				if(i == ans.length-1) {
					for(int j=0;j<ans.length;j++) {
						outputStack.push(ans[j]);
						count++;
					}
				}
			}
			
			
			for(int i=0;i<N;i++) {
				if(i+1 == input[i]) {
					if(outputStack.search(i+1) == -1) {
					outputStack.push(i+1);
					count++;
					}
				}
			}
			
			if(ans.length < count) {
				ans = new int[count];
				for(int i=0;i<count;i++) {
					ans[i] = outputStack.pop();
				}
			}
		}
		
	}
	
	
	
	
	

	/* private static void calculateInput(int t,Stack<Integer> inputStack,int count) {
		
		if(count > N) {
			return;
		}
		
		calculateAns(inputStack);
		
		for(int i=t+1; i<=N;i++) {
				inputStack.push(i);
				//sysout(inputStack);
				calculateInput(i,inputStack,count+1);
				inputStack.pop();
				
			}
	}
	
	
//
//	private static void sysout(Stack<Integer> is) {
//		// TODO Auto-generated method stub
//		int n = is.size();
//		
//		for(int i=0;i<n;i++) {
//			System.out.print(is.get(i) + " ");
//		}
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ"+ n);
//	}

	private static void calculateAns(Stack<Integer> inputStack) {
		// TODO Auto-generated method stub
		Stack<Integer> ansStack = new Stack<Integer>();
		
		for(int i=0;i<input.length;i++) {
			
			if(inputStack.search(i+1) != -1) {
				if(inputStack.search(input[i]) != -1) {
					if(ansStack.search(input[i]) == -1) {
						ansStack.push(input[i]);
					}
				}
			}
		}
		if(ansStack.size() != inputStack.size()) {
			return;
		}
		if(ansStack.size() > ans.length) {
			ans = new int[ansStack.size()];
			for(int i=0;i<ans.length;i++) {
				ans[i] = ansStack.pop();
			}
		}
	} */
}
