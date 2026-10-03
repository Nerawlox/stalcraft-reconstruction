/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  junit.framework.Assert
 */
package net.sf.kdgcommons.test;

import java.util.regex.Pattern;
import junit.framework.Assert;

public class StringAsserts {
    public static void assertSubstringCount(String string, String string2, int n) {
        StringAsserts.assertSubstringCount("", string, string2, n);
    }

    public static void assertSubstringCount(String string, String string2, String string3, int n) {
        int n2 = 0;
        int n3 = string2.indexOf(string3);
        while (n3 >= 0 && n3 < string2.length()) {
            n2 += n3 >= 0 ? 1 : 0;
            n3 = string2.indexOf(string3, n3 + 1);
        }
        Assert.assertEquals((String)(string + ": count(" + string3 + ")"), (int)n, (int)n2);
    }

    public static void assertRegex(String string, String string2) {
        StringAsserts.assertRegex("expected: " + string + ", was: " + string2, string, string2);
    }

    public static void assertRegex(String string, String string2, String string3) {
        Assert.assertTrue((String)string, (boolean)Pattern.matches(string2, string3));
    }

    public static void assertContainsRegex(String string, String string2) {
        StringAsserts.assertContainsRegex("expected: " + string + ", was: " + string2, string, string2);
    }

    public static void assertContainsRegex(String string, String string2, String string3) {
        Assert.assertTrue((String)string, (boolean)Pattern.compile(string2).matcher(string3).find());
    }

    public static void assertDoesntContainRegex(String string, String string2) {
        StringAsserts.assertDoesntContainRegex("didn't expact: " + string + ", was: " + string2, string, string2);
    }

    public static void assertDoesntContainRegex(String string, String string2, String string3) {
        Assert.assertFalse((String)string, (boolean)Pattern.compile(string2).matcher(string3).find());
    }

    public static String assertContainsThenRemove(String string, String string2) {
        int n = string.indexOf(string2);
        if (n < 0) {
            Assert.fail((String)("\"" + string2 + "\" not found: " + string));
        }
        int n2 = n + string2.length();
        return string.substring(0, n) + string.substring(n2);
    }
}

