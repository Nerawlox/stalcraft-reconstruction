/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class hbom
extends FilterInputStream
implements DataInput {
    private DataInputStream _a;

    public hbom(InputStream inputStream) {
        super(inputStream);
        this._a = new DataInputStream(inputStream);
    }

    @Override
    public void readFully(byte[] byArray) throws IOException {
        this._a.readFully(byArray);
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) throws IOException {
        this._a.readFully(byArray, n, n2);
    }

    @Override
    public int skipBytes(int n) throws IOException {
        return this._a.skipBytes(n);
    }

    @Override
    public boolean readBoolean() throws IOException {
        return this._a.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return this._a.readByte();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        return this._a.readUnsignedByte();
    }

    @Override
    public short readShort() throws IOException {
        int n = this._a.read();
        int n2 = this._a.read();
        return (short)(n2 << 8 | n & 0xFF);
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int n = this._a.read();
        int n2 = this._a.read();
        return (n2 & 0xFF) << 8 | n & 0xFF;
    }

    @Override
    public char readChar() throws IOException {
        return this._a.readChar();
    }

    @Override
    public int readInt() throws IOException {
        int[] nArray = new int[4];
        for (int i = 3; i >= 0; --i) {
            nArray[i] = this._a.read();
        }
        return (nArray[0] & 0xFF) << 24 | (nArray[1] & 0xFF) << 16 | (nArray[2] & 0xFF) << 8 | nArray[3] & 0xFF;
    }

    @Override
    public long readLong() throws IOException {
        int[] nArray = new int[8];
        for (int i = 7; i >= 0; --i) {
            nArray[i] = this._a.read();
        }
        return (long)(nArray[0] & 0xFF) << 56 | (long)(nArray[1] & 0xFF) << 48 | (long)(nArray[2] & 0xFF) << 40 | (long)(nArray[3] & 0xFF) << 32 | (long)(nArray[4] & 0xFF) << 24 | (long)(nArray[5] & 0xFF) << 16 | (long)(nArray[6] & 0xFF) << 8 | (long)(nArray[7] & 0xFF);
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public final String readLine() throws IOException {
        return this._a.readLine();
    }

    @Override
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }
}

