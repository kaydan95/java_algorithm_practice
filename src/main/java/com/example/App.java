package com.example;
import java.io.*;
import java.util.*;
class App {
    // 소수를 판별하기 위한 메서드
    public static boolean PrimeNumber(int number) {
        // number가 1인경우 소수가 아니기 때문에 false
        if (number < 2) {
            return false;
        }
        // 2부터 i의 제곱이 넘어온 number변수보다 작을 경우 반복문을 수행
        for (int i = 2; i * i <= number; i++) {
            // 나머지가 0일 경우 소수가 아니므로 false
            if (number % i == 0) {
                return false;
            }
        }
        // 그 외의 경우 number는 소수이기 때문에 true 
        return true;
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("=");
        for (int i = 2; i <= num; i++) {
            if (PrimeNumber(i) == false) {
                continue;
            }
            else{
                int b = num - i;
                if(PrimeNumber(b)== false){
                    continue;
                }
                else{
                    sb.append(i).append("+");
                    sb.append(b);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

















