/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeDirection;

public interface IBlockAccess {
    public int getBlockId(int var1, int var2, int var3);

    public TileEntity getBlockTileEntity(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public int getLightBrightnessForSkyBlocks(int var1, int var2, int var3, int var4);

    public int getBlockMetadata(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public float getBrightness(int var1, int var2, int var3, int var4);

    @SideOnly(value=Side.CLIENT)
    public float getLightBrightness(int var1, int var2, int var3);

    public Material getBlockMaterial(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public boolean isBlockOpaqueCube(int var1, int var2, int var3);

    public boolean isBlockNormalCube(int var1, int var2, int var3);

    public boolean isAirBlock(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public BiomeGenBase getBiomeGenForCoords(int var1, int var2);

    @SideOnly(value=Side.CLIENT)
    public int getHeight();

    @SideOnly(value=Side.CLIENT)
    public boolean extendedLevelsInChunkCache();

    @SideOnly(value=Side.CLIENT)
    public boolean doesBlockHaveSolidTopSurface(int var1, int var2, int var3);

    public Vec3Pool getWorldVec3Pool();

    public int isBlockProvidingPowerTo(int var1, int var2, int var3, int var4);

    public boolean isBlockSolidOnSide(int var1, int var2, int var3, ForgeDirection var4, boolean var5);
}

