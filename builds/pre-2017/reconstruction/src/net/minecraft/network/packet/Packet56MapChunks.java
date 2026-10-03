/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

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
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.chunk.Chunk;

public class Packet56MapChunks
extends Packet {
    public int[] chunkPostX;
    public int[] chunkPosZ;
    public int[] field_73590_a;
    public int[] field_73588_b;
    public byte[] chunkDataBuffer;
    public byte[][] field_73584_f;
    public int dataLength;
    public boolean skyLightSent;
    public static byte[] chunkDataNotCompressed = new byte[0];
    public int maxLen = 0;
    public Semaphore deflateGate;

    public Packet56MapChunks() {
    }

    public Packet56MapChunks(List list2) {
        int n = list2.size();
        this.chunkPostX = new int[n];
        this.chunkPosZ = new int[n];
        this.field_73590_a = new int[n];
        this.field_73588_b = new int[n];
        this.field_73584_f = new byte[n][];
        this.skyLightSent = !list2.isEmpty() && !((Chunk)list2.get((int)0))._g.provider._g;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            Chunk chunk = (Chunk)list2.get(i);
            ujsw ujsw2 = ujsv._a(chunk, true, 65535);
            n2 += ujsw2._a.length;
            this.chunkPostX[i] = chunk._i;
            this.chunkPosZ[i] = chunk._j;
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
            this.dataLength = deflater.deflate(byArray2);
            this.chunkDataBuffer = byArray2;
        }
        finally {
            deflater.end();
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) throws IOException {
        int n = dataInput.readShort();
        this.dataLength = dataInput.readInt();
        this.skyLightSent = dataInput.readBoolean();
        this.chunkPostX = new int[n];
        this.chunkPosZ = new int[n];
        this.field_73590_a = new int[n];
        this.field_73588_b = new int[n];
        this.field_73584_f = new byte[n][];
        if (chunkDataNotCompressed.length < this.dataLength) {
            chunkDataNotCompressed = new byte[this.dataLength];
        }
        dataInput.readFully(chunkDataNotCompressed, 0, this.dataLength);
        byte[] byArray = new byte[196864 * n];
        Inflater inflater = new Inflater();
        inflater.setInput(chunkDataNotCompressed, 0, this.dataLength);
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
            this.chunkPostX[i] = dataInput.readInt();
            this.chunkPosZ[i] = dataInput.readInt();
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
            if (this.skyLightSent) {
                n3 += 2048 * n4;
            }
            this.field_73584_f[i] = new byte[n3];
            System.arraycopy(byArray, n2, this.field_73584_f[i], 0, n3);
            n2 += n3;
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) throws IOException {
        if (this.chunkDataBuffer == null) {
            this.deflateGate.acquireUninterruptibly();
            if (this.chunkDataBuffer == null) {
                this.deflate();
            }
            this.deflateGate.release();
        }
        dataOutput.writeShort(this.chunkPostX.length);
        dataOutput.writeInt(this.dataLength);
        dataOutput.writeBoolean(this.skyLightSent);
        dataOutput.write(this.chunkDataBuffer, 0, this.dataLength);
        for (int i = 0; i < this.chunkPostX.length; ++i) {
            dataOutput.writeInt(this.chunkPostX[i]);
            dataOutput.writeInt(this.chunkPosZ[i]);
            dataOutput.writeShort((short)(this.field_73590_a[i] & 0xFFFF));
            dataOutput.writeShort((short)(this.field_73588_b[i] & 0xFFFF));
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMapChunks(this);
    }

    @Override
    public int getPacketSize() {
        return 6 + this.dataLength + 12 * this.getNumberOfChunkInPacket();
    }

    @SideOnly(value=Side.CLIENT)
    public int getChunkPosX(int n) {
        return this.chunkPostX[n];
    }

    @SideOnly(value=Side.CLIENT)
    public int getChunkPosZ(int n) {
        return this.chunkPosZ[n];
    }

    public int getNumberOfChunkInPacket() {
        return this.chunkPostX.length;
    }

    @SideOnly(value=Side.CLIENT)
    public byte[] getChunkCompressedData(int n) {
        return this.field_73584_f[n];
    }
}

