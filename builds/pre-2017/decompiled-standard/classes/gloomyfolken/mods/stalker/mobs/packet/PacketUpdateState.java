/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;

public class PacketUpdateState
extends zwat {
    public int mobId;
    public qoac stateNbt;

    public PacketUpdateState(EntityMutant entityMutant) {
        this.mobId = 0;
        this.stateNbt = new qoac();
        this.mobId = entityMutant.field_70157_k;
        entityMutant.getState().writeNbt(this.stateNbt);
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = xpzm._E()._r.func_73045_a(this.mobId);
        if (entity instanceof EntityMutant) {
            ((EntityMutant)entity).getState().readNbt(this.stateNbt);
        }
    }

    public PacketUpdateState() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.mobId = dataInput.readInt();
        this.stateNbt = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.mobId);
        qlgf.writeNBTTagCompound(this.stateNbt, dataOutput);
    }
}

