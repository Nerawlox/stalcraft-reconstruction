/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.liquids.ILiquid;

@Deprecated
public interface IBlockLiquid
extends ILiquid {
    public boolean willGenerateSources();

    public int getFlowDistance();

    public byte[] getLiquidRGB();

    public String getLiquidBlockTextureFile();

    public NBTTagCompound getLiquidProperties();

    public static enum BlockType {
        NONE,
        VANILLA,
        FINITE;

    }
}

