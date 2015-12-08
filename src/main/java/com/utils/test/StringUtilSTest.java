/*
 * file name:  StringUtil.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年10月14日
 */
package com.utils.test;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Operations on {@link java.lang.String} that are
 * <code>null</code> safe.</p>
 * 
 * @author  zheng
 * @version  [version, 2015年10月14日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        String str = "z he ng";
        String strEmpty = " ";
        
        //Checks if a String is empty ("") or null.
        boolean flag1 = StringUtils.isEmpty(strEmpty);
        boolean flag2 = StringUtils.isNotEmpty(strEmpty);
        //Checks if a String is whitespace, empty ("") or null.
        boolean flag3 = StringUtils.isBlank(strEmpty);
        boolean flag4 = StringUtils.isNotBlank(strEmpty);
        //System.out.println(strEmpty==null); --false
        //System.out.println(strEmpty.length()==0); --true
        
        //Removes control characters (char &lt;= 32) from both ends of this String, handling null by returnin null
        String flag5 = StringUtils.trim(strEmpty);
        //Removes control characters (char &lt;= 32) from both ends of this String returning <code>null</code> if the String is empty ("") after the trim or if it is null
        String flag6 = StringUtils.trimToNull(strEmpty);
        //returning an empty String ("") if the String is empty ("") after the trim or if it is null
        String flag7 = StringUtils.trimToEmpty(strEmpty);
        
        //Strips whitespace from the start and end of a String.
        String flag8 = StringUtils.strip(strEmpty);
        //Strips whitespace from the start and end of a String  returning null if the String is empty ("") after the strip.
        String flag9 = StringUtils.stripToNull(str);
        String flag10 = StringUtils.stripToEmpty(str);
        //Strips any of a set of characters from the start and end of a String.
        String flag11 = StringUtils.strip(str, " z");
        //Strips any of a set of characters from the start of a String.
        String flag12 = StringUtils.stripStart(" zhen g ", null);
        String flag13 = StringUtils.stripEnd(" zhen g ", null);
        //Strips whitespace from the start and end of every String in an array.
        String[] sssStrings = {"zhe ng ",""};
        String[] flag14 = StringUtils.stripAll(sssStrings);
        String[] flag15 = StringUtils.stripAll(sssStrings, "z");
        
        //Compares two Strings, returning <code>true</code> if they are equal.
        boolean flag16 = StringUtils.equals("zheng", "zheng");
        boolean flag17 = StringUtils.equalsIgnoreCase("zheng", "ZHENG");
        
        //Finds the first index within a String, handling <code>null</code>.
        int num1 = StringUtils.indexOf(str, "h");
        int num2 = StringUtils.indexOf("aabaabaa", 'b', 3);
        //返回字符串searchStr在字符串str中第ordinal次出现的位置。 
        int num3 = StringUtils.ordinalIndexOf("aabaabaa", "a", 2);
        //java utils bug
        int num4 = StringUtils.indexOfIgnoreCase("abc", "", 9);
        //TODO ??
        int num5 = StringUtils.indexOfIgnoreCase("aabaabaa", "", 2);
        int num6 = StringUtils.lastIndexOf("aabaabaa", 'b', 4);
        
        //Checks if String contains a search character
        boolean flag18 = StringUtils.contains(str, "z");
        //Search a String to find the first index of any character not in the given set of characters.
        int num7 = StringUtils.indexOfAnyBut("aba", new char[] {'a'} ) ;
        //Checks if the String contains only certain characters.
        boolean flag19 = StringUtils.containsOnly("abab", "abc");
        //Checks that the String does not contain certain characters.
        boolean flag20 = StringUtils.containsNone("abz", "xyz");
        
        //Gets a substring from the specified String avoiding exceptions.
        //A negative start position can be used to start <code>n</code> characters from the end of the String.
        //如果start是负数，将从字符串个数和负数累加，作为起点
        String num8 = StringUtils.substring("abc", -2);
        String num9 = StringUtils.substring("abc", -2, -1);
        
        //Gets the leftmost/rightmost <code>len</code> characters of a String.
        String num10 = StringUtils.left("abc", 2);
        String num11 = StringUtils.right("abc", 2);
        //Gets <code>len</code> characters from the middle of a String.
        String num12 = StringUtils.mid("abc", -2, 2);
        //Gets the substring before the first occurrence of a separator.The separator is not returned.
        String num13 = StringUtils.substringBefore("abc", "c");
        //Gets the substring after the first occurrence of a separator.The separator is not returned.
        String num14 = StringUtils.substringAfter("abcba", "b");
        //Gets the substring before the last occurrence of a separator.The separator is not returned.
        StringUtils.substringBeforeLast("abcba", "b");
        //Gets the substring after the last occurrence of a separator.The separator is not returned.
        StringUtils.substringAfterLast("abcba", "b");
        //Gets the String that is nested in between two instances of the same String.
        StringUtils.substringBetween("tagabctag", "tag");
        
        //Splits the provided text into an array, using whitespace as the separator.
        StringUtils.split("abc  def");
        //Splits the provided text into an array with a maximum length,separators specified.
        //A zero or negative value implies no limit
        String[] num15 = StringUtils.split("ab   de fg", null, 0);
        //Joins the elements of the provided array into a single String containing the provided list of elements.
        String[] num17 = {"a", "b", "c"};
        String num16 = StringUtils.join(num17);
        
        //Deletes all whitespaces from a String as defined by
        String num18 = StringUtils.deleteWhitespace("   ab  c  ");
        
        //Removes a substring only if it is at the begining of a source string,otherwise returns the source string.
        String num19 = StringUtils.removeStart("www.domain.com", "www.");
        StringUtils.removeEnd("www.domain.com", ".com");
        //Removes all occurrences of a substring from within the source string.
        String num20 = StringUtils.remove("queued", "ue");
        
        //Replaces a String with another String inside a larger String, once.
        String num21 = StringUtils.replaceOnce("aba", "a", "z");
        //Replaces all occurrences of a String within another String.
        String num22 = StringUtils.replace("aba", "a", "z");
        //Replaces all occurrences of Strings within another String.
        String num23 = StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"});
        
        //Overlays part of a String with another String.
        String num24 = StringUtils.overlay("abcdef", "zzzz", 2, 4);
        
        //Removes one newline from end of a String if it's there,otherwise leave it alone.
        String num25 = StringUtils.chomp("abc\r\n");
        //Removes <code>separator</code> from the end of str if it's there, otherwise leave it alone.
        String num26 = StringUtils.chomp(" foo", "foo");
        //Repeat a String <code>repeat</code> times to form a new String.
        String num27 = StringUtils.repeat("ab", 2);
        StringUtils.repeat("?", ", ", 3);
        
        //Right pad a String with spaces (' ').
        StringUtils.rightPad("bat", 5);
        StringUtils.leftPad("bat", 5);
        
        //Converts a String to upper case as per {@link String#toUpperCase()}.
        StringUtils.upperCase("aBc");
        //Converts a String to lower case as per {@link String#toLowerCase()}.
        StringUtils.lowerCase("aBc");
        StringUtils.isAllUpperCase("aBC");
        StringUtils.isAllLowerCase("abC");
        //Capitalizes a String changing the first letter to title case as per {@link Character#toTitleCase(char)}. No other letters are changed.
        String num28 = StringUtils.capitalize("cat");
        StringUtils.uncapitalize("CAT");
        //Swaps the case of a String changing upper and title case to lower case, and lower case to upper case.
        String num29 = StringUtils.swapCase("The dog has a BONE");
        
        //Counts how many times the substring appears in the larger String.
        int num30 = StringUtils.countMatches("abba", "a");
        
        //Checks if the String contains only unicode letters.
        boolean flag21 = StringUtils.isAlpha("ab2c");
        //Checks if the String contains only unicode letters and space (' ').
        StringUtils.isAlphaSpace("ab c");
        //Checks if the String contains only unicode letters or digits.
        StringUtils.isAlphanumeric("ab2c");
        //Checks if the String contains only unicode letters, digits or space (<code>' '</code>).
        StringUtils.isAlphanumeric("ab2 c");
        StringUtils.isNumeric("12.3");
        
        //Returns either the passed in String,or if the String is <code>null</code>, an empty String ("").
        String num31 = StringUtils.defaultString("ba2t");
        StringUtils.defaultString(null, "NULL");
        
        //Reverses a String as per {@link StrBuilder#reverse()}.
        String num32 = StringUtils.reverse("bat");
        String num33 = StringUtils.reverseDelimited("a.b.c", '.');
        
        //Abbreviates a String using ellipses.
        String num34 = StringUtils.abbreviate("abcdefg", 6);
        
        //Compares two Strings, and returns the portion where they differ.
        String num35 = StringUtils.difference("abcde", "abxyz");
        //Compares two Strings, and returns the index at which the Strings begin to differ.
        int num36 = StringUtils.indexOfDifference("ab", "abxyz");
        //Compares all Strings in an array and returns the index at which the Strings begin to differ.
        StringUtils.indexOfDifference(new String[] {"ab", "abxyz"});
        //Compares all Strings in an array and returns the initial sequence of characters that is common to all of them.
        StringUtils.getCommonPrefix(new String[] {"ab", "abxyz"});
        
        //Check if a String starts with a specified prefix.
        StringUtils.startsWith("abcdef", "abc");
        StringUtils.endsWith("ABCDEF", "cde");
        //Check if a String starts with any of an array of specified strings.
        boolean flag27 = StringUtils.startsWithAny("abcxyz", new String[] {null, "xyz", "abc"});
        StringUtils.endsWithAny("abcxyz", new String[] {null, "xyz", "abc"});
        
        System.out.println(num35);
    }
}
