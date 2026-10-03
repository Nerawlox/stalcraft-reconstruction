/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.CodePointTranslator;

public class UnicodeEscaper
extends CodePointTranslator {
    private final int below;
    private final int above;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    private UnicodeEscaper(int below, int above, boolean between) {
        this.below = below;
        this.above = above;
        this.between = between;
    }

    public static UnicodeEscaper below(int codepoint) {
        return UnicodeEscaper.outsideOf(codepoint, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper above(int codepoint) {
        return UnicodeEscaper.outsideOf(0, codepoint);
    }

    public static UnicodeEscaper outsideOf(int codepointLow, int codepointHigh) {
        return new UnicodeEscaper(codepointLow, codepointHigh, false);
    }

    public static UnicodeEscaper between(int codepointLow, int codepointHigh) {
        return new UnicodeEscaper(codepointLow, codepointHigh, true);
    }

    public boolean translate(int codepoint, Writer out) throws IOException {
        if (this.between ? codepoint < this.below || codepoint > this.above : codepoint >= this.below && codepoint <= this.above) {
            return false;
        }
        if (codepoint > 65535) {
            out.write("\\u" + UnicodeEscaper.hex(codepoint));
        } else if (codepoint > 4095) {
            out.write("\\u" + UnicodeEscaper.hex(codepoint));
        } else if (codepoint > 255) {
            out.write("\\u0" + UnicodeEscaper.hex(codepoint));
        } else if (codepoint > 15) {
            out.write("\\u00" + UnicodeEscaper.hex(codepoint));
        } else {
            out.write("\\u000" + UnicodeEscaper.hex(codepoint));
        }
        return true;
    }
}

