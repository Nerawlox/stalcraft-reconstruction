/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.NetHandler;

public class OpenGuiPacket
extends FMLPacket {
    private int windowId;
    private int networkId;
    private int modGuiId;
    private int x;
    private int y;
    private int z;

    public OpenGuiPacket() {
        super(FMLPacket.Type.GUIOPEN);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt((Integer)objectArray[0]);
        byteArrayDataOutput.writeInt((Integer)objectArray[1]);
        byteArrayDataOutput.writeInt((Integer)objectArray[2]);
        byteArrayDataOutput.writeInt((Integer)objectArray[3]);
        byteArrayDataOutput.writeInt((Integer)objectArray[4]);
        byteArrayDataOutput.writeInt((Integer)objectArray[5]);
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        this.windowId = byteArrayDataInput.readInt();
        this.networkId = byteArrayDataInput.readInt();
        this.modGuiId = byteArrayDataInput.readInt();
        this.x = byteArrayDataInput.readInt();
        this.y = byteArrayDataInput.readInt();
        this.z = byteArrayDataInput.readInt();
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        EntityPlayer entityPlayer = netHandler.getPlayer();
        entityPlayer.openGui(this.networkId, this.modGuiId, entityPlayer.worldObj, this.x, this.y, this.z);
        entityPlayer.openContainer.windowId = this.windowId;
    }
}

