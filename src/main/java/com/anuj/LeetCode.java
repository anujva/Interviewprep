
package com.anuj;

import java.util.HashSet;

public class LeetCode {
  public static void main(String[] args) {
    String s =
        "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
    System.out.println(longestPalindromeString(s));
  }

  public static String longestPalindrome(String s) {
    if (s.length() == 1 || s.length() == 0) {
      return s;
    }
    String[][] dp = new String[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = s.substring(i, i + 1);
    }

    //Keep track of the maximum here itself in this loop.
    //Initialization complete.
    int maxLength = -1;
    int maxIIndex = -1;
    int maxJIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {
        if (s.charAt(j) == s.charAt(i)) {
          //check the difference between i and j
          int diff = i - j;
          if (diff == 0) {
            //same index nothing to do
          } else if (diff == 1) {
            //right next to each other.
            dp[i][j] = s.substring(j, i + 1);
            if (dp[i][j] != null && maxLength < dp[i][j].length()) {
              maxIIndex = i;
              maxJIndex = j;
              maxLength = dp[i][j].length();
            }
          } else if (diff > 1) {
            int indexOfj = j + 1;
            int indexOfi = i - 1;
            if (dp[indexOfi][indexOfj] != null) {
              dp[i][j] = s.charAt(i) + dp[indexOfi][indexOfj] + s.charAt(i);
            }
            if (dp[i][j] != null && maxLength < dp[i][j].length()) {
              maxIIndex = i;
              maxJIndex = j;
              maxLength = dp[i][j].length();
            }
          }
        }
      }
    }
    if (maxLength == -1) {
      return s.substring(0, 1);
    }
    return dp[maxIIndex][maxJIndex];
  }

  public static String longestPalindromeString(String s) {
    if (s.length() == 1 || s.length() == 0) {
      return s;
    }

    //Keep track of the maximum here itself in this loop.
    //Initialization complete.
    int maxLength = -1;
    int maxIIndex = -1;
    int maxJIndex = -1;
    HashSet<String> currentlyFoundPalindrome = new HashSet<>();
    for(int i=0; i < s.length(); i++) {
      currentlyFoundPalindrome.add(s.substring(i,i+1));
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {
        if (s.charAt(j) == s.charAt(i)) {
          //check the difference between i and j
          int diff = i - j;
          if (diff == 0) {
            //same index nothing to do
          } else if (diff == 1) {
            //right next to each other.
            String str = s.substring(j, i+1);
            currentlyFoundPalindrome.add(str);
            if (str != null && maxLength < str.length()) {
              maxIIndex = i;
              maxJIndex = j;
              maxLength = str.length();
            }
          } else if (diff > 1) {
            int indexOfj = j + 1;
            if(currentlyFoundPalindrome.contains(s.substring(indexOfj, i))) {
              String str = s.charAt(i) + s.substring(indexOfj, i) + s.charAt(i);
              if (str != null && maxLength < str.length()) {
                maxIIndex = i;
                maxJIndex = j;
                maxLength = str.length();
              }
              currentlyFoundPalindrome.add(str);
            }
          }
        }
      }
    }
    if (maxLength == -1) {
      return s.substring(0, 1);
    }
    return s.substring(maxJIndex, maxIIndex+1);
  }

  public static double findMedianInSortedArray(int[] nums1, int nums2[]) {
    return 0.0;
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0, j = 0;
    int arr[] = new int[nums1.length + nums2.length];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        arr[i + j] = nums1[i];
        i++;
      } else {
        arr[i + j] = nums2[j];
        j++;
      }
    }

    while (i < nums1.length) {
      arr[i + j] = nums1[i++];
    }

    while (j < nums2.length) {
      arr[i + j] = nums2[j++];
    }

    if (arr.length % 2 == 0) {
      return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
    } else {
      return arr[arr.length / 2];
    }
  }

  //  public static int lengthOfLongestSubstringWithUniqueCharacters(String s) {
  //    //Track the index of the last seen character.
  //    HashMap<Character, Integer> characterIntegerHashSet = new HashMap<>();
  //    int maxLengthSequence = 0;
  //    int length = 0;
  //    for (int i = 0; i < s.length(); i++) {
  //      if (characterIntegerHashSet.containsKey(s.charAt(i))) {
  //        //we are seeing character again. So this means we save the
  //        //length of the sequence till now.
  //        maxLengthSequence = (maxLengthSequence < length) ? length : maxLengthSequence;
  //        //reset the index
  //        if(characterIntegerHashSet.get(s.charAt(i)) - i == )
  //        characterIntegerHashSet.put(s.charAt(i), i);
  //        length = length-1;
  //      } else {
  //        characterIntegerHashSet.put(s.charAt(i), i);
  //        length++;
  //        maxLengthSequence = (maxLengthSequence < length) ? length : maxLengthSequence;
  //      }
  //    }
  //    return maxLengthSequence;
  //  }

  public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
    ListNode root = new ListNode(0);
    ListNode temp = root;
    int carryOver = 0;
    while (node1 != null && node2 != null) {
      int sum = 0;
      sum += node1.val + node2.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      temp.next = new ListNode(0);
      temp = temp.next;
      node1 = node1.next;
      node2 = node2.next;
    }

    while (node1 != null) {
      int sum = 0;
      sum += node1.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      node1 = node1.next;
      temp.next = new ListNode(0);
      temp = temp.next;
    }

    while (node2 != null) {
      int sum = 0;
      sum += node2.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      node2 = node2.next;
      temp.next = new ListNode(0);
      temp = temp.next;
    }

    temp.next = null;
    return root;
  }

  private static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }
}
