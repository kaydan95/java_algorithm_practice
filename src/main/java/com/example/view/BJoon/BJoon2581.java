package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJoon2581 {

    public static boolean tof[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        tof = new boolean[N+1];
        tof();

        int total = 0;

        int min = Integer.MAX_VALUE;

        for(int i=M; i<=N; i++){
            if(!tof[i]) {
                total += i;
                if(min == Integer.MAX_VALUE){
                    min = i;
                }
            }
        }

        if(total == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(total);
            System.out.println(min);
        }
    }

    public static void tof(){
        tof[0] = tof[1] = true;

        for(int i=2; i<=Math.sqrt(tof.length); i++){
            if(tof[i]) continue;
            for(int j=i*i; j < tof.length; j += i){
                tof[j] = true;
            }
        }
    }
}
