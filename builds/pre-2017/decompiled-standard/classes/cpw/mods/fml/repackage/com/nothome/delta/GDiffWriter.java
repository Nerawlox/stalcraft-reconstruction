/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.DiffWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GDiffWriter
implements DiffWriter {
    public static final int CHUNK_SIZE = Short.MAX_VALUE;
    public static final byte EOF = 0;
    public static final int DATA_MAX = 246;
    public static final int DATA_USHORT = 247;
    public static final int DATA_INT = 248;
    public static final int COPY_USHORT_UBYTE = 249;
    public static final int COPY_USHORT_USHORT = 250;
    public static final int COPY_USHORT_INT = 251;
    public static final int COPY_INT_UBYTE = 252;
    public static final int COPY_INT_USHORT = 253;
    public static final int COPY_INT_INT = 254;
    public static final int COPY_LONG_INT = 255;
    private ByteArrayOutputStream buf = new ByteArrayOutputStream();
    private boolean debug = false;
    private DataOutputStream output = null;

    public GDiffWriter(DataOutputStream dataOutputStream) throws IOException {
        this.output = dataOutputStream;
        this.output.writeByte(209);
        this.output.writeByte(255);
        this.output.writeByte(209);
        this.output.writeByte(255);
        this.output.writeByte(4);
    }

    public GDiffWriter(OutputStream outputStream) throws IOException {
        this(new DataOutputStream(outputStream));
    }

    @Override
    public void addCopy(long l, int n) throws IOException {
        this.writeBuf();
        if (this.debug) {
            System.err.println("COPY off: " + l + ", len: " + n);
        }
        if (l > Integer.MAX_VALUE) {
            this.output.writeByte(255);
            this.output.writeLong(l);
            this.output.writeInt(n);
        } else if (l < 65536L) {
            if (n < 256) {
                this.output.writeByte(249);
                this.output.writeShort((int)l);
                this.output.writeByte(n);
            } else if (n > 65535) {
                this.output.writeByte(251);
                this.output.writeShort((int)l);
                this.output.writeInt(n);
            } else {
                this.output.writeByte(250);
                this.output.writeShort((int)l);
                this.output.writeShort(n);
            }
        } else if (n < 256) {
            this.output.writeByte(252);
            this.output.writeInt((int)l);
            this.output.writeByte(n);
        } else if (n > 65535) {
            this.output.writeByte(254);
            this.output.writeInt((int)l);
            this.output.writeInt(n);
        } else {
            this.output.writeByte(253);
            this.output.writeInt((int)l);
            this.output.writeShort(n);
        }
    }

    @Override
    public void addData(byte by) throws IOException {
        this.buf.write(by);
        if (this.buf.size() >= Short.MAX_VALUE) {
            this.writeBuf();
        }
    }

    private void writeBuf() throws IOException {
        if (this.buf.size() > 0) {
            if (this.buf.size() <= 246) {
                this.output.writeByte(this.buf.size());
            } else if (this.buf.size() <= 65535) {
                this.output.writeByte(247);
                this.output.writeShort(this.buf.size());
            } else {
                this.output.writeByte(248);
                this.output.writeInt(this.buf.size());
            }
            this.buf.writeTo(this.output);
            this.buf.reset();
        }
    }

    @Override
    public void flush() throws IOException {
        this.writeBuf();
        this.output.flush();
    }

    @Override
    public void close() throws IOException {
        this.flush();
        this.output.write(0);
        this.output.close();
    }
}

