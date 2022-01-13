package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(GCD(a, b));
		System.out.println(lcm(a, b));

    }
    static int lcm(int a, int b){ // 최소 공배수
		// 0이 아닌 두 수의 곱 / 두 수의 최대공약수
	    return a * b / GCD(a,b);
	}
	
	static int GCD(int a, int b){ // 최대 공약수
		if (a%b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}
