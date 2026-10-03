/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckForNull
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

final class AndroidInteger {
    @CheckForNull
    static Integer tryParse(String string) {
        return AndroidInteger.tryParse(string, 10);
    }

    @CheckForNull
    static Integer tryParse(String string, int radix) {
        boolean negative;
        Preconditions.checkNotNull(string);
        Preconditions.checkArgument(radix >= 2, "Invalid radix %s, min radix is %s", radix, 2);
        Preconditions.checkArgument(radix <= 36, "Invalid radix %s, max radix is %s", radix, 36);
        int length = string.length();
        int i = 0;
        if (length == 0) {
            return null;
        }
        boolean bl = negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            return null;
        }
        return AndroidInteger.tryParse(string, i, radix, negative);
    }

    @CheckForNull
    private static Integer tryParse(String string, int offset, int radix, boolean negative) {
        int max = Integer.MIN_VALUE / radix;
        int result2 = 0;
        int length = string.length();
        while (offset < length) {
            int digit;
            if ((digit = Character.digit(string.charAt(offset++), radix)) == -1) {
                return null;
            }
            if (max > result2) {
                return null;
            }
            int next = result2 * radix - digit;
            if (next > result2) {
                return null;
            }
            result2 = next;
        }
        if (!negative && (result2 = -result2) < 0) {
            return null;
        }
        if (result2 > Integer.MAX_VALUE || result2 < Integer.MIN_VALUE) {
            return null;
        }
        return result2;
    }

    private AndroidInteger() {
    }
}

