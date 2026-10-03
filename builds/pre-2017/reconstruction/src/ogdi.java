/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataOutput;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import net.minecraft.util.sajh;

public class ogdi
extends FilterOutputStream
implements DataOutput {
    public ogdi(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void write(int n) throws IOException {
        this.out.write(n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.out.write(byArray, n, n2);
    }

    @Override
    public void writeBoolean(boolean bl) throws IOException {
        if (bl) {
            this.write(1);
        } else {
            this.write(0);
        }
    }

    @Override
    public void writeByte(int n) throws IOException {
        this.out.write(n);
    }

    @Override
    public void writeShort(int n) throws IOException {
        this.out.write(n & 0xFF);
        this.out.write(n >>> 8 & 0xFF);
    }

    @Override
    public void writeChar(int n) throws IOException {
        this.out.write(n & 0xFF);
        this.out.write(n >>> 8 & 0xFF);
    }

    @Override
    public void writeInt(int n) throws IOException {
        this.out.write(n & 0xFF);
        this.out.write(n >>> 8 & 0xFF);
        this.out.write(n >>> 16 & 0xFF);
        this.out.write(n >>> 24 & 0xFF);
    }

    @Override
    public void writeLong(long l) throws IOException {
        this.out.write((int)l & 0xFF);
        this.out.write((int)(l >>> 8) & 0xFF);
        this.out.write((int)(l >>> 16) & 0xFF);
        this.out.write((int)(l >>> 24) & 0xFF);
        this.out.write((int)(l >>> 32) & 0xFF);
        this.out.write((int)(l >>> 40) & 0xFF);
        this.out.write((int)(l >>> 48) & 0xFF);
        this.out.write((int)(l >>> 56) & 0xFF);
    }

    @Override
    public void writeFloat(float f) throws IOException {
        this.writeInt(Float.floatToIntBits(f));
    }

    @Override
    public void writeDouble(double d) throws IOException {
        this.writeLong(Double.doubleToLongBits(d));
    }

    @Override
    public void writeBytes(String string) throws IOException {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            this.out.write((byte)string.charAt(i));
        }
    }

    @Override
    public void writeChars(String string) throws IOException {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            this.out.write(c & 0xFF);
            this.out.write(c >>> 8 & 0xFF);
        }
    }

    public void _a(float f, float f2) throws IOException {
        this.writeShort((int)(32767.0f * sajh._a(f / f2, -1.0f, 1.0f)));
    }

    public void _b(float f, float f2) throws IOException {
        this.writeShort((int)(65535.0f * sajh._a(f / f2, 0.0f, 1.0f)));
    }

    public void _c(float f, float f2) throws IOException {
        this.writeByte((int)(127.0f * sajh._a(f / f2, -1.0f, 1.0f)));
    }

    public void _d(float f, float f2) throws IOException {
        this.writeByte((int)(255.0f * sajh._a(f / f2, 0.0f, 1.0f)));
    }

    @Override
    public void writeUTF(String string) throws IOException {
        char c;
        int n;
        int n2 = string.length();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            c = string.charAt(n);
            if (c >= '\u0001' && c <= '\u007f') {
                ++n3;
                continue;
            }
            if (c > '\u07ff') {
                n3 += 3;
                continue;
            }
            n3 += 2;
        }
        if (n3 > 65535) {
            throw new UTFDataFormatException();
        }
        this.writeShort(n3);
        for (n = 0; n < n2; ++n) {
            c = string.charAt(n);
            if (c >= '\u0001' && c <= '\u007f') {
                this.out.write(c);
                continue;
            }
            if (c > '\u07ff') {
                this.out.write(0xE0 | c >> 12 & 0xF);
                this.out.write(0x80 | c >> 6 & 0x3F);
                this.out.write(0x80 | c & 0x3F);
                continue;
            }
            this.out.write(0xC0 | c >> 6 & 0x1F);
            this.out.write(0x80 | c & 0x3F);
        }
    }
}

