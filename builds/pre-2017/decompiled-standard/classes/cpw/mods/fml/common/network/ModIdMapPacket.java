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

public class ModIdMapPacket
extends FMLPacket {
    private byte[][] partials;

    public ModIdMapPacket() {
        super(FMLPacket.Type.MOD_IDMAP);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        bsyv bsyv2 = (bsyv)objectArray[0];
        qoac qoac2 = new qoac();
        qoac2._a("List", bsyv2);
        try {
            return bsvf._a(qoac2);
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
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, elai elai2, String string) {
        byte[] byArray = Bytes.concat(this.partials);
        GameData.initializeServerGate(1);
        try {
            qoac qoac2 = bsvf._a(byArray);
            bsyv bsyv2 = qoac2._n("List");
            Set<ItemData> set = GameData.buildWorldItemData(bsyv2);
            GameData.validateWorldSave(set);
            MapDifference<Integer, ItemData> mapDifference = GameData.gateWorldLoadingForValidation();
            if (mapDifference != null) {
                FMLCommonHandler.instance().disconnectIDMismatch(mapDifference, elai2, jjpj2);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

