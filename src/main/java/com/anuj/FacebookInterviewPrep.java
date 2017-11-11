
package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FacebookInterviewPrep {
  public static void main(String[] args) {
    //System.out.println(arrange("WWWB", 2));
    ArrayList<Integer> a = new ArrayList<>(Arrays
        .asList(0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2,
            0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2,
            3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3,
            3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2,
            1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2,
            0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3,
            0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2));
    System.out.println(removeElementLinkedList(a, 2));
  }

  public static int removeElementLinkedList(ArrayList<Integer> a, int b) {
    LinkedList<Integer> c = new LinkedList<>(a);
    int deleted = 0;
    Iterator<Integer> listIterator = c.iterator();
    while (listIterator.hasNext()) {
      if (listIterator.next() == b) {
        listIterator.remove();
        deleted++;
      }
    }
    listIterator = c.iterator();
    int index = 0;
    while(listIterator.hasNext()) {
      a.set(index++, listIterator.next());
    }
    return a.size() - deleted;
  }

  public static long reverseBits(long num) {
    long bitmask = 0x00001111;
    //we need only 32 bits of these..
    long num32 = num & bitmask;
    StringBuffer stringBuffer = new StringBuffer();

    while (num32 != 0) {
      stringBuffer.append(num32 % 2);
      num32 = num32 / 2;
    }

    //we got this 0001 for 110 011
    return 0;
  }

  public static int removeElement(ArrayList<Integer> a, int b) {
    int index = 0;
    int deleted = 0;
    while (index < a.size()) {
      if (a.get(index) == b) {
        //shift the rest of the array the right.
        for (int i = index; i < a.size() - 1; i++) {
          a.set(i, a.get(i + 1));
        }

        if (index == a.size() - 1) {
          a.set(index, b - 1);
        }
        deleted++;
        continue;
      }
      index++;
    }
    return a.size() - deleted;
  }

  public static ArrayList<Integer> wave(ArrayList<Integer> a) {
    Collections.sort(a);
    for (int i = 1; i < a.size(); i += 2) {
      int temp = a.get(i);
      a.set(i, a.get(i - 1));
      a.set(i - 1, temp);
    }
    return a;
  }
  //
  //  public int isSymmetric(TreeNode a) {
  //    if(a == null) {
  //      return 1;
  //    }
  //
  //    String str1 = leftOrderFirst(a.left);
  //    String str2 = rightOrderFirst(a.right);
  //    return str1.equalsIgnoreCase(str2) == true ? 1 : 0;
  //  }
  //
  //  String rightOrderFirst(TreeNode a) {
  //    if(a == null) {
  //      return "";
  //    }
  //    return rightOrderFirst(a.right) + rightOrderFirst(a.left) + a.val;
  //  }
  //
  //  String leftOrderFirst(TreeNode a) {
  //    if(a == null) {
  //      return "";
  //    }
  //    return leftOrderFirst(a.left) + leftOrderFirst(a.right) + a.val;
  //  }

  public static int arrange(String a, int b) {
    ArrayList<ArrayList<String>> arrangements = new ArrayList<>();
    int numberOfHorses = a.length();
    if (numberOfHorses < b) {
      return -1;
    }
    getValueFromStables(a, b, arrangements);
    ArrayList<Integer> integerValues = getIntegerValuesFromString(arrangements);
    return 0;//min(integerValues);
  }

  private static ArrayList<Integer> getIntegerValuesFromString(ArrayList<ArrayList<String>> horsesInStables) {
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    //    for (int i = 0; i < horsesInStables.size(); i++) {
    //      String horses = horsesInStables.get(i);
    //      int whiteHorses = 0;
    //      int blackHorses = 0;
    //      for (int j = 0; j < horsesInStables.get(i).length(); j++) {
    //        if (horses.charAt(j) == 'W') {
    //          whiteHorses++;
    //        } else {
    //          blackHorses++;
    //        }
    //      }
    //      integerArrayList.add(whiteHorses * blackHorses);
    //    }
    return integerArrayList;
  }

  private static void getValueFromStables(String a, int numOfStables, ArrayList<ArrayList<String>> arrangements) {
    if (numOfStables == 1) {

    }
    for (int i = 0; i < a.length(); i++) {

    }
  }

  public static ArrayList<Integer> stepnum(int a, int b) {
    ArrayList<Integer> listOfSteppingNumbers = new ArrayList<>();
    for (int i = a; i <= b; i++) {
      if (isSteppingNumber(i)) {
        listOfSteppingNumbers.add(i);
      }
    }

    return listOfSteppingNumbers;
  }

  public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
    int rows = a.size();
    int columns = a.get(0).size();
    ArrayList<ArrayList<Integer>> bigListOfArrayList = new ArrayList<>();
    for (int i = 0; i < columns; i++) {
      int index = i;
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        list.add(a.get(j).get(index--));
      }
      bigListOfArrayList.add(list);
    }

    for (int j = 1; j < rows; j++) {
      int startx = columns - 1;
      ArrayList<Integer> list = new ArrayList<>();
      for (int k = j; k < rows; k++) {
        list.add(a.get(k).get(startx--));
      }
      bigListOfArrayList.add(list);
    }
    return bigListOfArrayList;
  }

  private static boolean isSteppingNumber(int num) {
    while (num > 0) {
      int digit = num % 10;
      num = num / 10;
      if (num > 0) {
        int digit2 = num % 10;
        if (Math.abs(digit - digit2) != 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static int isInterleave(String a, String b, String c) {
    if (a.length() + b.length() != c.length()) {
      return 0;
    }
    int indexa = 0;
    int indexb = 0;
    int indexc = 0;
    HashMap<String, Integer> memoization = new HashMap<>();
    return interleave(a, b, c, indexa, indexb, indexc, memoization);
  }

  private static int interleave(String a, String b, String c, int indexa, int indexb, int indexc,
      HashMap<String, Integer> memoization) {
    if (indexa == a.length() && indexb == b.length() && indexc == c.length()) {
      return 1;
    }
    int val1 = 0;
    if (indexa < a.length() && indexb < b.length() && a.charAt(indexa) == c.charAt(indexc) && b.charAt(indexb) == c
        .charAt(indexc)) {
      //there is an alternate route that also needs to be explored.
      indexa++;
      indexc++;
      if (memoization.containsKey(indexa + "" + indexb + "" + indexc)) {
        val1 = memoization.get(indexa + "" + indexb + "" + indexc);
      } else {
        val1 = interleave(a, b, c, indexa, indexb, indexc, memoization);
        memoization.put(indexa + "" + indexb + "" + indexc, val1);
        if (val1 == 1) {
          return 1;
        }
      }
      indexa--;
      indexb++;
      if (memoization.containsKey(indexa + "" + indexb + "" + indexc)) {
        val1 = memoization.get(indexa + "" + indexb + "" + indexc);
      } else {
        val1 = interleave(a, b, c, indexa, indexb, indexc, memoization);
        memoization.put(indexa + "" + indexb + "" + indexc, val1);
        if (val1 == 1) {
          return 1;
        }
      }
    }
    if (indexa < a.length() && a.charAt(indexa) == c.charAt(indexc)) {
      indexa++;
      indexc++;
      if (memoization.containsKey(indexa + "" + indexb + "" + indexc)) {
        val1 = memoization.get(indexa + "" + indexb + "" + indexc);
      } else {
        val1 = interleave(a, b, c, indexa, indexb, indexc, memoization);
        memoization.put(indexa + "" + indexb + "" + indexc, val1);
      }
    }
    int val2 = 0;
    if (indexb < b.length() && b.charAt(indexb) == c.charAt(indexc)) {
      indexb++;
      indexc++;
      if (memoization.containsKey(indexa + "" + indexb + "" + indexc)) {
        val2 = memoization.get(indexa + "" + indexb + "" + indexc);
      } else {
        val2 = interleave(a, b, c, indexa, indexb, indexc, memoization);
        memoization.put(indexa + "" + indexb + "" + indexc, val2);
      }
    }
    if (val1 == 1 || val2 == 1) {
      return 1;
    }
    return 0;
  }

  public static int titleToNumber(String a) {
    int val = 0;
    for (int i = a.length() - 1; i > -1; i--) {
      int charIntVal = (int)a.charAt(i) - 64;
      val += charIntVal * Math.pow(26, a.length() - 1 - i);
    }
    return val;
  }

  public static int majorityElement(final List<Integer> a) {
    HashMap<Integer, Integer> elementCount = new HashMap<>();
    for (Integer n : a) {
      if (elementCount.containsKey(n)) {
        Integer val = elementCount.get(n);
        val++;
        elementCount.put(n, val);
      } else {
        elementCount.put(n, 1);
      }

      if (elementCount.get(n) > Math.floor(a.size() / 2)) {
        return n;
      }
    }
    return -1;
  }
  //  public static int diffPossible(final List<Integer> A, int B) {
  //
  //    HashMap<Integer, Integer> hashMap = new HashMap<>();
  //
  //    for (int num : A) {
  //      if (hashMap.containsKey(num)) {
  //        int value = hashMap.get(num);
  //        value++;
  //        hashMap.put(num, value);
  //      } else {
  //        hashMap.put(num, 1);
  //      }
  //    }
  //
  //    for (int num : A) {
  //
  //      int n = B + num;
  //
  //      if (hashMap.containsKey(n)) {
  //        if (num == n && hashMap.get(n) > 1) {
  //          return 1;
  //        } else if (num != n) {
  //          return 1;
  //        }
  //      }
  //
  //      n = num - B;
  //
  //      if (hashMap.containsKey(n)) {
  //        if (num == n && hashMap.get(n) > 1) {
  //          return 1;
  //        } else if (num != n) {
  //          return 1;
  //        }
  //      }
  //    }
  //
  //    return 0;
  //
  //  }

  public static int diffPossible(final List<Integer> a, int b) {
    HashMap<Integer, HashSet<Integer>> integersFromArray = new HashMap<>();
    for (int i = 0; i < a.size(); i++) {
      if (integersFromArray.containsKey(a.get(i))) {
        HashSet<Integer> setMap = integersFromArray.get(a.get(i));
        setMap.add(i);
      } else {
        HashSet<Integer> set = new HashSet<>();
        set.add(i);
        integersFromArray.put(a.get(i), set);
      }
    }
    for (int i = 0; i < a.size(); i++) {
      if (integersFromArray.containsKey(a.get(i) - b)) {
        //find the index for it
        HashSet<Integer> setMap = integersFromArray.get(a.get(i) - b);
        if (setMap.contains(i) && setMap.size() > 1) {
          //there exists atleast one more index apart from this
          return 1;
        } else if (!setMap.contains(i)) {
          return 1;
        }
      }
    }
    return 0;
  }

  public static int lengthOfLastWord(final String a) {
    int i = a.length() - 1;
    for (; i > -1; i--) {
      if (a.charAt(i) == ' ') {
        //eat up all the spaces in the end
        continue;
      } else {
        break;
      }
    }
    int endIndex = i;
    for (; i > -1; i--) {
      if (a.charAt(i) == ' ') {
        return endIndex - i;
      } else if (i == 0) {
        return endIndex - i + 1;
      }
    }
    return 0;
  }

  public static boolean isPower(int a) {
    if (a == 1) {
      return true;
    }
    for (int i = a / 2; i > -1; i--) {
      for (int j = 2; j < a; j++) {
        if (Math.pow(i, j) == a) {
          return true;
        } else if (Math.pow(i, j) > a) {
          break;
        }
      }
    }
    return false;
  }

  public static Integer getSteps(int x1, int y1, int x2, int y2) {
    //lets do breadth first search from the first point onwards.
    //till we visit the second point.
    boolean found = false;
    HashSet<Point<Integer, Integer>> pointsAtOldDistance = new HashSet<>();
    Point<Integer, Integer> pointStart = new Point<>(x1, y1);
    Point<Integer, Integer> pointEnd = new Point<>(x2, y2);
    pointsAtOldDistance.add(pointStart);
    HashSet<Point<Integer, Integer>> pointsAlreadySeen = new HashSet<>();
    int steps = 0;
    if (pointStart.equals(pointEnd)) {
      return 0;
    }
    while (!found) {
      //step i points from this start.
      HashSet<Point<Integer, Integer>> pointsAtThisDistance = new HashSet<>();
      steps++;
      for (Point<Integer, Integer> point : pointsAtOldDistance) {
        if (!pointsAlreadySeen.contains(point)) {
          pointsAlreadySeen.add(point);
          Point<Integer, Integer> point1 = new Point<>(point.first - 1, point.second - 1);
          Point<Integer, Integer> point2 = new Point<>(point.first - 1, point.second);
          Point<Integer, Integer> point3 = new Point<>(point.first - 1, point.second + 1);
          Point<Integer, Integer> point4 = new Point<>(point.first, point.second - 1);
          Point<Integer, Integer> point5 = new Point<>(point.first, point.second + 1);
          Point<Integer, Integer> point6 = new Point<>(point.first + 1, point.second - 1);
          Point<Integer, Integer> point7 = new Point<>(point.first + 1, point.second);
          Point<Integer, Integer> point8 = new Point<>(point.first + 1, point.second + 1);

          pointsAtThisDistance.add(point1);
          pointsAtThisDistance.add(point2);
          pointsAtThisDistance.add(point3);
          pointsAtThisDistance.add(point4);
          pointsAtThisDistance.add(point5);
          pointsAtThisDistance.add(point6);
          pointsAtThisDistance.add(point7);
          pointsAtThisDistance.add(point8);
          if (pointsAtThisDistance.contains(new Point<>(x2, y2))) {
            found = true;
            return steps;
          }
          pointsAtOldDistance = pointsAtThisDistance;
        }
      }
    }
    return null;
  }

  public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    int steps = 0;
    for (int i = 0; i < X.size() - 1; i++) {
      steps += getSteps(X.get(i), Y.get(i), X.get(i + 1), Y.get(i + 1));
    }
    return steps;
  }

  public static boolean isPrime(int n) {
    if (n == 2) {
      return true;
    }
    if (n == 3) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    if (n % 3 == 0) {
      return false;
    }
    int i = 5;
    int w = 2;
    while (i * i <= n) {
      if (n % i == 0) {
        return false;
      }
      i += w;
      w = 6 - w;
    }
    return true;
  }

  public static ArrayList<Integer> primesum(int a) {
    //test with 2 separately
    if (a == 4) {
      return new ArrayList<>(Arrays.asList(2, 2));
    }
    for (int i = 3; i < a; i += 2) {
      if (isPrime(i) && isPrime(a - i)) {
        return new ArrayList<>(Arrays.asList(i, a - i));
      }
    }
    return null;
  }

  public static int bulbs(ArrayList<Integer> a) {
    int countOfSwitch = 0;
    for (int i = 0; i < a.size(); i++) {
      //what is the current value of the swtich.
      int currentVal = (countOfSwitch % 2 == 0) ? a.get(i) : (a.get(i) + 1) % 2;
      if (currentVal != 1) {
        //flip the switch
        countOfSwitch++;
      }
    }
    return countOfSwitch;
  }

  public static int numSetBits(long a) {
    int count = 0;
    while (a != 0) {
      long rem = a % 2;
      if (rem == 1) {
        count++;
      }
      a = a / 2;
    }
    return count;
  }

  public static int singleNumber(final List<Integer> a) {
    Integer n = a.get(0);
    for (int i = 1; i < a.size(); i++) {
      n = n ^ a.get(i);
    }
    return n;
  }

  public static int gcd(int a, int b) {
    if (b == 1 || a == 1) {
      return 1;
    }

    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }

    int remainder = a % b;
    if (remainder == 0) {
      return b;
    }

    if (remainder > b) {
      return gcd(remainder, b);
    } else {
      return gcd(b, remainder);
    }
  }

  private static class Point<A, B> {
    private A first;
    private B second;

    public Point(A first, B second) {
      super();
      this.first = first;
      this.second = second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(first, second);
    }

    public boolean equals(Object other) {
      if (other instanceof Point) {
        Point otherPoint = (Point)other;
        return ((this.first == otherPoint.first || (this.first != null && otherPoint.first != null && this.first
            .equals(otherPoint.first))) && (this.second == otherPoint.second || (this.second != null
            && otherPoint.second != null && this.second.equals(otherPoint.second))));
      }

      return false;
    }

    public String toString() {
      return "(" + first + ", " + second + ")";
    }

    public A getFirst() {
      return first;
    }

    public void setFirst(A first) {
      this.first = first;
    }

    public B getSecond() {
      return second;
    }

    public void setSecond(B second) {
      this.second = second;
    }
  }
}
