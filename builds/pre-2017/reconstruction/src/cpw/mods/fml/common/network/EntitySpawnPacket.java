/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.util.sajh;

public class EntitySpawnPacket
extends FMLPacket {
    public int networkId;
    public int modEntityId;
    public int entityId;
    public double scaledX;
    public double scaledY;
    public double scaledZ;
    public float scaledYaw;
    public float scaledPitch;
    public float scaledHeadYaw;
    public List metadata;
    public int throwerId;
    public double speedScaledX;
    public double speedScaledY;
    public double speedScaledZ;
    public ByteArrayDataInput dataStream;
    public int rawX;
    public int rawY;
    public int rawZ;

    public EntitySpawnPacket() {
        super(FMLPacket.Type.ENTITYSPAWN);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        EntityRegistry.EntityRegistration entityRegistration = (EntityRegistry.EntityRegistration)objectArray[0];
        Entity entity = (Entity)objectArray[1];
        NetworkModHandler networkModHandler = (NetworkModHandler)objectArray[2];
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt(networkModHandler.getNetworkId());
        byteArrayDataOutput.writeInt(entityRegistration.getModEntityId());
        byteArrayDataOutput.writeInt(entity.entityId);
        byteArrayDataOutput.writeInt(sajh._c(entity.posX * 32.0));
        byteArrayDataOutput.writeInt(sajh._c(entity.posY * 32.0));
        byteArrayDataOutput.writeInt(sajh._c(entity.posZ * 32.0));
        byteArrayDataOutput.writeByte((byte)(entity.rotationYaw * 256.0f / 360.0f));
        byteArrayDataOutput.writeByte((byte)(entity.rotationPitch * 256.0f / 360.0f));
        if (entity instanceof EntityLiving) {
            byteArrayDataOutput.writeByte((byte)(((EntityLiving)entity).rotationYawHead * 256.0f / 360.0f));
        } else {
            byteArrayDataOutput.writeByte(0);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            entity.getDataWatcher()._a(dataOutputStream);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        byteArrayDataOutput.write(byteArrayOutputStream.toByteArray());
        if (entity instanceof IThrowableEntity) {
            Entity entity2 = ((IThrowableEntity)((Object)entity)).getThrower();
            byteArrayDataOutput.writeInt(entity2 == null ? entity.entityId : entity2.entityId);
            double d = 3.9;
            double d2 = entity.motionX;
            double d3 = entity.motionY;
            double d4 = entity.motionZ;
            if (d2 < -d) {
                d2 = -d;
            }
            if (d3 < -d) {
                d3 = -d;
            }
            if (d4 < -d) {
                d4 = -d;
            }
            if (d2 > d) {
                d2 = d;
            }
            if (d3 > d) {
                d3 = d;
            }
            if (d4 > d) {
                d4 = d;
            }
            byteArrayDataOutput.writeInt((int)(d2 * 8000.0));
            byteArrayDataOutput.writeInt((int)(d3 * 8000.0));
            byteArrayDataOutput.writeInt((int)(d4 * 8000.0));
        } else {
            byteArrayDataOutput.writeInt(0);
        }
        if (entity instanceof IEntityAdditionalSpawnData) {
            ((IEntityAdditionalSpawnData)((Object)entity)).writeSpawnData(byteArrayDataOutput);
        }
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        this.networkId = byteArrayDataInput.readInt();
        this.modEntityId = byteArrayDataInput.readInt();
        this.entityId = byteArrayDataInput.readInt();
        this.rawX = byteArrayDataInput.readInt();
        this.rawY = byteArrayDataInput.readInt();
        this.rawZ = byteArrayDataInput.readInt();
        this.scaledX = (double)this.rawX / 32.0;
        this.scaledY = (double)this.rawY / 32.0;
        this.scaledZ = (double)this.rawZ / 32.0;
        this.scaledYaw = (float)byteArrayDataInput.readByte() * 360.0f / 256.0f;
        this.scaledPitch = (float)byteArrayDataInput.readByte() * 360.0f / 256.0f;
        this.scaledHeadYaw = (float)byteArrayDataInput.readByte() * 360.0f / 256.0f;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, 27, byArray.length - 27);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            this.metadata = DataWatcher._a(dataInputStream);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        byteArrayDataInput.skipBytes(byArray.length - byteArrayInputStream.available() - 27);
        this.throwerId = byteArrayDataInput.readInt();
        if (this.throwerId != 0) {
            this.speedScaledX = (double)byteArrayDataInput.readInt() / 8000.0;
            this.speedScaledY = (double)byteArrayDataInput.readInt() / 8000.0;
            this.speedScaledZ = (double)byteArrayDataInput.readInt() / 8000.0;
        }
        this.dataStream = byteArrayDataInput;
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        NetworkModHandler networkModHandler = fMLNetworkHandler.findNetworkModHandler(this.networkId);
        ModContainer modContainer = networkModHandler.getContainer();
        EntityRegistry.EntityRegistration entityRegistration = EntityRegistry.instance().lookupModSpawn(modContainer, this.modEntityId);
        if (entityRegistration == null || entityRegistration.getEntityClass() == null) {
            FMLLog.log(Level.WARNING, "Missing mod entity information for %s : %d", modContainer.getModId(), this.modEntityId);
            return;
        }
        Entity entity = FMLCommonHandler.instance().spawnEntityIntoClientWorld(entityRegistration, this);
    }
}

