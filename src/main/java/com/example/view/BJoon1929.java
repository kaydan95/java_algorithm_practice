package com.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJoon1929 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받을 문자열 S
        String S = br.readLine();
        // System.out.println(S);

        String[] SS = S.split(" ");

        int F = Integer.parseInt(SS[0]);
        int E = Integer.parseInt(SS[1]);

        //E+1 만큼 설정해주고 그안에서 t,f판별
        boolean[] b = new boolean[E+1];
        
        //boolean  의 기본값은 false, true 라는 건 소수가 아닌 정수라는 뜻
        b[0] = b[1] = true;

        for(int i=2; i<E; i++){
            if(b[i]==true){
                continue;
            }
            for(int j=i+i; j<=E; j=j+i){
                b[j] = true;
            }
        }
        for(int i=F; i<=E; i++){
            if(b[i] == false){
                System.out.println(i + " ");
            }
        }
    }    
}

