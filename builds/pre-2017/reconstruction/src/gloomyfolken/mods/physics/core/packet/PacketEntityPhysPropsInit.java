/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.packet;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.physics.core.EntityPhysicsState;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PacketEntityPhysPropsInit
extends zwat {
    private short bytesWritten = 0;
    private int entityId;
    private byte[] bytes;

    public PacketEntityPhysPropsInit() {
    }

    public PacketEntityPhysPropsInit(EntityPhysicsState entityPhysicsState) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        entityPhysicsState.writeSpawnData(byteArrayDataOutput);
        this.entityId = entityPhysicsState.getEntity().entityId;
        this.bytes = byteArrayDataOutput.toByteArray();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        dataOutput.writeShort(this.bytes.length);
        dataOutput.write(this.bytes);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.bytesWritten = dataInput.readShort();
        this.bytes = new byte[this.bytesWritten];
        dataInput.readFully(this.bytes);
    }

    @Override
    public void processClient(boolean bl) {
        IExtendedEntityProperties iExtendedEntityProperties;
        Entity entity = Minecraft._E()._r.getEntityByID(this.entityId);
        if (entity != null && (iExtendedEntityProperties = entity.getExtendedProperties(EntityPhysicsState.Companion.getATTRIB())) instanceof EntityPhysicsState) {
            EntityPhysicsState entityPhysicsState = (EntityPhysicsState)iExtendedEntityProperties;
            entityPhysicsState.readSpawnData(ByteStreams.newDataInput(this.bytes));
        }
    }
}

