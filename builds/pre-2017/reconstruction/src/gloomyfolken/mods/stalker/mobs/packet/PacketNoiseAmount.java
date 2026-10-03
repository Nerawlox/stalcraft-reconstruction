/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.player.MutantPlayerData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class PacketNoiseAmount
extends zwat {
    public float noiseAmount;

    public PacketNoiseAmount(float f) {
        this.noiseAmount = f;
    }

    @Override
    public void processClient(boolean bl) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP != null) {
            MutantPlayerData.get(entityClientPlayerMP).getSoundSource().setNoiseAmount(this.noiseAmount);
        }
    }

    public PacketNoiseAmount() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.noiseAmount = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.noiseAmount);
    }
}

