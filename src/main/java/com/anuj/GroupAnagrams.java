package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anuj on 5/28/17.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        System.out.println(groupAnagrams(strs));
        ;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mapAnagramToIndex = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strCharArray = strs[i].toCharArray();
            Arrays.sort(strCharArray);
            String key = new String(strCharArray);
            if (mapAnagramToIndex.containsKey(key)) {
                mapAnagramToIndex.get(key).add(strs[i]);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                mapAnagramToIndex.put(key, stringList);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        answer.addAll(mapAnagramToIndex.values());
        return answer;
    }
}
