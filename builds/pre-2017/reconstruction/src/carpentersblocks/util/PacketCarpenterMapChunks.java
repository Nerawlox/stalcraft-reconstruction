/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import carpentersblocks.tileentity.TECarpentersBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.world.chunk.Chunk;

public class PacketCarpenterMapChunks
extends Packet56MapChunks {
    private List<TECarpentersBlock> tiles;

    public PacketCarpenterMapChunks() {
    }

    public PacketCarpenterMapChunks(List<Chunk> list2, List<TECarpentersBlock> list3, boolean bl) {
        super(list2);
        this.tiles = list3;
        if (bl && !list3.isEmpty()) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                this.writeTileData(dataOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.readTileData(dataInputStream);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
    }

    private void readTileData(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this.tiles = new ArrayList<TECarpentersBlock>(n);
        for (int i = 0; i < n; ++i) {
            TECarpentersBlock tECarpentersBlock = new TECarpentersBlock();
            tECarpentersBlock.xCoord = dataInput.readInt();
            tECarpentersBlock.yCoord = dataInput.readUnsignedByte();
            tECarpentersBlock.zCoord = dataInput.readInt();
            tECarpentersBlock.readFromBytes(dataInput);
            this.tiles.add(tECarpentersBlock);
        }
    }

    private void writeTileData(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.tiles.size());
        for (TECarpentersBlock tECarpentersBlock : this.tiles) {
            dataOutput.writeInt(tECarpentersBlock.xCoord);
            dataOutput.writeByte(tECarpentersBlock.yCoord);
            dataOutput.writeInt(tECarpentersBlock.zCoord);
            tECarpentersBlock.writeToBytes(dataOutput);
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) throws IOException {
        super.readPacketData(dataInput);
        this.readTileData(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) throws IOException {
        super.writePacketData(dataOutput);
        this.writeTileData(dataOutput);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void processPacket(NetHandler netHandler) {
        super.processPacket(netHandler);
        pkix pkix2 = Minecraft._E()._r;
        for (TECarpentersBlock tECarpentersBlock : this.tiles) {
            pkix2.getChunkFromBlockCoords(tECarpentersBlock.xCoord, tECarpentersBlock.zCoord)._a(tECarpentersBlock);
        }
    }
}

