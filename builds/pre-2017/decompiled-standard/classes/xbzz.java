/*
 * Decompiled with CFR 0.152.
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

public class xbzz
extends cezg {
    public int[] field_73589_c;
    public int[] field_73586_d;
    public int[] field_73590_a;
    public int[] field_73588_b;
    public byte[] field_73587_e;
    public byte[][] field_73584_f;
    public int field_73585_g;
    public boolean field_92076_h;
    public static byte[] field_73591_h = new byte[0];
    public int maxLen = 0;
    public Semaphore deflateGate;

    public xbzz() {
    }

    public xbzz(List list2) {
        int n = list2.size();
        this.field_73589_c = new int[n];
        this.field_73586_d = new int[n];
        this.field_73590_a = new int[n];
        this.field_73588_b = new int[n];
        this.field_73584_f = new byte[n][];
        this.field_92076_h = !list2.isEmpty() && !((ixzi)list2.get((int)0))._g.field_73011_w._g;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            ixzi ixzi2 = (ixzi)list2.get(i);
            ujsw ujsw2 = ujsv._a(ixzi2, true, 65535);
            n2 += ujsw2._a.length;
            this.field_73589_c[i] = ixzi2._i;
            this.field_73586_d[i] = ixzi2._j;
            this.field_73590_a[i] = ujsw2._b;
            this.field_73588_b[i] = ujsw2._c;
            this.field_73584_f[i] = ujsw2._a;
        }
        this.deflateGate = new Semaphore(1);
        this.maxLen = n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deflate() {
        byte[] byArray = new byte[this.maxLen];
        int n = 0;
        for (int i = 0; i < this.field_73584_f.length; ++i) {
            System.arraycopy(this.field_73584_f[i], 0, byArray, n, this.field_73584_f[i].length);
            n += this.field_73584_f[i].length;
        }
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(byArray, 0, this.maxLen);
            deflater.finish();
            byte[] byArray2 = new byte[this.maxLen];
            this.field_73585_g = deflater.deflate(byArray2);
            this.field_73587_e = byArray2;
        }
        finally {
            deflater.end();
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        int n = dataInput.readShort();
        this.field_73585_g = dataInput.readInt();
        this.field_92076_h = dataInput.readBoolean();
        this.field_73589_c = new int[n];
        this.field_73586_d = new int[n];
        this.field_73590_a = new int[n];
        this.field_73588_b = new int[n];
        this.field_73584_f = new byte[n][];
        if (field_73591_h.length < this.field_73585_g) {
            field_73591_h = new byte[this.field_73585_g];
        }
        dataInput.readFully(field_73591_h, 0, this.field_73585_g);
        byte[] byArray = new byte[196864 * n];
        Inflater inflater = new Inflater();
        inflater.setInput(field_73591_h, 0, this.field_73585_g);
        try {
            inflater.inflate(byArray);
        }
        catch (DataFormatException dataFormatException) {
            throw new IOException("Bad compressed data format");
        }
        finally {
            inflater.end();
        }
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3;
            this.field_73589_c[i] = dataInput.readInt();
            this.field_73586_d[i] = dataInput.readInt();
            this.field_73590_a[i] = dataInput.readShort();
            this.field_73588_b[i] = dataInput.readShort();
            int n4 = 0;
            int n5 = 0;
            for (n3 = 0; n3 < 16; ++n3) {
                n4 += this.field_73590_a[i] >> n3 & 1;
                n5 += this.field_73588_b[i] >> n3 & 1;
            }
            n3 = 8192 * n4 + 256;
            n3 += 2048 * n5;
            if (this.field_92076_h) {
                n3 += 2048 * n4;
            }
            this.field_73584_f[i] = new byte[n3];
            System.arraycopy(byArray, n2, this.field_73584_f[i], 0, n3);
            n2 += n3;
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        if (this.field_73587_e == null) {
            this.deflateGate.acquireUninterruptibly();
            if (this.field_73587_e == null) {
                this.deflate();
            }
            this.deflateGate.release();
        }
        dataOutput.writeShort(this.field_73589_c.length);
        dataOutput.writeInt(this.field_73585_g);
        dataOutput.writeBoolean(this.field_92076_h);
        dataOutput.write(this.field_73587_e, 0, this.field_73585_g);
        for (int i = 0; i < this.field_73589_c.length; ++i) {
            dataOutput.writeInt(this.field_73589_c[i]);
            dataOutput.writeInt(this.field_73586_d[i]);
            dataOutput.writeShort((short)(this.field_73590_a[i] & 0xFFFF));
            dataOutput.writeShort((short)(this.field_73588_b[i] & 0xFFFF));
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72453_a(this);
    }

    @Override
    public int func_73284_a() {
        return 6 + this.field_73585_g + 12 * this.func_73581_d();
    }

    @SideOnly(value=Side.CLIENT)
    public int func_73582_a(int n) {
        return this.field_73589_c[n];
    }

    @SideOnly(value=Side.CLIENT)
    public int func_73580_b(int n) {
        return this.field_73586_d[n];
    }

    public int func_73581_d() {
        return this.field_73589_c.length;
    }

    @SideOnly(value=Side.CLIENT)
    public byte[] func_73583_c(int n) {
        return this.field_73584_f[n];
    }
}

