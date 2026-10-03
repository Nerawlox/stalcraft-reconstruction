/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.base.Throwables;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.EntitySpawnAdjustmentPacket;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.network.FMLNetworkException;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.ModIdMapPacket;
import cpw.mods.fml.common.network.ModIdentifiersPacket;
import cpw.mods.fml.common.network.ModListRequestPacket;
import cpw.mods.fml.common.network.ModListResponsePacket;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.network.OpenGuiPacket;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import net.minecraft.network.packet.NetHandler;

public abstract class FMLPacket {
    private Type type;

    public static byte[][] makePacketSet(Type type, Object ... objectArray) {
        if (!type.isMultipart()) {
            return new byte[0][];
        }
        byte[] byArray = type.make().generatePacket(objectArray);
        byte[][] byArrayArray = new byte[byArray.length / 32000 + 1][];
        for (int i = 0; i < byArray.length / 32000 + 1; ++i) {
            int n = Math.min(32000, byArray.length - i * 32000);
            byArrayArray[i] = Bytes.concat({UnsignedBytes.checkedCast(type.ordinal()), UnsignedBytes.checkedCast(i), UnsignedBytes.checkedCast(byArrayArray.length)}, Ints.toByteArray(n), Arrays.copyOfRange(byArray, i * 32000, n + i * 32000));
        }
        return byArrayArray;
    }

    public static byte[] makePacket(Type type, Object ... objectArray) {
        byte[] byArray = type.make().generatePacket(objectArray);
        return Bytes.concat({UnsignedBytes.checkedCast(type.ordinal())}, byArray);
    }

    public static FMLPacket readPacket(jjpj jjpj2, byte[] byArray) {
        int n = UnsignedBytes.toInt(byArray[0]);
        Type type = Type.values()[n];
        FMLPacket fMLPacket = type.isMultipart() ? type.findCurrentPart(jjpj2) : type.make();
        return fMLPacket.consumePacket(Arrays.copyOfRange(byArray, 1, byArray.length));
    }

    public FMLPacket(Type type) {
        this.type = type;
    }

    public abstract byte[] generatePacket(Object ... var1);

    public abstract FMLPacket consumePacket(byte[] var1);

    public abstract void execute(jjpj var1, FMLNetworkHandler var2, NetHandler var3, String var4);

    static enum Type {
        MOD_LIST_REQUEST(ModListRequestPacket.class, false),
        MOD_LIST_RESPONSE(ModListResponsePacket.class, false),
        MOD_IDENTIFIERS(ModIdentifiersPacket.class, false),
        MOD_MISSING(ModMissingPacket.class, false),
        GUIOPEN(OpenGuiPacket.class, false),
        ENTITYSPAWN(EntitySpawnPacket.class, false),
        ENTITYSPAWNADJUSTMENT(EntitySpawnAdjustmentPacket.class, false),
        MOD_IDMAP(ModIdMapPacket.class, true);

        private Class<? extends FMLPacket> packetType;
        private boolean isMultipart;
        private ConcurrentMap<jjpj, FMLPacket> partTracker;

        private Type(Class<? extends FMLPacket> clazz, boolean bl) {
            this.packetType = clazz;
            this.isMultipart = bl;
        }

        FMLPacket make() {
            try {
                return this.packetType.newInstance();
            }
            catch (Exception exception) {
                Throwables.propagateIfPossible(exception);
                FMLLog.log(Level.SEVERE, exception, "A bizarre critical error occured during packet encoding", new Object[0]);
                throw new FMLNetworkException(exception);
            }
        }

        public boolean isMultipart() {
            return this.isMultipart;
        }

        private FMLPacket findCurrentPart(jjpj jjpj2) {
            if (this.partTracker == null) {
                this.partTracker = new MapMaker().weakKeys().weakValues().makeMap();
            }
            if (!this.partTracker.containsKey(jjpj2)) {
                this.partTracker.put(jjpj2, this.make());
            }
            return (FMLPacket)this.partTracker.get(jjpj2);
        }
    }
}

