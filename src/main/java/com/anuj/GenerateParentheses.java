package com.anuj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 5/8/17.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        generateParentheses(3);
    }

    public static List<String> generateParentheses(int n) {
        /**
         * We have to generate all valid parentheses for the
         * size of n.
         * For example, given n = 3, a solution set is:

         [
         "((()))",
         "(()())",
         "(())()",
         "()(())",
         "()()()"
         ]
         */

        //Generation of the parenthesis might be a little trickier than I
        // thought initially.
        StringBuffer stringBuffer = new StringBuffer();
        int openParen = n;
        int closeParen = n;
        List<String> allPermutations = new ArrayList<>();
        generateParenthesesSubroutine(stringBuffer, openParen, closeParen, allPermutations);
        return allPermutations;
    }

    public static void generateParenthesesSubroutine(StringBuffer stringBuffer, int
            openParen, int closeParen, List<String> allPermutations) {
        //Now that we have this.. what do you do from here..
        if (openParen == 0 && closeParen == 0) {
            allPermutations.add(stringBuffer.toString());
            return;
        }

        if (openParen > -1) {
            generateParenthesesSubroutine(new StringBuffer(stringBuffer)
                    .append('('), openParen - 1, closeParen, allPermutations);
            if (openParen < closeParen) {
                generateParenthesesSubroutine(new StringBuffer(stringBuffer).append
                        (')'), openParen, closeParen - 1, allPermutations);
            }
        }
    }
}
