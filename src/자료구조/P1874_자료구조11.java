package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class P1874_자료구조11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N]; //갯수만큼 A배열을 만들기
        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt(); //A i번째 숫자를 받아본다
        }
        Stack<Integer> stack = new Stack<>(); //스택자료구조
        StringBuffer bf = new StringBuffer();
        int num = 1; //오름차순 수
       boolean result = true;
        for (int i =0; i<A.length; i++){
            int su = A[i]; //배열에 있는 값 가져오기
            if(su >= num){//배열에 있는 갑ㅅ이 현재 오름차순의 지연수보다 큰 수
                while(su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");

            }
            else{
                int n =stack.pop();
                if( n >su){
                    System.out.println("NO");
                    result=false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
