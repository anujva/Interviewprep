package com.anuj.leetcode;

import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/hello/world/./"));
    }

    private static String simplifyPath(String path) {
        //What can be done for the
        LinkedList<String> legitPath = new LinkedList<>();
        //The start of the path can either be / or a character that is not /
        int index = 0;
        while (index < path.length()) {
            if (path.charAt(index) == '/') {
                index++;
            } else if (path.charAt(index) == '.') {
                index++;
                if (path.charAt(index) == '.') {
                    //this would mean that the path is going back one level
                    if (path.charAt(index + 1) == '/') {
                        legitPath.removeLast();
                        index = index + 1;
                    } else {
                        throw new IllegalArgumentException("Path has illegal characters");
                    }
                } else if (path.charAt(index) == '/') {
                    //there is no need to do anything..
                } else {
                    //this would mean that a directory starts with the . as the first charater.
                    int startIndex = index;
                    while (index < path.length() && path.charAt(index) != '/') {
                        index++;
                    }
                    legitPath.addLast(path.substring(startIndex, index));
                }
            } else {
                int startIndex = index;
                while (index < path.length() && path.charAt(index) != '/') {
                    index++;
                }
                legitPath.addLast(path.substring(startIndex, index));
            }
        }

        //Once all the path values are in the stack
        //go over the linkedList as a queue..
        StringBuffer buffer = new StringBuffer();
        while (!legitPath.isEmpty()) {
            buffer.append("/");
            buffer.append(legitPath.poll());
        }
        return buffer.toString();
    }
}
