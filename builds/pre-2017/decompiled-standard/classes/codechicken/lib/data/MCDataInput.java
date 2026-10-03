/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.vec.BlockCoord;
import net.minecraftforge.fluids.FluidStack;

public interface MCDataInput {
    public long readLong();

    public int readInt();

    public short readShort();

    public int readUShort();

    public byte readByte();

    public int readUByte();

    public double readDouble();

    public float readFloat();

    public boolean readBoolean();

    public char readChar();

    public byte[] readByteArray(int var1);

    public String readString();

    public BlockCoord readCoord();

    public qoac readNBTTagCompound();

    public cvzo readItemStack();

    public FluidStack readFluidStack();
}

