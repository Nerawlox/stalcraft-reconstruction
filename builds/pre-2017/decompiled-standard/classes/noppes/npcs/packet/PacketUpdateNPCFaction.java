/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.Faction;

public class PacketUpdateNPCFaction
extends zwat {
    private int entityId;
    private qoac factionData;

    public PacketUpdateNPCFaction(int n, Faction faction) {
        this.entityId = n;
        this.factionData = faction.writeNBT(new qoac());
    }

    @Override
    public void processClient(boolean bl) {
        xpzm xpzm2 = xpzm._E();
        Entity entity = xpzm2._r.func_73045_a(this.entityId);
        if (entity instanceof EntityNPCInterface) {
            Faction faction = new Faction();
            faction.readNBT(this.factionData);
            ((EntityNPCInterface)entity).clientFaction = faction;
            ((EntityNPCInterface)entity).advanced.factionId = faction.id;
        }
    }

    public PacketUpdateNPCFaction() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.factionData = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        qlgf.writeNBTTagCompound(this.factionData, dataOutput);
    }
}

