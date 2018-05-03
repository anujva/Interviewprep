package com.anuj;

import java.util.ArrayList;

public class GenerateParenthesis {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static void generateParenthesis(int n) {
        ArrayList<String> answers = new ArrayList<>();
        generateParenthesisSubroutine("", 0, 0, n, answers);
        System.out.println(answers);
    }

    public static void generateParenthesisSubroutine(String s, int no, int nc, int n, ArrayList<String> answers) {
        if (no == nc && no == n) {
            answers.add(s);
        }
        if (no < n) {
            generateParenthesisSubroutine(s.concat("{"), no + 1, nc, n, answers);
        }
        if (nc < no) {
            generateParenthesisSubroutine(s.concat("}"), no, nc + 1, n, answers);
        }
    }
}
