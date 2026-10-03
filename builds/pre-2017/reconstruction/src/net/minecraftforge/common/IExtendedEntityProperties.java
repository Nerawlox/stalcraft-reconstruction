/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IExtendedEntityProperties {
    public void saveNBTData(NBTTagCompound var1);

    public void loadNBTData(NBTTagCompound var1);

    public void init(Entity var1, World var2);
}

