package com.anuj;

import java.util.ArrayList;

public class CombinationsAndPermutations {
    public static void main(String[] args) {
        getCombPerms("string");
    }

    public static ArrayList<String> getCombPerms(String s) {
        ArrayList<String> combsAndPerms = new ArrayList<>();
        Integer[] oneStepAboveArray = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            combsAndPerms.add(s.substring(i, i+1));
            oneStepAboveArray[i] = i;
        }
        ArrayList<ArrayList<String>> answers = new ArrayList<>();
        ArrayList<String> answers1 = new ArrayList<>(combsAndPerms);
        answers.add(combsAndPerms);
        for(int i=1; i < s.length(); i++) {
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
        for(int i=0; i < oneStepAboveList.size(); i++) {
           for(int j=oneStepAboveArray[i]+1; j < oneCharacterArray.size(); j++){
                returnedAnswer.add(oneStepAboveList.get(i).concat(oneCharacterArray.get(j)));
                newIndices.add(j);
           }
       }
       return newIndices.toArray(oneStepAboveArray);
    }

    public static final <E> void printArrayList(ArrayList<E> arrayList) {
        for(E val : arrayList) {
            System.out.println(val);
        }
    }
}
