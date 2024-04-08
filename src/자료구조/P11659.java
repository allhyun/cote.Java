package 자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());
        //긴 suNo 를 한줄로 받아올 수 있게 StringTokenizer 사용
        //예제의 첫번쨰를 받아온다.
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo +1];
         //배열은  0번째 데이터부터 읽으니까 그걸 무시하고자 +1 해줌
        stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());
        for(int i =1; i<=suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int q =0; q<quizNo; q++){
            stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j]-S[i-1]);
        }



    }
}
