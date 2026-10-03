/*
 * Decompiled with CFR 0.152.
 */
package argo.saj;

import argo.saj.ThingWithPosition;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

final class PositionTrackingPushbackReader
implements ThingWithPosition {
    private static final int NEWLINE = 10;
    private static final int CARRIAGE_RETURN = 13;
    private final PushbackReader pushbackReader;
    private int characterCount = 0;
    private int lineCount = 1;
    private boolean lastCharacterWasCarriageReturn = false;

    public PositionTrackingPushbackReader(Reader in) {
        this.pushbackReader = new PushbackReader(in);
    }

    public void unread(char c) throws IOException {
        --this.characterCount;
        if (this.characterCount < 0) {
            this.characterCount = 0;
        }
        this.pushbackReader.unread(c);
    }

    public void uncount(char[] resultCharArray) throws IOException {
        this.characterCount -= resultCharArray.length;
        if (this.characterCount < 0) {
            this.characterCount = 0;
        }
    }

    public int read() throws IOException {
        int result2 = this.pushbackReader.read();
        this.updateCharacterAndLineCounts(result2);
        return result2;
    }

    public int read(char[] buffer) throws IOException {
        int result2 = this.pushbackReader.read(buffer);
        for (char character : buffer) {
            this.updateCharacterAndLineCounts(character);
        }
        return result2;
    }

    private void updateCharacterAndLineCounts(int result2) {
        if (13 == result2) {
            this.characterCount = 0;
            ++this.lineCount;
            this.lastCharacterWasCarriageReturn = true;
        } else {
            if (10 == result2 && !this.lastCharacterWasCarriageReturn) {
                this.characterCount = 0;
                ++this.lineCount;
            } else {
                ++this.characterCount;
            }
            this.lastCharacterWasCarriageReturn = false;
        }
    }

    @Override
    public int getColumn() {
        return this.characterCount;
    }

    @Override
    public int getRow() {
        return this.lineCount;
    }

    public ThingWithPosition snapshotOfPosition() {
        return new ThingWithPosition(){
            private final int localCharacterCount;
            private final int localLineCount;
            {
                this.localCharacterCount = PositionTrackingPushbackReader.this.characterCount;
                this.localLineCount = PositionTrackingPushbackReader.this.lineCount;
            }

            @Override
            public int getColumn() {
                return this.localCharacterCount;
            }

            @Override
            public int getRow() {
                return this.localLineCount;
            }
        };
    }
}

