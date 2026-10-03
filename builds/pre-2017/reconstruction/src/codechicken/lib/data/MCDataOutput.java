/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.vec.BlockCoord;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

public interface MCDataOutput {
    public MCDataOutput writeLong(long var1);

    public MCDataOutput writeInt(int var1);

    public MCDataOutput writeShort(int var1);

    public MCDataOutput writeByte(int var1);

    public MCDataOutput writeDouble(double var1);

    public MCDataOutput writeFloat(float var1);

    public MCDataOutput writeBoolean(boolean var1);

    public MCDataOutput writeChar(char var1);

    public MCDataOutput writeByteArray(byte[] var1);

    public MCDataOutput writeString(String var1);

    public MCDataOutput writeCoord(int var1, int var2, int var3);

    public MCDataOutput writeCoord(BlockCoord var1);

    public MCDataOutput writeNBTTagCompound(NBTTagCompound var1);

    public MCDataOutput writeItemStack(ItemStack var1);

    public MCDataOutput writeFluidStack(FluidStack var1);
}

