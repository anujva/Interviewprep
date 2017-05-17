package com.anuj;

import java.util.LinkedList;

/**
 * Created by anuj on 5/6/17.
 */
public class ReverseInteger {
    public static void main(String [] args) {
        System.out.println(isValid("([)]"));
    }

    public static int reverse(int n){
        int index = 0;
        int reversedNum = 0;
        while(n != 0){
            int digit = n %10;
            n = n/10;
            if(reversedNum > 0 && ((long)reversedNum)*10 + digit > Integer.MAX_VALUE){
                return 0;
            }
            if(reversedNum < 0 && ((long)reversedNum)*10 + digit < Integer.MIN_VALUE) {
                return 0;
            }
            reversedNum = reversedNum * 10 + digit;
        }
        //we have to keep the sign as well.
        return reversedNum;
    }

    public static boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();

        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                linkedList.addFirst(s.charAt(i));
            }

            if(c == ')'){
                if(linkedList.isEmpty()){
                    return false;
                }
                Character t = linkedList.pop();
                if(t != '('){
                    return false;
                }
            }

            if(c == ']'){
                if(linkedList.isEmpty()){
                    return false;
                }
                Character t = linkedList.pop();
                if(t != '['){
                    return false;
                }
            }

            if(c == '}'){
                if(linkedList.isEmpty()){
                    return false;
                }
                Character t = linkedList.pop();
                if(t != '{'){
                    return false;
                }
            }
        }

        if(linkedList.isEmpty()){
            return true;
        }

        return false;
    }

}
