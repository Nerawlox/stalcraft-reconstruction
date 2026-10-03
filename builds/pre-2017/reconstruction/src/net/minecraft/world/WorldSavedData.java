/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.nbt.NBTTagCompound;

public abstract class WorldSavedData {
    public final String mapName;
    public boolean dirty;

    public WorldSavedData(String string) {
        this.mapName = string;
    }

    public abstract void readFromNBT(NBTTagCompound var1);

    public abstract void writeToNBT(NBTTagCompound var1);

    public void markDirty() {
        this.setDirty(true);
    }

    public void setDirty(boolean bl) {
        this.dirty = bl;
    }

    public boolean isDirty() {
        return this.dirty;
    }
}

