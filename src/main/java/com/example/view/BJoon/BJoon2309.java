package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class BJoon2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int total = 0;

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(total - arr[i] - arr[j] == 100){
                    for(int k=0; k<9; k++){
                        if(i == k || j == k){
                            continue;
                        }
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }

        }
    }
}
