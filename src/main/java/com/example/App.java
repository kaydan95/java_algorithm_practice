package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] A = new int[26];

        for(int i=0; i<S.length(); i++){
            A[S.charAt(i)-97] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : A){
            sb.append(i + " ");
        }

        System.out.println(sb);

    }    
}

