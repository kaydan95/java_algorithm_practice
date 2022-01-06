package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;



public class BJoon3406 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            String BN = Integer.toBinaryString(N);

            List<Integer> list = new ArrayList<>();

            for(int j=0; j<BN.length(); j++){
                list.add(Integer.parseInt(BN.substring(j, j+1)));
            }

            Collections.reverse(list);

            for(int j=0; j<list.size(); j++){
                if(list.get(j) == 1){
                    bw.write(j + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
