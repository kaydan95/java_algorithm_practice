package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class BJoon2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cur = 0;
        int[] arr = new int[10];

        for(int i=0; i<10; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            
            cur += -M + P;
            arr[i] = cur;
        }

        int Max = Arrays.stream(arr).max().getAsInt();
        System.out.println(Max);
    }
}
