package com.example.view.BJoon;

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

        //소수인지 아닌지 판별해줄 boolean 배열. 초기값이 false!!
        boolean[] tof = new boolean[E + 1];
        tof[0] = tof[1] = true;

        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i*i < tof.length; i++) {
            if(tof[i]) continue;
            for(int j = i*i; j < tof.length; j += i) {
                tof[j] = true;
            }
        }

        for(int i = F; i<=E; i++) {
            if(!tof[i]) {
                sb.append(i).append("\n");
            }
        }
		System.out.println(sb);
    }    
}

