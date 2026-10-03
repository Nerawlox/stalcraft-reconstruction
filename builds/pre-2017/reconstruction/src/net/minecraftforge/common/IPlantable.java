/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public interface IPlantable {
    public EnumPlantType getPlantType(World var1, int var2, int var3, int var4);

    public int getPlantID(World var1, int var2, int var3, int var4);

    public int getPlantMetadata(World var1, int var2, int var3, int var4);
}

