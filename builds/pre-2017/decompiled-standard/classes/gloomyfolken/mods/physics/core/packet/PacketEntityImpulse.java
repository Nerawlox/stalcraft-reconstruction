/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.packet;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.physics.core.EntityPhysicsState;
import gloomyfolken.mods.physics.core.PhysicsImpulse;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PacketEntityImpulse
extends zwat {
    public int entityId;
    public float hitX;
    public float hitY;
    public float hitZ;
    public float dirX;
    public float dirY;
    public float dirZ;

    public PacketEntityImpulse(Entity entity, double d, double d2, double d3, double d4, double d5, double d6) {
        this.entityId = entity.field_70157_k;
        this.hitX = (float)d;
        this.hitY = (float)d2;
        this.hitZ = (float)d3;
        this.dirX = (float)d4;
        this.dirY = (float)d5;
        this.dirZ = (float)d6;
    }

    @Override
    public void processClient(boolean bl) {
        InvokeSideOnly.client(() -> {
            PhysicsEntityContext physicsEntityContext;
            Entity entity = xpzm._E()._r.func_73045_a(this.entityId);
            IExtendedEntityProperties iExtendedEntityProperties = entity.getExtendedProperties(EntityPhysicsState.Companion.getATTRIB());
            if (iExtendedEntityProperties instanceof EntityPhysicsState && (physicsEntityContext = ((EntityPhysicsState)iExtendedEntityProperties).getClientPhysicsContext()) != null) {
                physicsEntityContext.applyImpulse(new PhysicsImpulse(this.hitX, this.hitY, this.hitZ, this.dirX, this.dirY, this.dirZ));
            }
        });
    }

    public PacketEntityImpulse() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.hitX = dataInput.readFloat();
        this.hitY = dataInput.readFloat();
        this.hitZ = dataInput.readFloat();
        this.dirX = dataInput.readFloat();
        this.dirY = dataInput.readFloat();
        this.dirZ = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        dataOutput.writeFloat(this.hitX);
        dataOutput.writeFloat(this.hitY);
        dataOutput.writeFloat(this.hitZ);
        dataOutput.writeFloat(this.dirX);
        dataOutput.writeFloat(this.dirY);
        dataOutput.writeFloat(this.dirZ);
    }
}

