
package com.anuj;

import java.util.ArrayList;

public class GenerateValidParenthesis {
    public static void main(String[] args) {
        ArrayList<String> allCombs = combParenthesis(2);
        for (String str : allCombs) {
            System.out.print(str + "  ");
        }
        System.out.println();
    }

    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> allCombs = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        helperParenthesisGenerator(buffer, pairs, 0, 0, allCombs);
        return allCombs;
    }

    public static void helperParenthesisGenerator(StringBuffer buffer, int pairs, int openParens, int closeParens,
        ArrayList<String> allCombs) {
        if (closeParens == pairs) {
            allCombs.add(buffer.toString());
        }
        StringBuffer buffer1 = new StringBuffer(buffer);
        StringBuffer buffer2 = new StringBuffer(buffer);
        if (openParens > closeParens) {
            //close the parent
            buffer1.append(")");
            helperParenthesisGenerator(buffer1, pairs, openParens, closeParens + 1, allCombs);
        }
        if (openParens < pairs) {
            buffer2.append("(");
            helperParenthesisGenerator(buffer2, pairs, openParens + 1, closeParens, allCombs);
        }
    }
}
