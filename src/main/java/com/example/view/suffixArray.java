package com.example.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class suffixArray {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받을 문자열 S
        String S = br.readLine();
        //문자열 S의 길이만큼 들어 갈 문자 배열 SA
        String[] SA = new String[S.length()];

        //반복문을 돌려 처음부터 뽑아준다.
        for(int i=0; i<S.length(); i++){
            SA[i] = S.substring(i, S.length());
        }

        //문자 배열 SA를 알파벳 순으로 정렬
        Arrays.sort(SA);

        //결과물을 담아줄 sb
        StringBuilder sb = new StringBuilder();

        //SA안에 있는 sa를 하나씩 append
        for(String sa : SA){
            sb.append(sa).append("\n");
        }
        System.out.println(sb);
    }    
}


