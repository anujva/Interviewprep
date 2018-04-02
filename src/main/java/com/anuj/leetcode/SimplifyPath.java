package com.anuj.leetcode;

import java.util.LinkedList;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/......"));
    }

    private static String simplifyPath(String path) {
        LinkedList<String> legitPath = new LinkedList<>();
        //The start of the path can either be / or a character that is not /
        int index = 0;
        while (index < path.length()) {
            if (path.charAt(index) == '/') {
                index++;
            } else if (path.charAt(index) == '.') {
                index++;
                if(index < path.length()) {
                    if (path.charAt(index) == '.') {
                        //this would mean that the path is going back one level
                        if (index + 1 >= path.length() || path.charAt(index + 1) == '/') {
                            if (!legitPath.isEmpty()) {
                                legitPath.removeLast();
                            }
                            index = index + 1;
                        } else {
                            int startIndex = index -1;
                            while(index < path.length() && path.charAt(index)!= '/'){
                                index++;
                            }
                            legitPath.addLast(path.substring(startIndex, index));
                        }
                    } else if (path.charAt(index) == '/') {
                        //there is no need to do anything..
                    } else {
                        //this would mean that a directory starts with the . as the first charater.
                        int startIndex = index - 1;
                        while (index < path.length() && path.charAt(index) != '/') {
                            index++;
                        }
                        legitPath.addLast(path.substring(startIndex, index));
                    }
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
        if (buffer.length() == 0) {
            buffer.append("/");
        }

        return buffer.toString();
    }
}
