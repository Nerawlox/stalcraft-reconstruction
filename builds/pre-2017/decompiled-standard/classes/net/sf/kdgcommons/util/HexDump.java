/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import java.io.PrintWriter;
import java.util.Iterator;
import net.sf.kdgcommons.lang.StringBuilderUtil;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class HexDump {
    private int _bytesPerLine;
    private boolean _showOffset;
    private int _offset;
    private int _offsetWidth;
    private int _spacesAfterOffset;
    private boolean _showChars;
    private int _spacesBeforeChars;
    private boolean _replaceNonAscii;
    private char _replacement;

    public HexDump(int n, boolean bl, int n2, int n3, boolean bl2, int n4, boolean bl3, char c) {
        this._bytesPerLine = n;
        this._showOffset = bl;
        this._offset = 0;
        this._offsetWidth = n2;
        this._spacesAfterOffset = n3;
        this._showChars = bl2;
        this._spacesBeforeChars = n4;
        this._replaceNonAscii = bl3;
        this._replacement = c;
    }

    public HexDump() {
        this(16, true, 8, 2, true, 4, true, ' ');
    }

    public void setOffset(int n) {
        this._offset = n;
    }

    public Iterator<String> iterator(byte[] byArray) {
        return this.iterator(byArray, 0, byArray.length);
    }

    public Iterator<String> iterator(byte[] byArray, int n, int n2) {
        return new Dumper(byArray, n, n2);
    }

    public String stringValue(byte[] byArray) {
        return this.stringValue(byArray, 0, byArray.length);
    }

    public String stringValue(byte[] byArray, int n, int n2) {
        int n3 = (n2 / this._bytesPerLine + 1) * (1 + this._offsetWidth + this._spacesAfterOffset + 4 * this._bytesPerLine);
        StringBuilder stringBuilder = new StringBuilder(n3);
        Iterator<String> iterator2 = this.iterator(byArray, n, n2);
        while (iterator2.hasNext()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(iterator2.next());
        }
        return stringBuilder.toString();
    }

    public void write(PrintWriter printWriter, byte[] byArray) {
        this.write(printWriter, byArray, 0, byArray.length);
    }

    public void write(PrintWriter printWriter, byte[] byArray, int n, int n2) {
        Iterator<String> iterator2 = this.iterator(byArray, n, n2);
        while (iterator2.hasNext()) {
            printWriter.println(iterator2.next());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class Dumper
    implements Iterator<String> {
        private byte[] _buf;
        private int _off;
        private int _len;
        private int _lenThisTime;

        public Dumper(byte[] byArray, int n, int n2) {
            this._buf = byArray;
            this._off = n;
            this._len = n2;
        }

        @Override
        public boolean hasNext() {
            return this._len > 0;
        }

        @Override
        public String next() {
            StringBuilder stringBuilder = new StringBuilder();
            if (HexDump.this._showOffset) {
                this.appendOffset(stringBuilder);
            }
            this.appendBytes(stringBuilder);
            if (HexDump.this._showChars) {
                this.appendChars(stringBuilder);
            }
            this.updateOffsets();
            return stringBuilder.toString();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("this iterator isn't backed by a collection");
        }

        private void appendOffset(StringBuilder stringBuilder) {
            StringBuilderUtil.appendHex(stringBuilder, HexDump.this._offset, HexDump.this._offsetWidth);
            StringBuilderUtil.appendRepeat(stringBuilder, ' ', HexDump.this._spacesAfterOffset);
        }

        private void appendBytes(StringBuilder stringBuilder) {
            this._lenThisTime = Math.min(HexDump.this._bytesPerLine, this._len);
            for (int i = 0; i < this._lenThisTime; ++i) {
                if (i > 0) {
                    stringBuilder.append(' ');
                }
                StringBuilderUtil.appendHex(stringBuilder, this._buf[this._off + i], 2);
            }
        }

        private void appendChars(StringBuilder stringBuilder) {
            int n = (HexDump.this._bytesPerLine - this._lenThisTime) * 3 + HexDump.this._spacesBeforeChars;
            StringBuilderUtil.appendRepeat(stringBuilder, ' ', n);
            for (int i = 0; i < this._lenThisTime; ++i) {
                byte by = this._buf[this._off + i];
                if (HexDump.this._replaceNonAscii && (by < 32 || by > 126)) {
                    stringBuilder.append(HexDump.this._replacement);
                    continue;
                }
                stringBuilder.append((char)(by & 0xFF));
            }
        }

        private void updateOffsets() {
            HexDump.this._offset += this._lenThisTime;
            this._off += this._lenThisTime;
            this._len -= this._lenThisTime;
        }
    }
}

