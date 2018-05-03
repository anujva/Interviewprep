package com.anuj;

public class CheckBalancedParentheses {

  public static void main(String[] args) {
    System.out.println(isBalanced("()()())"));
  }

  public static boolean isBalanced(String input) {
    if (input == null) {
      return true;
    }
    if (input.length() == 0) {
      return true;
    }
    if (input.length() == 1) {
      return false;
    }
    if (input.length() == 2) {
      if ((input.charAt(0) == '(' && input.charAt(1) == ')')
          || (input.charAt(0) == '[' && input.charAt(1) == ']')
          || (input.charAt(0) == '{' && input.charAt(1) == '}')) {
        return true;
      }
      return false;
    }

    char firstCharacter = input.charAt(0);
    char searchFor = getSecondChar(firstCharacter);

    for (int i = 1; i < input.length(); i++) {
      boolean balanced = false;
      if (searchFor == input.charAt(i)) {
        //is there anything in between
        if (i - 0 == 1) {
          balanced = isBalanced(input.substring(i + 1));
        } else {
          balanced = (isBalanced(input.substring(1, i)) &&
              isBalanced(input.substring(i + 1)));
        }
      }
      if (balanced) {
        return true;
      }
    }
    return false;
  }

  private static char getSecondChar(char firstCharacter) {
    if (firstCharacter == '(') {
      return ')';
    }
    if (firstCharacter == '[') {
      return ']';
    }
    if (firstCharacter == '{') {
      return '}';
    }
    return ' ';
  }
}


