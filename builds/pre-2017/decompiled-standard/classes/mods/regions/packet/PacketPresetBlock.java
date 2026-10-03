/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import mods.regions.PresetScript;
import mods.regions.client.GuiPresetBlock;
import net.minecraft.client.xpzm;

public class PacketPresetBlock
extends zwat {
    public int x;
    public int y;
    public int z;
    public String presetName;
    public String regionName;

    public PacketPresetBlock(PresetScript presetScript) {
        this((int)presetScript.getPos().x, (int)presetScript.getPos().y, (int)presetScript.getPos().z, presetScript.getScriptName(), presetScript.getTargetRegion());
    }

    public PacketPresetBlock(int n, int n2, int n3, String string, String string2) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.presetName = string;
        this.regionName = string2;
    }

    @Override
    public void processClient(boolean bl) {
        xpzm._E()._a(new GuiPresetBlock(this.x, this.y, this.z, this.presetName, this.regionName));
    }

    public PacketPresetBlock() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.x = dataInput.readInt();
        this.y = dataInput.readInt();
        this.z = dataInput.readInt();
        this.presetName = dataInput.readUTF();
        this.regionName = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.x);
        dataOutput.writeInt(this.y);
        dataOutput.writeInt(this.z);
        dataOutput.writeUTF(this.presetName);
        dataOutput.writeUTF(this.regionName);
    }
}

