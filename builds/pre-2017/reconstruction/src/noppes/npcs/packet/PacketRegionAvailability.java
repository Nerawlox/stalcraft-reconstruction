/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.client.gui.SubGuiNpcAvailability;
import noppes.npcs.controllers.Availability;

public class PacketRegionAvailability
extends zwat {
    public String region;
    public NBTTagCompound data;

    public PacketRegionAvailability(String string, Availability availability) {
        this.region = string;
        this.data = availability.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void processClient(boolean bl) {
        Availability availability = new Availability();
        availability.readFromNBT(this.data);
        Minecraft._E()._a(new SubGuiNpcAvailability(availability).setCloseListener(availability2 -> new PacketRegionAvailability(this.region, availability).sendToServer()));
    }

    public PacketRegionAvailability() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.region = dataInput.readUTF();
        this.data = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.region);
        qlgf.writeNBTTagCompound(this.data, dataOutput);
    }
}

