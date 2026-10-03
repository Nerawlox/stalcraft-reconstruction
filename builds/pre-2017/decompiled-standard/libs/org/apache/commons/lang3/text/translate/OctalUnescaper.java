/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

public class OctalUnescaper
extends CharSequenceTranslator {
    private static int OCTAL_MAX = 377;

    public int translate(CharSequence input, int index, Writer out) throws IOException {
        if (input.charAt(index) == '\\' && index < input.length() - 1 && Character.isDigit(input.charAt(index + 1))) {
            int start = index + 1;
            int end = index + 2;
            while (end < input.length() && Character.isDigit(input.charAt(end))) {
                if (Integer.parseInt(((Object)input.subSequence(start, ++end)).toString(), 10) <= OCTAL_MAX) continue;
                --end;
                break;
            }
            out.write(Integer.parseInt(((Object)input.subSequence(start, end)).toString(), 8));
            return 1 + end - start;
        }
        return 0;
    }
}

