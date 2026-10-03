/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;

public class EntitySpawnAdjustmentPacket
extends FMLPacket {
    public int entityId;
    public int serverX;
    public int serverY;
    public int serverZ;

    public EntitySpawnAdjustmentPacket() {
        super(FMLPacket.Type.ENTITYSPAWNADJUSTMENT);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt((Integer)objectArray[0]);
        byteArrayDataOutput.writeInt((Integer)objectArray[1]);
        byteArrayDataOutput.writeInt((Integer)objectArray[2]);
        byteArrayDataOutput.writeInt((Integer)objectArray[3]);
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        this.entityId = byteArrayDataInput.readInt();
        this.serverX = byteArrayDataInput.readInt();
        this.serverY = byteArrayDataInput.readInt();
        this.serverZ = byteArrayDataInput.readInt();
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, elai elai2, String string) {
        FMLCommonHandler.instance().adjustEntityLocationOnClient(this);
    }
}

