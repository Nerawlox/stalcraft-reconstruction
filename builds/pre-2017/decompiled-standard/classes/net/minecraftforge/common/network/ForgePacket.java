/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import com.google.common.base.Throwables;
import com.google.common.collect.MapMaker;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.FMLNetworkException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.network.packet.DimensionRegisterPacket;
import net.minecraftforge.fluids.FluidIdMapPacket;

public abstract class ForgePacket {
    public static final String CHANNEL_ID = "FORGE";
    private Type type;
    private byte[][] partials;

    public static jjqf[] makePacketSet(ForgePacket forgePacket) {
        int n;
        byte[] byArray = forgePacket.generatePacket();
        if (byArray.length < 32000) {
            return new jjqf[]{new jjqf(CHANNEL_ID, Bytes.concat({UnsignedBytes.checkedCast(0L), UnsignedBytes.checkedCast(forgePacket.getID())}, byArray))};
        }
        byte[][] byArrayArray = new byte[byArray.length / 32000 + 1][];
        for (int i = 0; i < byArray.length / 32000 + 1; ++i) {
            n = Math.min(32000, byArray.length - i * 32000);
            byArrayArray[i] = Bytes.concat({UnsignedBytes.checkedCast(1L), UnsignedBytes.checkedCast(forgePacket.getID()), UnsignedBytes.checkedCast(i), UnsignedBytes.checkedCast(byArrayArray.length)}, Ints.toByteArray(n), Arrays.copyOfRange(byArray, i * 32000, n + i * 32000));
        }
        jjqf[] jjqfArray = new jjqf[byArrayArray.length];
        for (n = 0; n < byArrayArray.length; ++n) {
            jjqfArray[n] = new jjqf(CHANNEL_ID, byArrayArray[n]);
        }
        return jjqfArray;
    }

    public static ForgePacket readPacket(jjpj jjpj2, byte[] byArray) {
        boolean bl = UnsignedBytes.toInt(byArray[0]) == 1;
        int n = UnsignedBytes.toInt(byArray[1]);
        Type type = Type.values()[n];
        byte[] byArray2 = Arrays.copyOfRange(byArray, 2, byArray.length);
        if (bl) {
            ForgePacket forgePacket = type.consumePart(jjpj2, byArray2);
            if (forgePacket != null) {
                return forgePacket.consumePacket(Bytes.concat(forgePacket.partials));
            }
            return null;
        }
        return type.make().consumePacket(byArray2);
    }

    public ForgePacket() {
        for (Type type : Type.values()) {
            if (type.packetType != this.getClass()) continue;
            this.type = type;
        }
        if (this.type == null) {
            throw new RuntimeException("ForgePacket constructor called on ungregistered type.");
        }
    }

    public byte getID() {
        return UnsignedBytes.checkedCast(this.type.ordinal());
    }

    public abstract byte[] generatePacket();

    public abstract ForgePacket consumePacket(byte[] var1);

    public abstract void execute(jjpj var1, EntityPlayer var2);

    static /* synthetic */ byte[][] access$002(ForgePacket forgePacket, byte[][] byArray) {
        forgePacket.partials = byArray;
        return byArray;
    }

    static enum Type {
        REGISTERDIMENSION(DimensionRegisterPacket.class),
        FLUID_IDMAP(FluidIdMapPacket.class);

        private Class<? extends ForgePacket> packetType;
        private ConcurrentMap<jjpj, ForgePacket> partTracker;

        private Type(Class<? extends ForgePacket> clazz) {
            this.packetType = clazz;
        }

        ForgePacket make() {
            try {
                return this.packetType.newInstance();
            }
            catch (Exception exception) {
                Throwables.propagateIfPossible(exception);
                FMLLog.log(Level.SEVERE, exception, "A bizarre critical error occured during packet encoding", new Object[0]);
                throw new FMLNetworkException(exception);
            }
        }

        private ForgePacket consumePart(jjpj jjpj2, byte[] byArray) {
            if (this.partTracker == null) {
                this.partTracker = new MapMaker().weakKeys().weakValues().makeMap();
            }
            if (!this.partTracker.containsKey(jjpj2)) {
                this.partTracker.put(jjpj2, this.make());
            }
            ForgePacket forgePacket = (ForgePacket)this.partTracker.get(jjpj2);
            ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
            int n = UnsignedBytes.toInt(byteArrayDataInput.readByte());
            int n2 = UnsignedBytes.toInt(byteArrayDataInput.readByte());
            int n3 = byteArrayDataInput.readInt();
            if (forgePacket.partials == null) {
                ForgePacket.access$002(forgePacket, new byte[n2][]);
            }
            ((ForgePacket)forgePacket).partials[n] = new byte[n3];
            byteArrayDataInput.readFully(forgePacket.partials[n]);
            for (int i = 0; i < forgePacket.partials.length; ++i) {
                if (forgePacket.partials[i] != null) continue;
                return null;
            }
            return forgePacket;
        }
    }
}

