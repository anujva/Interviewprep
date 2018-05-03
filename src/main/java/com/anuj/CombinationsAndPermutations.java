package com.anuj;

import java.util.ArrayList;
import java.util.HashSet;

public class CombinationsAndPermutations {
    public static void main(String[] args) {
        printArrayList(getCombsPermsOther("string"));
    }

    public static ArrayList<String> getCombPerms(String s) {
        ArrayList<String> combsAndPerms = new ArrayList<>();
        Integer[] oneStepAboveArray = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            combsAndPerms.add(s.substring(i, i + 1));
            oneStepAboveArray[i] = i;
        }
        ArrayList<ArrayList<String>> answers = new ArrayList<>();
        ArrayList<String> answers1 = new ArrayList<>(combsAndPerms);
        answers.add(combsAndPerms);
        for (int i = 1; i < s.length(); i++) {
            ArrayList<String> returnedAnswer = new ArrayList<>();
            oneStepAboveArray = getCombinations(returnedAnswer, combsAndPerms,
                    oneStepAboveArray, answers1);
            answers1 = returnedAnswer;
            answers.add(returnedAnswer);
        }
        printArrayList(answers);
        return null;
    }

    private static Integer[] getCombinations(ArrayList<String> returnedAnswer,
                                             ArrayList<String> oneCharacterArray, Integer[] oneStepAboveArray,
                                             ArrayList<String> oneStepAboveList) {
        ArrayList<Integer> newIndices = new ArrayList<>();
        for (int i = 0; i < oneStepAboveList.size(); i++) {
            for (int j = oneStepAboveArray[i] + 1; j < oneCharacterArray.size(); j++) {
                returnedAnswer.add(oneStepAboveList.get(i).concat(oneCharacterArray.get(j)));
                newIndices.add(j);
            }
        }
        return newIndices.toArray(oneStepAboveArray);
    }

    public static final <E> void printArrayList(ArrayList<E> arrayList) {
        for (E val : arrayList) {
            System.out.println(val);
        }
    }


    public static ArrayList<String> getCombsPermsOther(String s) {
        HashSet<String> result = new HashSet<>();
        getCombPermsSubroutine(s, result);
        return new ArrayList<>(result);
    }

    public static void getCombPermsSubroutine(String s,
                                              HashSet<String> result) {
        if (s == null) return;
        if (s.isEmpty()) return;
        if (s.length() == 1) {
            result.add(s);
            return;
        }
        //once the copying is done.. start the recursion.
        Character firstCharacter = s.charAt(0);
        getCombPermsSubroutine(s.substring(1), result);
        //Here we are going to look at the strings in the result HashSet
        //And then we are going to add the character that is at the index.
        //at all the possible

        String[] arrayOfResultantString = new String[result.size()];
        result.toArray(arrayOfResultantString);
        for (String str : arrayOfResultantString) {
            for (int j = 0; j < str.length(); j++) {
                //stringReducedChars[i] needs to go in position j
                char[] additionString = new char[str.length() + 1];
                int idx = 0;
                for (int k = 0; k < str.length(); k++) {
                    if (k == j) {
                        additionString[idx++] = firstCharacter;
                    }
                    additionString[idx++] = str.charAt(k);
                }
                result.add(new String(additionString));
            }
            result.add(str.concat(Character.toString(firstCharacter)));
            result.add(Character.toString(firstCharacter));
        }
    }
}
