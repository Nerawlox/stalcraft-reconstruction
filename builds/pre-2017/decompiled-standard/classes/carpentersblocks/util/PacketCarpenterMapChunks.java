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
import net.minecraft.client.xpzm;

public class PacketCarpenterMapChunks
extends xbzz {
    private List<TECarpentersBlock> tiles;

    public PacketCarpenterMapChunks() {
    }

    public PacketCarpenterMapChunks(List<ixzi> list2, List<TECarpentersBlock> list3, boolean bl) {
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
            tECarpentersBlock.field_70329_l = dataInput.readInt();
            tECarpentersBlock.field_70330_m = dataInput.readUnsignedByte();
            tECarpentersBlock.field_70327_n = dataInput.readInt();
            tECarpentersBlock.readFromBytes(dataInput);
            this.tiles.add(tECarpentersBlock);
        }
    }

    private void writeTileData(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.tiles.size());
        for (TECarpentersBlock tECarpentersBlock : this.tiles) {
            dataOutput.writeInt(tECarpentersBlock.field_70329_l);
            dataOutput.writeByte(tECarpentersBlock.field_70330_m);
            dataOutput.writeInt(tECarpentersBlock.field_70327_n);
            tECarpentersBlock.writeToBytes(dataOutput);
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        super.func_73267_a(dataInput);
        this.readTileData(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        super.func_73273_a(dataOutput);
        this.writeTileData(dataOutput);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_73279_a(elai elai2) {
        super.func_73279_a(elai2);
        pkix pkix2 = xpzm._E()._r;
        for (TECarpentersBlock tECarpentersBlock : this.tiles) {
            pkix2.func_72938_d(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70327_n)._a(tECarpentersBlock);
        }
    }
}

