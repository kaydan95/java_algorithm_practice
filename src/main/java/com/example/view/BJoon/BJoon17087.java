package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class BJoon17087 {

    // 최대공약수를 구하는 유클리드 호제법 공식!
    static int gcd(int a, int b){ // 최대공약수
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String F = br.readLine();
        String[] FF = F.split(" ");

        //첫번째 줄에서 주어진 동생의 수 N
        int N = Integer.parseInt(FF[0]);

        //첫번째 줄에서 주어진 수빈의 위치 S
        int S = Integer.parseInt(FF[1]);

        //동생들의 위치 배열
        int [] NL = new int[N];

        String F2 = br.readLine();

        String[] FF2 = F2.split(" ");

        for(int i=0; i<N; i++){
            NL[i] = Integer.parseInt(FF2[i]);
        }
        int gcd = Math.abs(NL[0] - S);

        if(S>1){
            for(int i=1; i<N; i++){
                gcd = gcd(gcd, Math.abs(NL[i]-S));
            }
        }
        System.out.println(gcd);
    }
}