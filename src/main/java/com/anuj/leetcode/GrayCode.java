package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    public static List<Integer> grayCode(int n) {
        //find the number of bits required to represent n.
        //what is the algo to generate the next gray code,
        //given a current gray code.
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append("0");
        }
        Set<String> generatedCodes = new LinkedHashSet<>();
        generatedCodes.add(buffer.toString());
        generateGrayCode(buffer, generatedCodes);
        List<Integer> answer = new ArrayList<>();
        for (String x : generatedCodes) {
            answer.add(Integer.parseInt(x, 2));
        }
        return answer;
    }

    private static void generateGrayCode(StringBuffer buffer, Set<String> generatedCodes) {
        //start from the left, change the value and check if its part of the generated Code.
        boolean generated = false;
        for (int i = buffer.length() - 1; i > -1 && !generated; i--) {
            if (buffer.charAt(i) == '0') {
                buffer.setCharAt(i, '1');
                //check if the value is there in the generated Codes.
                if (!generatedCodes.contains(buffer.toString())) {
                    //this is a value that can be generated.
                    generated = true;
                    generatedCodes.add(buffer.toString());
                    generateGrayCode(buffer, generatedCodes);
                } else {
                    buffer.setCharAt(i, '0');
                }
            } else {
                buffer.setCharAt(i, '0');
                if (!generatedCodes.contains(buffer.toString())) {
                    generated = true;
                    generatedCodes.add(buffer.toString());
                    generateGrayCode(buffer, generatedCodes);
                } else {
                    buffer.setCharAt(i, '1');
                }
            }
        }
    }
}
