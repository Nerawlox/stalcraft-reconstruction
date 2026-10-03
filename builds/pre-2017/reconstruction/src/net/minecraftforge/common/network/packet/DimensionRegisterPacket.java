/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network.packet;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.network.ForgePacket;

public class DimensionRegisterPacket
extends ForgePacket {
    public int dimensionId;
    public int providerId;

    public DimensionRegisterPacket() {
    }

    public DimensionRegisterPacket(int n, int n2) {
        this.dimensionId = n;
        this.providerId = n2;
    }

    @Override
    public byte[] generatePacket() {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt(this.dimensionId);
        byteArrayDataOutput.writeInt(this.providerId);
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public ForgePacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        this.dimensionId = byteArrayDataInput.readInt();
        this.providerId = byteArrayDataInput.readInt();
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, EntityPlayer entityPlayer) {
        if (!(entityPlayer instanceof EntityPlayerMP) && !DimensionManager.isDimensionRegistered(this.dimensionId)) {
            DimensionManager.registerDimension(this.dimensionId, this.providerId);
        }
    }
}

