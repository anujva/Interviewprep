package com.anuj;

/**
 * Created by anuj on 5/6/17.
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("ABCDE", 4));
    }

    public static String convert(String s, int numRows) {
        //lets find the total number of rows and column
        //needed to capture the zigzag pattern
        if (numRows == 1 || numRows == s.length()) {
            return s;
        }
        int numOfCol = (numRows - 1) * (s.length() / (numRows + numRows - 2));
        int remainder = s.length() % (numRows + numRows - 2);
        if (remainder <= numRows) {
            numOfCol += 1;
        } else {
            numOfCol += 1;
            numOfCol += remainder - numRows;
        }

        Character[][] digits = new Character[numRows][numOfCol];

        int rowIndex = 0;
        int columnIndex = 0;
        int stringIndex = 0;

        while(stringIndex < s.length()){
            boolean stringexhausted = false;
            for(rowIndex = 0; rowIndex < numRows; rowIndex++){
                if(stringIndex < s.length()) {
                    digits[rowIndex][columnIndex] = s.charAt(stringIndex++);
                } else {
                    stringexhausted = true;
                }
            }
            if(stringexhausted){
                break;
            }
            rowIndex--;
            while(rowIndex > 1){
                rowIndex--;
                columnIndex++;
                if(stringIndex < s.length()) {
                    digits[rowIndex][columnIndex] = s.charAt(stringIndex++);
                } else {
                    stringexhausted = true;
                }
            }
            rowIndex--;
            columnIndex++;
        }

        //At this point the matrix is full
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numOfCol; j++) {
                if (digits[i][j] != null) {
                    buffer.append(digits[i][j]);
                }
            }
        }

        return buffer.toString();
    }
}
