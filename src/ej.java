/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adp
 *  ads
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
import java.util.concurrent.Semaphore;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ej
extends ey {
    public int a;
    public int b;
    public int c;
    public int d;
    private byte[] f;
    private byte[] g;
    public boolean e;
    private int h;
    private static byte[] i = new byte[196864];
    private Semaphore deflateGate;

    public ej() {
        this.s = true;
    }

    public ej(adr par1Chunk, boolean par2, int par3) {
        this.s = true;
        this.a = par1Chunk.g;
        this.b = par1Chunk.h;
        this.e = par2;
        ek packet51mapchunkdata = ej.a(par1Chunk, par2, par3);
        this.d = packet51mapchunkdata.c;
        this.c = packet51mapchunkdata.b;
        this.g = packet51mapchunkdata.a;
        this.deflateGate = new Semaphore(1);
    }

    private void deflate() {
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(this.g, 0, this.g.length);
            deflater.finish();
            byte[] deflated = new byte[this.g.length];
            this.h = deflater.deflate(deflated);
            this.f = deflated;
        }
        finally {
            deflater.end();
        }
    }

    @Override
    public void a(DataInput par1DataInput) throws IOException {
        int j2;
        this.a = par1DataInput.readInt();
        this.b = par1DataInput.readInt();
        this.e = par1DataInput.readBoolean();
        this.c = par1DataInput.readShort();
        this.d = par1DataInput.readShort();
        this.h = par1DataInput.readInt();
        if (i.length < this.h) {
            i = new byte[this.h];
        }
        par1DataInput.readFully(i, 0, this.h);
        int i2 = 0;
        int msb = 0;
        for (j2 = 0; j2 < 16; ++j2) {
            i2 += this.c >> j2 & 1;
            msb += this.d >> j2 & 1;
        }
        j2 = 12288 * i2;
        j2 += 2048 * msb;
        if (this.e) {
            j2 += 256;
        }
        this.g = new byte[j2];
        Inflater inflater = new Inflater();
        inflater.setInput(i, 0, this.h);
        try {
            inflater.inflate(this.g);
        }
        catch (DataFormatException dataformatexception) {
            throw new IOException("Bad compressed data format");
        }
        finally {
            inflater.end();
        }
    }

    @Override
    public void a(DataOutput par1DataOutput) throws IOException {
        if (this.f == null) {
            this.deflateGate.acquireUninterruptibly();
            if (this.f == null) {
                this.deflate();
            }
            this.deflateGate.release();
        }
        par1DataOutput.writeInt(this.a);
        par1DataOutput.writeInt(this.b);
        par1DataOutput.writeBoolean(this.e);
        par1DataOutput.writeShort((short)(this.c & 0xFFFF));
        par1DataOutput.writeShort((short)(this.d & 0xFFFF));
        par1DataOutput.writeInt(this.h);
        par1DataOutput.write(this.f, 0, this.h);
    }

    @Override
    public void a(ez par1NetHandler) {
        par1NetHandler.a(this);
    }

    @Override
    public int a() {
        return 17 + this.h;
    }

    public static ek a(adr par0Chunk, boolean par1, int par2) {
        adp nibblearray;
        int l2;
        int j2 = 0;
        ads[] aextendedblockstorage = par0Chunk.i();
        int k = 0;
        ek packet51mapchunkdata = new ek();
        byte[] abyte = i;
        if (par1) {
            par0Chunk.o = true;
        }
        for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
            if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || (par2 & 1 << l2) == 0) continue;
            packet51mapchunkdata.b |= 1 << l2;
            if (aextendedblockstorage[l2].i() == null) continue;
            packet51mapchunkdata.c |= 1 << l2;
            ++k;
        }
        for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
            if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || (par2 & 1 << l2) == 0) continue;
            byte[] abyte1 = aextendedblockstorage[l2].g();
            System.arraycopy(abyte1, 0, abyte, j2, abyte1.length);
            j2 += abyte1.length;
        }
        for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
            if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || (par2 & 1 << l2) == 0) continue;
            nibblearray = aextendedblockstorage[l2].j();
            System.arraycopy(nibblearray.a, 0, abyte, j2, nibblearray.a.length);
            j2 += nibblearray.a.length;
        }
        for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
            if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || (par2 & 1 << l2) == 0) continue;
            nibblearray = aextendedblockstorage[l2].k();
            System.arraycopy(nibblearray.a, 0, abyte, j2, nibblearray.a.length);
            j2 += nibblearray.a.length;
        }
        if (!par0Chunk.e.t.g) {
            for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
                if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || (par2 & 1 << l2) == 0) continue;
                nibblearray = aextendedblockstorage[l2].l();
                System.arraycopy(nibblearray.a, 0, abyte, j2, nibblearray.a.length);
                j2 += nibblearray.a.length;
            }
        }
        if (k > 0) {
            for (l2 = 0; l2 < aextendedblockstorage.length; ++l2) {
                if (aextendedblockstorage[l2] == null || par1 && aextendedblockstorage[l2].a() || aextendedblockstorage[l2].i() == null || (par2 & 1 << l2) == 0) continue;
                nibblearray = aextendedblockstorage[l2].i();
                System.arraycopy(nibblearray.a, 0, abyte, j2, nibblearray.a.length);
                j2 += nibblearray.a.length;
            }
        }
        if (par1) {
            byte[] abyte2 = par0Chunk.m();
            System.arraycopy(abyte2, 0, abyte, j2, abyte2.length);
            j2 += abyte2.length;
        }
        packet51mapchunkdata.a = new byte[j2];
        System.arraycopy(abyte, 0, packet51mapchunkdata.a, 0, j2);
        return packet51mapchunkdata;
    }

    @SideOnly(value=Side.CLIENT)
    public byte[] d() {
        return this.g;
    }
}

