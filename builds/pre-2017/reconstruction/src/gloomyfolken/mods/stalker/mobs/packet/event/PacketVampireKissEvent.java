/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet.event;

import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.client.effect.VampireKissEffect;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class PacketVampireKissEvent
extends zwat {
    public boolean executing;
    public int bloodsuckerId;

    public PacketVampireKissEvent(int n, boolean bl) {
        this.bloodsuckerId = n;
        this.executing = bl;
    }

    @Override
    public void processClient(boolean bl) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._r != null) {
            jysc jysc2;
            Entity entity = minecraft._r.getEntityByID(this.bloodsuckerId);
            if (entity == null) {
                this.executing = false;
            }
            if ((jysc2 = jysc._H()) != null) {
                jysc2._C()._a(this.executing);
                jysc2._C()._b(this.executing);
                jysc2._C()._a(this.executing ? entity : null);
                if (this.executing) {
                    jysc2._a(new VampireKissEffect("vampirekiss"));
                } else {
                    jysc2._a("vampirekiss");
                }
            }
        }
    }

    public PacketVampireKissEvent() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.executing = dataInput.readBoolean();
        this.bloodsuckerId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this.executing);
        dataOutput.writeInt(this.bloodsuckerId);
    }
}

