package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJoon1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        int total = 0;

        for(int i=1; i<=1000; i++){
            for(int j=1; j<=i; j++){
                list.add(i);
            }
        }
        for(int k = A-1; k<B; k++){
            total += list.get(k);
        }
        System.out.println(total);
    }
}
