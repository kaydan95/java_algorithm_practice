package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;



// import com.example.view.MainFrame;

public class App 
{

    private static Scanner sc;

    public static void main( String[] args ) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //(와 )를 쪼개서 넣을 첫 문자열
        
        String s = br.readLine();

        //쪼갠 문자열들을 담았다가 꺼냇다가 할 스택
        Stack<Character> st = new Stack<Character>();

        //개수
        int N = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else{
                st.pop();
                if(s.charAt(i-1)== '('){
                    N += st.size();
                }
                else{
                    N += 1;
                }

            }
        }
        System.out.println(N);
    }
}