/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ek
 *  ez
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class el
extends ey {
    private int[] c;
    private int[] d;
    public int[] a;
    public int[] b;
    private byte[] e;
    private byte[][] f;
    private int g;
    private boolean h;
    private static byte[] i = new byte[0];
    private int maxLen = 0;
    private Semaphore deflateGate;

    public el() {
    }

    public el(List par1List) {
        int i2 = par1List.size();
        this.c = new int[i2];
        this.d = new int[i2];
        this.a = new int[i2];
        this.b = new int[i2];
        this.f = new byte[i2][];
        this.h = !par1List.isEmpty() && !((adr)par1List.get((int)0)).e.t.g;
        int j2 = 0;
        for (int k = 0; k < i2; ++k) {
            adr chunk = (adr)par1List.get(k);
            ek packet51mapchunkdata = ej.a(chunk, true, 65535);
            j2 += packet51mapchunkdata.a.length;
            this.c[k] = chunk.g;
            this.d[k] = chunk.h;
            this.a[k] = packet51mapchunkdata.b;
            this.b[k] = packet51mapchunkdata.c;
            this.f[k] = packet51mapchunkdata.a;
        }
        this.deflateGate = new Semaphore(1);
        this.maxLen = j2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deflate() {
        byte[] data = new byte[this.maxLen];
        int offset = 0;
        for (int x2 = 0; x2 < this.f.length; ++x2) {
            System.arraycopy(this.f[x2], 0, data, offset, this.f[x2].length);
            offset += this.f[x2].length;
        }
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(data, 0, this.maxLen);
            deflater.finish();
            byte[] deflated = new byte[this.maxLen];
            this.g = deflater.deflate(deflated);
            this.e = deflated;
        }
        finally {
            deflater.end();
        }
    }

    @Override
    public void a(DataInput par1DataInput) throws IOException {
        int short1 = par1DataInput.readShort();
        this.g = par1DataInput.readInt();
        this.h = par1DataInput.readBoolean();
        this.c = new int[short1];
        this.d = new int[short1];
        this.a = new int[short1];
        this.b = new int[short1];
        this.f = new byte[short1][];
        if (i.length < this.g) {
            i = new byte[this.g];
        }
        par1DataInput.readFully(i, 0, this.g);
        byte[] abyte = new byte[196864 * short1];
        Inflater inflater = new Inflater();
        inflater.setInput(i, 0, this.g);
        try {
            inflater.inflate(abyte);
        }
        catch (DataFormatException dataformatexception) {
            throw new IOException("Bad compressed data format");
        }
        finally {
            inflater.end();
        }
        int i2 = 0;
        for (int j2 = 0; j2 < short1; ++j2) {
            int i1;
            this.c[j2] = par1DataInput.readInt();
            this.d[j2] = par1DataInput.readInt();
            this.a[j2] = par1DataInput.readShort();
            this.b[j2] = par1DataInput.readShort();
            int k = 0;
            int l2 = 0;
            for (i1 = 0; i1 < 16; ++i1) {
                k += this.a[j2] >> i1 & 1;
                l2 += this.b[j2] >> i1 & 1;
            }
            i1 = 8192 * k + 256;
            i1 += 2048 * l2;
            if (this.h) {
                i1 += 2048 * k;
            }
            this.f[j2] = new byte[i1];
            System.arraycopy(abyte, i2, this.f[j2], 0, i1);
            i2 += i1;
        }
    }

    @Override
    public void a(DataOutput par1DataOutput) throws IOException {
        if (this.e == null) {
            this.deflateGate.acquireUninterruptibly();
            if (this.e == null) {
                this.deflate();
            }
            this.deflateGate.release();
        }
        par1DataOutput.writeShort(this.c.length);
        par1DataOutput.writeInt(this.g);
        par1DataOutput.writeBoolean(this.h);
        par1DataOutput.write(this.e, 0, this.g);
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            par1DataOutput.writeInt(this.c[i2]);
            par1DataOutput.writeInt(this.d[i2]);
            par1DataOutput.writeShort((short)(this.a[i2] & 0xFFFF));
            par1DataOutput.writeShort((short)(this.b[i2] & 0xFFFF));
        }
    }

    @Override
    public void a(ez par1NetHandler) {
        par1NetHandler.a(this);
    }

    @Override
    public int a() {
        return 6 + this.g + 12 * this.d();
    }

    @SideOnly(value=Side.CLIENT)
    public int a(int par1) {
        return this.c[par1];
    }

    @SideOnly(value=Side.CLIENT)
    public int b(int par1) {
        return this.d[par1];
    }

    public int d() {
        return this.c.length;
    }

    @SideOnly(value=Side.CLIENT)
    public byte[] c(int par1) {
        return this.f[par1];
    }
}

