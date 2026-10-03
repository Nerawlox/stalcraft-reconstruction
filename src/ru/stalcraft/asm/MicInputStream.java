/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 */
package ru.stalcraft.asm;

import java.io.IOException;
import java.io.InputStream;

public class MicInputStream
extends InputStream {
    private InputStream baseStream;
    private int byteReading = 0;
    private boolean isReadingMic;
    private final byte[] png = new byte[]{80, 78, 71};
    private final byte[] mic = new byte[]{77, 73, 67};

    public MicInputStream(bjo loc, InputStream baseStream) {
        this.baseStream = baseStream;
        this.isReadingMic = loc.a().matches(".*\\.[mM][iI][cC]$");
    }

    @Override
    public int read() throws IOException {
        int value = this.baseStream.read();
        if (value > -1) {
            if (this.isReadingMic && this.byteReading > 0 && this.byteReading < 4) {
                return this.png[this.byteReading - 1];
            }
            ++this.byteReading;
        }
        return value;
    }

    @Override
    public int available() throws IOException {
        return this.baseStream.available();
    }

    @Override
    public void close() throws IOException {
        this.baseStream.close();
    }

    @Override
    public void mark(int readLimit) {
        this.baseStream.mark(readLimit);
    }

    @Override
    public boolean markSupported() {
        return this.baseStream.markSupported();
    }

    @Override
    public int read(byte[] b2) throws IOException {
        int value = this.baseStream.read(b2);
        if (this.isReadingMic) {
            for (int i2 = 0; i2 < value && i2 < 4; ++i2) {
                if (i2 + this.byteReading <= 0 || i2 + this.byteReading >= 4 || i2 <= -1 || b2.length <= i2) continue;
                b2[i2] = this.png[i2 - 1 + this.byteReading];
            }
        }
        this.byteReading += value;
        return value;
    }

    @Override
    public int read(byte[] b2, int off, int len) throws IOException {
        int value = this.baseStream.read(b2, off, len);
        if (this.isReadingMic && this.byteReading < 4) {
            for (int i2 = 0; i2 < value && i2 < 4; ++i2) {
                int byteToSet;
                if (i2 + this.byteReading <= 0 || i2 + this.byteReading >= 4 || (byteToSet = i2 + off) <= -1 || b2.length <= byteToSet) continue;
                b2[byteToSet] = this.png[i2 - 1 + this.byteReading];
            }
        }
        this.byteReading += value;
        return value;
    }

    @Override
    public void reset() throws IOException {
        this.baseStream.reset();
    }

    @Override
    public long skip(long n2) throws IOException {
        this.byteReading = (int)((long)this.byteReading + n2);
        return this.baseStream.skip(n2);
    }
}

