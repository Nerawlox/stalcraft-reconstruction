/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;
import java.util.List;
import net.minecraft.network.packet.NetHandler;

public class ModMissingPacket
extends FMLPacket {
    private List<ModData> missing;
    private List<ModData> badVersion;

    public ModMissingPacket() {
        super(FMLPacket.Type.MOD_MISSING);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        ModContainer modContainer;
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        List list2 = (List)objectArray[0];
        List list3 = (List)objectArray[1];
        byteArrayDataOutput.writeInt(list2.size());
        for (String string : list2) {
            modContainer = Loader.instance().getIndexedModList().get(string);
            byteArrayDataOutput.writeUTF(string);
            byteArrayDataOutput.writeUTF(modContainer.getVersion());
        }
        byteArrayDataOutput.writeInt(list3.size());
        for (String string : list3) {
            modContainer = Loader.instance().getIndexedModList().get(string);
            byteArrayDataOutput.writeUTF(string);
            byteArrayDataOutput.writeUTF(modContainer.getVersion());
        }
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        int n;
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n2 = byteArrayDataInput.readInt();
        this.missing = Lists.newArrayListWithCapacity(n2);
        for (n = 0; n < n2; ++n) {
            ModData modData = new ModData();
            modData.modId = byteArrayDataInput.readUTF();
            modData.modVersion = byteArrayDataInput.readUTF();
            this.missing.add(modData);
        }
        n = byteArrayDataInput.readInt();
        this.badVersion = Lists.newArrayListWithCapacity(n);
        for (int i = 0; i < n; ++i) {
            ModData modData = new ModData();
            modData.modId = byteArrayDataInput.readUTF();
            modData.modVersion = byteArrayDataInput.readUTF();
            this.badVersion.add(modData);
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        FMLCommonHandler.instance().getSidedDelegate().displayMissingMods(this);
    }

    public List<ArtifactVersion> getModList() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (ModData modData : this.missing) {
            builder.add(new DefaultArtifactVersion(modData.modId, VersionRange.createFromVersion(modData.modVersion, null)));
        }
        for (ModData modData : this.badVersion) {
            builder.add(new DefaultArtifactVersion(modData.modId, VersionRange.createFromVersion(modData.modVersion, null)));
        }
        return builder.build();
    }

    private static class ModData {
        String modId;
        String modVersion;

        private ModData() {
        }
    }
}

