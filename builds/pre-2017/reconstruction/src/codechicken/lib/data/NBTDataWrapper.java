/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.data.MCDataInput;
import codechicken.lib.data.MCDataOutput;
import codechicken.lib.vec.BlockCoord;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.fluids.FluidStack;

public class NBTDataWrapper
implements MCDataInput,
MCDataOutput {
    private NBTTagList readList;
    private int readTag = 0;
    private NBTTagList writeList;

    public NBTDataWrapper(NBTTagList nBTTagList) {
        this.readList = nBTTagList;
    }

    public NBTDataWrapper() {
        this.writeList = new NBTTagList();
    }

    public NBTTagList toTag() {
        return this.writeList;
    }

    @Override
    public NBTDataWrapper writeLong(long l) {
        this.writeList._a(new grhp(null, l));
        return this;
    }

    @Override
    public NBTDataWrapper writeInt(int n) {
        this.writeList._a(new hdfw(null, n));
        return this;
    }

    @Override
    public NBTDataWrapper writeShort(int n) {
        this.writeList._a(new ixnt(null, (short)n));
        return this;
    }

    @Override
    public NBTDataWrapper writeByte(int n) {
        this.writeList._a(new xsub(null, (byte)n));
        return this;
    }

    @Override
    public NBTDataWrapper writeDouble(double d) {
        this.writeList._a(new qoae(null, d));
        return this;
    }

    @Override
    public NBTDataWrapper writeFloat(float f) {
        this.writeList._a(new jjly(null, f));
        return this;
    }

    @Override
    public NBTDataWrapper writeBoolean(boolean bl) {
        this.writeList._a(new xsub(null, (byte)(bl ? 1 : 0)));
        return this;
    }

    @Override
    public NBTDataWrapper writeChar(char c) {
        this.writeList._a(new ixnt(null, (short)c));
        return this;
    }

    @Override
    public NBTDataWrapper writeByteArray(byte[] byArray) {
        this.writeList._a(new yvxd(null, byArray));
        return this;
    }

    @Override
    public NBTDataWrapper writeString(String string) {
        this.writeList._a(new NBTTagString(null, string));
        return this;
    }

    @Override
    public NBTDataWrapper writeCoord(int n, int n2, int n3) {
        this.writeInt(n);
        this.writeInt(n2);
        this.writeInt(n3);
        return this;
    }

    @Override
    public NBTDataWrapper writeCoord(BlockCoord blockCoord) {
        this.writeCoord(blockCoord.x, blockCoord.y, blockCoord.z);
        return this;
    }

    @Override
    public NBTDataWrapper writeNBTTagCompound(NBTTagCompound nBTTagCompound) {
        this.writeList._a(nBTTagCompound);
        return this;
    }

    @Override
    public NBTDataWrapper writeItemStack(ItemStack itemStack) {
        this.writeList._a(itemStack._b(new NBTTagCompound()));
        return this;
    }

    @Override
    public NBTDataWrapper writeFluidStack(FluidStack fluidStack) {
        this.writeList._a(fluidStack.writeToNBT(new NBTTagCompound()));
        return this;
    }

    @Override
    public long readLong() {
        return ((grhp)this.readTag())._c;
    }

    @Override
    public int readInt() {
        return ((hdfw)this.readTag())._c;
    }

    @Override
    public short readShort() {
        return ((ixnt)this.readTag())._c;
    }

    @Override
    public int readUShort() {
        return ((ixnt)this.readTag())._c & 0xFFFF;
    }

    @Override
    public byte readByte() {
        return ((xsub)this.readTag())._c;
    }

    @Override
    public int readUByte() {
        return ((xsub)this.readTag())._c & 0xFF;
    }

    @Override
    public double readDouble() {
        return ((qoae)this.readTag())._c;
    }

    @Override
    public float readFloat() {
        return ((jjly)this.readTag())._c;
    }

    @Override
    public boolean readBoolean() {
        return ((xsub)this.readTag())._c != 0;
    }

    @Override
    public char readChar() {
        return (char)((ixnt)this.readTag())._c;
    }

    @Override
    public byte[] readByteArray(int n) {
        return ((yvxd)this.readTag())._c;
    }

    @Override
    public String readString() {
        return ((NBTTagString)this.readTag())._c;
    }

    @Override
    public BlockCoord readCoord() {
        return new BlockCoord(this.readInt(), this.readInt(), this.readInt());
    }

    @Override
    public NBTTagCompound readNBTTagCompound() {
        return (NBTTagCompound)this.readTag();
    }

    @Override
    public ItemStack readItemStack() {
        return ItemStack._a(this.readNBTTagCompound());
    }

    @Override
    public FluidStack readFluidStack() {
        return FluidStack.loadFluidStackFromNBT(this.readNBTTagCompound());
    }

    private NBTBase readTag() {
        return this.readList._b(this.readTag++);
    }
}

