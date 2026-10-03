/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.nbt.NBTTagCompound;

public interface ICompatibilty {
    public int getVersion();

    public void setVersion(int var1);

    public NBTTagCompound writeToNBT(NBTTagCompound var1);
}

