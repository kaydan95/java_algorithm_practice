package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJoon2504 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int cur = 1;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                cur *= 2;
            }
            else if(s.charAt(i) == '['){
                stack.push(s.charAt(i));
                cur *= 3;
            }
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() != '(' || stack.peek() == ']'){
                    sum = 0;
                    break;
                }
                else if(s.charAt(i-1) == '(') {
                    sum += cur;
                }
                cur /= 2;
                stack.pop(); 
            }
            else if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '[' || stack.peek() == ')'){
                    sum = 0;
                    break;
                }
                else if(s.charAt(i-1) == '[') {
                    sum += cur;
                }
                cur /= 3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }
        else System.out.println(sum);
    }
}
