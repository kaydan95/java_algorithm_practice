package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJoon2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        int[] arr2 = new int[T];

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            
            arr2[i] = arr[7];
        }

        for(int i=0; i<T; i++){
            System.out.println(arr2[i]);
        }
    }
}
