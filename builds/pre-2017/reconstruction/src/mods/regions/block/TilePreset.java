/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePreset
extends TileEntity {
    public String presetName = "";
    public String targetRegion = "";

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this.presetName = nBTTagCompound._j("PresetName");
        this.targetRegion = nBTTagCompound._j("TargetRegion");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("PresetName", this.presetName);
        nBTTagCompound._a("TargetRegion", this.targetRegion);
    }
}

