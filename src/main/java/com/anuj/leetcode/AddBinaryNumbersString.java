package com.anuj.leetcode;

public class AddBinaryNumbersString {
    public static void main(String[] args) {
        System.out.println(addBinaryString("1111", "1"));
    }

    public static String addBinaryString(String binary1, String binary2) {
        StringBuffer binary1Buffer = new StringBuffer(binary1);
        StringBuffer binary2Buffer = new StringBuffer(binary2);

        //BinaryBuffer.reverse will reverse the buffer as well.
        binary1Buffer.reverse();
        binary2Buffer.reverse();

        int carryOver = 0;
        StringBuffer answer = new StringBuffer();
        int lastIndexAdded = 0;
        for (int i = 0; i < binary1Buffer.length() && i < binary2Buffer.length(); i++) {
            //the number additions can either be 0, 1, 10 or 11.
            //so the possible integers are 0, 1, 2, 3
            int sum = carryOver + (binary1Buffer.charAt(i) - '0') + (binary2Buffer.charAt(i) - '0');
            carryOver = sum / 2;
            sum = sum % 2;
            answer.append(sum);
            lastIndexAdded = i;
        }
        lastIndexAdded++;
        //Once the loop is done if we return.. we should be able to get the right answer for all equal
        //length strings.
        StringBuffer rest = binary1Buffer.length() > binary2Buffer.length() ? binary1Buffer : binary2Buffer;
        //whatever is the rest will need to go over the rest
        while (lastIndexAdded < rest.length()) {
            int sum = carryOver + (rest.charAt(lastIndexAdded) - '0');
            carryOver = sum / 2;
            sum = sum % 2;
            answer.append(sum);
            lastIndexAdded++;
        }
        if (carryOver != 0)
            answer.append(carryOver);
        return answer.reverse().toString();
    }
}
