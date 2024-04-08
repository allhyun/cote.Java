package 자료구조;


// 문제 분석
// N의 범위가 크다 N의 시간 복잡도 알고리즘도 사용한다
//두개의 포인터를 사용해서 값을 구한다.

import java.util.Scanner;

//15가 주어졌을때
// A라는 배열을 만들었다
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//
public class P2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int start_index =1;
        int end_index =1;
        int sum =1;

        while(end_index!= N){
            if(sum == N){
                count++;
                end_index++;
                sum = sum+ end_index;
            } else if(sum>N){
                sum = sum -start_index;
                start_index++;
            } else {
                //sum<N 알굥유
                end_index++;
                sum = sum+ end_index;
            }
        }
        System.out.println(count);
    }

}
