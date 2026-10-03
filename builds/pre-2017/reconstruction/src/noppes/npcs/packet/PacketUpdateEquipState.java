/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.RandomEquipState;

public class PacketUpdateEquipState
extends zwat {
    public int entityId;
    public RandomEquipState equipState;

    public PacketUpdateEquipState(int n, RandomEquipState randomEquipState) {
        this.entityId = n;
        this.equipState = randomEquipState;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        bsvf._a(this.equipState.writeToNbt(new NBTTagCompound()), dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.equipState = new RandomEquipState();
        NBTTagCompound nBTTagCompound = bsvf._a(dataInput);
        this.equipState.readFromNbt(nBTTagCompound);
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity = Minecraft._E()._r.getEntityByID(this.entityId);
        if (entity instanceof EntityNPCInterface) {
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
            entityNPCInterface.randomEquipState = this.equipState;
            entityNPCInterface.textureLocation = null;
        }
    }

    public PacketUpdateEquipState() {
    }
}

