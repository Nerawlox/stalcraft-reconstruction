/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.MapDifference;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.UnsignedBytes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.FMLNetworkException;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.NetHandler;

public class ModIdMapPacket
extends FMLPacket {
    private byte[][] partials;

    public ModIdMapPacket() {
        super(FMLPacket.Type.MOD_IDMAP);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        NBTTagList nBTTagList = (NBTTagList)objectArray[0];
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("List", nBTTagList);
        try {
            return bsvf._a(nBTTagCompound);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "A critical error writing the id map", new Object[0]);
            throw new FMLNetworkException(exception);
        }
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n = UnsignedBytes.toInt(byteArrayDataInput.readByte());
        int n2 = UnsignedBytes.toInt(byteArrayDataInput.readByte());
        int n3 = byteArrayDataInput.readInt();
        if (this.partials == null) {
            this.partials = new byte[n2][];
        }
        this.partials[n] = new byte[n3];
        byteArrayDataInput.readFully(this.partials[n]);
        for (int i = 0; i < this.partials.length; ++i) {
            if (this.partials[i] != null) continue;
            return null;
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        byte[] byArray = Bytes.concat(this.partials);
        GameData.initializeServerGate(1);
        try {
            NBTTagCompound nBTTagCompound = bsvf._a(byArray);
            NBTTagList nBTTagList = nBTTagCompound._n("List");
            Set<ItemData> set = GameData.buildWorldItemData(nBTTagList);
            GameData.validateWorldSave(set);
            MapDifference<Integer, ItemData> mapDifference = GameData.gateWorldLoadingForValidation();
            if (mapDifference != null) {
                FMLCommonHandler.instance().disconnectIDMismatch(mapDifference, netHandler, jjpj2);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

