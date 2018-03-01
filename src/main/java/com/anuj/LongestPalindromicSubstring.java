package com.anuj;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalSubstr("ADABADA"));
    }

    public static String longestPalSubstr(String str) {
        Palindrome[][] palindromes =
            new Palindrome[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            palindromes[i][i] = new Palindrome(true, 1);
        }

        String answer = str.substring(0, 1);
        int max = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == j) {
                    continue;
                }
                boolean palindrome = isPalindromic(str, i, j, palindromes);
                if (palindrome) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        answer = str.substring(i, j + 1);
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isPalindromic(String str, int i, int j, Palindrome[][] palindromes) {
        if (i > j) {
            return true;
        } else {
            if (palindromes[i][j] != null) {
                return palindromes[i][j].palindrome;
            }
            if (j - i == 1) {
                if (str.charAt(i) == str.charAt(j)) {
                    palindromes[i][j] = new Palindrome(true, 2);
                    return true;
                }
            }
            if (str.charAt(i) == str.charAt(j)) {
                boolean palindrome = isPalindromic(str, i + 1, j - 1, palindromes);
                if (palindrome) {
                    palindromes[i][j] = new Palindrome(true, j - i + 1);
                }
                return palindrome;
            }
            return false;
        }
    }

    private static class Palindrome {

        boolean palindrome;
        int length;

        public Palindrome() {
        }

        public Palindrome(boolean palindrome, int length) {
            this.palindrome = palindrome;
            this.length = length;
        }

        public boolean isPalindrome() {
            return palindrome;
        }

        public void setPalindrome(boolean palindrome) {
            this.palindrome = palindrome;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
