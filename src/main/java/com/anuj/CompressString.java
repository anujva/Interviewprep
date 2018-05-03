package com.anuj;

/**
 * Created by anuj on 10/24/17.
 */
public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("null"));
    }

    public static String compressString(String text) {
        if (text == null) return null;
        if (text.length() == 0) return text;
        int runningCount = 1;
        char oneCharBefore = text.charAt(0);
        StringBuffer stringBuffer = new StringBuffer(text.length());
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == oneCharBefore) {
                runningCount++;
            } else {
                //append whatever is the current oneCharBefore
                //with the count and append to string.
                if (runningCount > 1)
                    stringBuffer.append(oneCharBefore)
                            .append(runningCount);
                else
                    stringBuffer.append(oneCharBefore);
                runningCount = 1;
                oneCharBefore = text.charAt(i);
            }
        }
        if (runningCount > 1)
            stringBuffer.append(oneCharBefore).append(runningCount);
        else
            stringBuffer.append(oneCharBefore);
        return stringBuffer.toString();
    }
}
