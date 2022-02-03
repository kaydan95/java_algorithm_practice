package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJoon14719 {
    public static void main(String[] args) throws IOException {
        // 첫번째 입력줄 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int block[] = new int[W];

        // 두번째 입력줄 읽기
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st2.nextToken());
        }

        // 비교하기
        int current = 0;
        int left = 0;
        int right = 0;

        for (int i = 1; i < W - 1; i++) {
            left = right = 0;

            // 왼쪽에서 제일 높게 쌓인거 찾기
            for (int j = 0; j < i; j++) {
                left = Math.max(left, block[j]);
            }

            // 오른쪽에서 제일 높게 쌓인거 찾기
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, block[j]);
            }

            if (block[i] < left && block[i] < right) {
                current += Math.min(right, left) - block[i];
            }
        }

        System.out.println(current);
    }
}
