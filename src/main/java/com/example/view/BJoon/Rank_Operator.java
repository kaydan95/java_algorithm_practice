package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Rank_Operator {
    // 연산자들 사이에서 우선순위 -> 값이 클수록 순위가 높은 우선 연산자
    public static int Rank(char operator) {
        if (operator == '(') {
            return 1;
        } else if (operator == '-' || operator == '+') {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        Stack<Character> operator_st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N.length(); i++) {
            // 1. A-Z 라는 문자일 경우
            if (N.charAt(i) >= 'A' && N.charAt(i) <= 'Z') {
                sb.append(N.charAt(i));
            }
            // 2. ( 일경우
            else if (N.charAt(i) == '(') {
                operator_st.push(N.charAt(i));
            }
            // 3. ) 일 경우
            else if (N.charAt(i) == ')') {
                // 일단 괄호 안 연산이 다 끝났다는 의미니까 빌 때까지 pop() 을 해줘야하는데 그 전에
                while (!operator_st.isEmpty()) {
                    if (operator_st.peek() == '(') {
                        operator_st.pop();
                        break;
                    } else {
                        sb.append(operator_st.pop());
                    }
                }
            }
            // 4. 괄호없이 연산자만 나올 경우
            else {
                // 4-1) stack이 비어있지 않고 stack 가장 위에 쌓여잇는 연산자가 i 번째 연산자 보다 우선순위일 경우
                // (Rank 값이 작을 경우) stack에 있는 걸 꺼내서 결과문에다가 넣어줌.
                while (!operator_st.isEmpty() && Rank(N.charAt(i)) <= Rank(operator_st.peek())) {
                    sb.append(operator_st.pop());
                }
                // 4-2) 아니면 stack 에다가 넣어줌
                operator_st.push(N.charAt(i));
            }
        }

        // 4-2 과정까지 다 반복하고 나면 우선순위에 밀린 연산자만 남아있을 테니까 이걸 다 꺼내주면 된다.
        while (!operator_st.isEmpty()) {
            sb.append(operator_st.pop());
        }
        System.out.println(sb);
    }
}
