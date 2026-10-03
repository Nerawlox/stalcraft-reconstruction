/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.network.ForgePacket;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidIdMapPacket
extends ForgePacket {
    private BiMap<String, Integer> fluidIds = HashBiMap.create();

    @Override
    public byte[] generatePacket() {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt(FluidRegistry.maxID);
        for (Map.Entry entry : FluidRegistry.fluidIDs.entrySet()) {
            byteArrayDataOutput.writeUTF((String)entry.getKey());
            byteArrayDataOutput.writeInt((Integer)entry.getValue());
        }
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public ForgePacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n = byteArrayDataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = byteArrayDataInput.readUTF();
            int n2 = byteArrayDataInput.readInt();
            this.fluidIds.put(string, n2);
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, EntityPlayer entityPlayer) {
        FluidRegistry.initFluidIDs(this.fluidIds);
    }
}

