/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.util.ResourceLocation;

public class MicInputStream
extends InputStream {
    private InputStream _a;
    private int _b = 0;
    private boolean _c;
    private final byte[] _d = new byte[]{80, 78, 71};
    private final byte[] _e = new byte[]{77, 73, 67};

    public MicInputStream(ResourceLocation resourceLocation, InputStream inputStream) {
        this._a = inputStream;
        this._c = resourceLocation.getResourcePath().matches(".*\\.[mM][iI][cC]$");
    }

    public MicInputStream(File file, InputStream inputStream) {
        this._a = inputStream;
        this._c = file.getName().toLowerCase().endsWith("mic");
    }

    @Override
    public int read() throws IOException {
        int n = this._a.read();
        if (n > -1) {
            if (this._c && this._b > 0 && this._b < 4) {
                return this._d[this._b - 1];
            }
            ++this._b;
        }
        return n;
    }

    @Override
    public int available() throws IOException {
        return this._a.available();
    }

    @Override
    public void close() throws IOException {
        this._a.close();
    }

    @Override
    public void mark(int n) {
        this._a.mark(n);
    }

    @Override
    public boolean markSupported() {
        return this._a.markSupported();
    }

    @Override
    public int read(byte[] byArray) throws IOException {
        int n = this._a.read(byArray);
        if (this._c) {
            for (int i = 0; i < n && i < 4; ++i) {
                int n2;
                if (i + this._b <= 0 || i + this._b >= 4 || (n2 = i) <= -1 || byArray.length <= n2) continue;
                byArray[n2] = this._d[i - 1 + this._b];
            }
        }
        this._b += n;
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this._a.read(byArray, n, n2);
        if (this._c && this._b < 4) {
            for (int i = 0; i < n3 && i < 4; ++i) {
                int n4;
                if (i + this._b <= 0 || i + this._b >= 4 || (n4 = i + n) <= -1 || byArray.length <= n4) continue;
                byArray[n4] = this._d[i - 1 + this._b];
            }
        }
        this._b += n3;
        return n3;
    }

    @Override
    public void reset() throws IOException {
        this._a.reset();
    }

    @Override
    public long skip(long l) throws IOException {
        this._b = (int)((long)this._b + l);
        return this._a.skip(l);
    }
}

