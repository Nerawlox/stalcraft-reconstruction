/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet.event;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;

public class PacketGenericEffectEvent
extends zwat {
    public int entitySourceId;
    public String effectId;
    public qoac info;
    public double posX;
    public double posY;
    public double posZ;

    public PacketGenericEffectEvent(Entity entity, String string) {
        this(entity, string, new qoac());
    }

    public PacketGenericEffectEvent(Entity entity, String string, qoac qoac2) {
        if (entity != null) {
            this.setPosition(McExtensionsKt.getPos(entity));
            this.entitySourceId = entity.field_70157_k;
        }
        this.effectId = string;
        this.info = qoac2;
    }

    public PacketGenericEffectEvent setPosition(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
        return this;
    }

    public PacketGenericEffectEvent setPosition(ofbx ofbx2) {
        this.posX = ofbx2._c;
        this.posY = ofbx2._d;
        this.posZ = ofbx2._e;
        return this;
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity;
        pkix pkix2 = xpzm._E()._r;
        if (pkix2 != null && (entity = ((ozlu)pkix2).func_73045_a(this.entitySourceId)) instanceof EntityMutant) {
            ((EntityMutant)entity).receiveGenericEffectEvent(this);
        }
    }

    public PacketGenericEffectEvent() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entitySourceId = dataInput.readInt();
        this.effectId = dataInput.readUTF();
        this.info = qlgf.readNBTTagCompound(dataInput);
        this.posX = dataInput.readDouble();
        this.posY = dataInput.readDouble();
        this.posZ = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entitySourceId);
        dataOutput.writeUTF(this.effectId);
        qlgf.writeNBTTagCompound(this.info, dataOutput);
        dataOutput.writeDouble(this.posX);
        dataOutput.writeDouble(this.posY);
        dataOutput.writeDouble(this.posZ);
    }
}

