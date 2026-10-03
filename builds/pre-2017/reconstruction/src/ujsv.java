/*
 * Decompiled with CFR 0.152.
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
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.chunk.Chunk;

public class ujsv
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public byte[] _e;
    public byte[] _f;
    public boolean _g;
    public int _h;
    public static byte[] _i = new byte[196864];
    public Semaphore _j;

    public ujsv() {
        this.isChunkDataPacket = true;
    }

    public ujsv(Chunk chunk, boolean bl, int n) {
        this.isChunkDataPacket = true;
        this._a = chunk._i;
        this._b = chunk._j;
        this._g = bl;
        ujsw ujsw2 = ujsv._a(chunk, bl, n);
        this._d = ujsw2._c;
        this._c = ujsw2._b;
        this._f = ujsw2._a;
        this._j = new Semaphore(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a() {
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(this._f, 0, this._f.length);
            deflater.finish();
            byte[] byArray = new byte[this._f.length];
            this._h = deflater.deflate(byArray);
            this._e = byArray;
        }
        finally {
            deflater.end();
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) throws IOException {
        int n;
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._g = dataInput.readBoolean();
        this._c = dataInput.readShort();
        this._d = dataInput.readShort();
        this._h = dataInput.readInt();
        if (_i.length < this._h) {
            _i = new byte[this._h];
        }
        dataInput.readFully(_i, 0, this._h);
        int n2 = 0;
        int n3 = 0;
        for (n = 0; n < 16; ++n) {
            n2 += this._c >> n & 1;
            n3 += this._d >> n & 1;
        }
        n = 12288 * n2;
        n += 2048 * n3;
        if (this._g) {
            n += 256;
        }
        this._f = new byte[n];
        Inflater inflater = new Inflater();
        inflater.setInput(_i, 0, this._h);
        try {
            inflater.inflate(this._f);
        }
        catch (DataFormatException dataFormatException) {
            throw new IOException("Bad compressed data format");
        }
        finally {
            inflater.end();
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) throws IOException {
        if (this._e == null) {
            this._j.acquireUninterruptibly();
            if (this._e == null) {
                this._a();
            }
            this._j.release();
        }
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeBoolean(this._g);
        dataOutput.writeShort((short)(this._c & 0xFFFF));
        dataOutput.writeShort((short)(this._d & 0xFFFF));
        dataOutput.writeInt(this._h);
        dataOutput.write(this._e, 0, this._h);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMapChunk(this);
    }

    @Override
    public int getPacketSize() {
        return 17 + this._h;
    }

    public static ujsw _a(Chunk chunk, boolean bl, int n) {
        Object object;
        int n2;
        int n3 = 0;
        ujzm[] ujzmArray = chunk._b();
        int n4 = 0;
        ujsw ujsw2 = new ujsw();
        byte[] byArray = _i;
        if (bl) {
            chunk._r = true;
        }
        for (n2 = 0; n2 < ujzmArray.length; ++n2) {
            if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || (n & 1 << n2) == 0) continue;
            ujsw2._b |= 1 << n2;
            if (ujzmArray[n2]._g() == null) continue;
            ujsw2._c |= 1 << n2;
            ++n4;
        }
        for (n2 = 0; n2 < ujzmArray.length; ++n2) {
            if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || (n & 1 << n2) == 0) continue;
            object = ujzmArray[n2]._e();
            System.arraycopy(object, 0, byArray, n3, ((byte[])object).length);
            n3 += ((byte[])object).length;
        }
        for (n2 = 0; n2 < ujzmArray.length; ++n2) {
            if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || (n & 1 << n2) == 0) continue;
            object = ujzmArray[n2]._h();
            System.arraycopy(object._a, 0, byArray, n3, object._a.length);
            n3 += object._a.length;
        }
        for (n2 = 0; n2 < ujzmArray.length; ++n2) {
            if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || (n & 1 << n2) == 0) continue;
            object = ujzmArray[n2]._i();
            System.arraycopy(object._a, 0, byArray, n3, object._a.length);
            n3 += object._a.length;
        }
        if (!chunk._g.provider._g) {
            for (n2 = 0; n2 < ujzmArray.length; ++n2) {
                if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || (n & 1 << n2) == 0) continue;
                object = ujzmArray[n2]._j();
                System.arraycopy(object._a, 0, byArray, n3, object._a.length);
                n3 += object._a.length;
            }
        }
        if (n4 > 0) {
            for (n2 = 0; n2 < ujzmArray.length; ++n2) {
                if (ujzmArray[n2] == null || bl && ujzmArray[n2]._a() || ujzmArray[n2]._g() == null || (n & 1 << n2) == 0) continue;
                object = ujzmArray[n2]._g();
                System.arraycopy(object._a, 0, byArray, n3, object._a.length);
                n3 += object._a.length;
            }
        }
        if (bl) {
            byte[] byArray2 = chunk._l();
            System.arraycopy(byArray2, 0, byArray, n3, byArray2.length);
            n3 += byArray2.length;
        }
        ujsw2._a = new byte[n3];
        System.arraycopy(byArray, 0, ujsw2._a, 0, n3);
        return ujsw2;
    }

    @SideOnly(value=Side.CLIENT)
    public byte[] _b() {
        return this._f;
    }
}

