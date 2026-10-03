/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import net.minecraftforge.common.EnumPlantType;

public interface IPlantable {
    public EnumPlantType getPlantType(ozlu var1, int var2, int var3, int var4);

    public int getPlantID(ozlu var1, int var2, int var3, int var4);

    public int getPlantMetadata(ozlu var1, int var2, int var3, int var4);
}

