package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_자료구조7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //일렬로 숫자를 많이받아야해서 스캐너보다 빠른 버퍼드리더 사용

        for(int i = 0; i <N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); //오름차순 정렬
        int count = 0; //정답값
        int i = 0; //투포인트 Min 값 지정
        int j = N-1; //투포인트 MAX 인덱스 지정
        while(i<j){
            if( A[i]+A[j] < M) {
                i++;
            }
            else if(A[i]+A[j]>M) {
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }


        }
        System.out.println(count);

    }
}
