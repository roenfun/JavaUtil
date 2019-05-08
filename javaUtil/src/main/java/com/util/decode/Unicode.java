package com.util.decode;

/**
 * @author Chad.long
 * Date: 2019-04-01 16:04
 * Version 1.0
 */
public class Unicode {

    public static String unicode(String source) {
        StringBuffer sb = new StringBuffer();
        char[] source_char = source.toCharArray();
        String unicode = null;
        for (char c : source_char) {
            unicode = Integer.toHexString(c);
            if (unicode.length() <= 2) {
                unicode = "00" + unicode;
            }
            sb.append("\\u" + unicode);
        }

//        System.out.println(sb);
        return sb.toString();
    }

    public static String decodeUnicode(String unicode) {
        StringBuffer sb = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            sb.append((char) data);
        }
        return sb.toString();
    }

    public static String decodeUnicode2(String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = null;
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {

        String str = "李锋镝的个人博客http://www.lifengdi.com";
//        String str = "假装这里有Emoji表情";
//        unicode(str);
        System.out.println("unicode:\n" + (unicode(str)));
        System.out.println("decodeUnicode:\n" + decodeUnicode(unicode(str)));
        System.out.println("decodeUnicode2:\n" + decodeUnicode2(unicode(str)));

    }

}
