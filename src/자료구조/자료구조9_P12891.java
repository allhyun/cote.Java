package 자료구조;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;


public class 자료구조9_P12891 {
    //전역변수 설정해서 다른곳에서서도 사용할 수 있도록
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stringTokenizer.nextToken()); //문자열 크기
        int P = Integer.parseInt(stringTokenizer.nextToken()); // 부분문자열의 크기
        int Result =0 ;
        checkArr = new int [4]; //비밀번호 체크 배열
        myArr = new int [4];
        //현재 전체 문자 배열 [S] 만큼 받아야한다
        char A[] = new char [S];
        checkSecret = 0;

        //데이터 받아야함
        A = br.readLine().toCharArray();
        stringTokenizer = new StringTokenizer(br.readLine());
        //배열 4개가 들어와있음

        //부분문자열에 포함되어야할 A,C,G,T의 최소 개수 데이터 받기
        for( int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            //4개의 숫자를 차례대로 가져오게함

            if(checkArr[i] == 0 ){
                //C라는 애는 0이여도 상관없다!인 상태...!
                //C는 들어오나 안들어오나 0이여도 상관없는 조건이니까
                //변수를 하나 올려줘야함
                //4개 만족해야하는데 0이라는 거는 이미 만족했다는 뜻이 되는거니까
                checkSecret++;
            }
        }

        for(int i =0; i<P ; i++){ //부분문자열 처음 받을때 셋팅
            //함수를 만들어주는게 좋을거같아서 함수 작성
            // 전체 배열의 첫번쨰 값을 현재상태 배열에 넣어주겠다는 의미이다 왜 P까지 넣어주나/?
            //부분문자열이 P까지의 범위이기때문에 넣어준다
            Add(A[i]);
        }
        if(checkSecret == 4) Result++;

        //슬라이딩 윈도우
        //한칸 오른쪽으로 이동한 상태부터 시작하는  코드
        for(int i = P ; i<S; i++){
            int j = i-P;
            //i = 부분문자열에서 맨 오른쪽숫자
            //j = 부분문자열에서 맨 왼쪽 숫자
            //부분문자열에서 빠져나가는 글자와 들어오는 글자만 신경써준다
            // 맨 오른쪽 들어와야하니까 i 넣어주는 함수
            Add(A[i]);
            Remove(A[j]);
            //한번 이동할때마다 맞는지 체크해줘야함
            if(checkSecret ==4)Result++;

        }
        System.out.println(Result);
        br.close();


    }

    //별도 함수
    // 슬라이딩윈도우가 이동할때 구간에 들어오는 배열 구하는 함수
    private static void Add(char c){
        switch (c){
            case'A':
                myArr[0]++;
                //현재 내 부분문자열 상태가 checkArr 값이 똑같냐? 같으면 늘려줘
                if(myArr[0] == checkArr[0]) checkSecret++;
                //>= 안되는 이유 : 이미 만족했는데 크다고 늘려주면 안된다..
                break;
            case'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;

        }
    }

    //슬라이딩윈도우가 움질일때 빠져야하는 배열에 관한 함수
    public static void Remove(char c){
        switch (c){
            case'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[2]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;

        }
    }
}
