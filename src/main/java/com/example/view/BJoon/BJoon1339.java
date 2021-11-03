package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJoon1339{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째줄에 입력받은 단어수 N개
        int N = Integer.parseInt(br.readLine());

        // 단어들을 담을 String 배열
        String[] words = new String[N];

        //둘째줄부터 N개만큼 입력받을 단어들 배열에 넣기
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        // 단어를 구성하고 있는 알파벳 배열들 -> 숫자값을 부여하기때문에 int[]
        int[] alphb = new int[26];

        // 입력받은 단어에 자리값 부여
        for(int i=0; i<N; i++){
            String S = words[i];
            for(int j=0; j<S.length(); j++){
                alphb[(S.charAt(j) - 65)] += (int) Math.pow(10, (S.length()-j-1));
                //alphb[G - 65] = alphb[6] -> alphb 에서 G 에 해당하는 인덱스값
                //alphb[] 에서 인덱스 6에 있는 G는 10의 제곱을 부여
            }
        }

        // 큰 순서대로 정렬 -> 내림차순이 기본!!!
        Arrays.sort(alphb);

        // 부여해준 큰 자릿수 * 큰 숫자 = 가장 큰 값
        int f = 9;

        // 결과는 0으로 초기화
        int result = 0;

        // sort 로 정렬된 alphb는 내림차순으로 큰 숫자가 뒤에 가있음
        // 즉, 뒤에서부터 큰 숫자를 - 해주면서 넣어줘야한다.
        for(int i=alphb.length-1; i>=0; i--){
            if(f == 0) break;
            result += alphb[i] * f--;
        }

        System.out.println(result);
    }
}