/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.data;

import codechicken.lib.data.MCDataOutput;
import codechicken.lib.vec.BlockCoord;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

public class MCOutputStreamWrapper
implements MCDataOutput {
    public DataOutputStream dataout;

    public MCOutputStreamWrapper(DataOutputStream dataOutputStream) {
        this.dataout = dataOutputStream;
    }

    @Override
    public MCOutputStreamWrapper writeBoolean(boolean bl) {
        try {
            this.dataout.writeBoolean(bl);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeByte(int n) {
        try {
            this.dataout.writeByte(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeShort(int n) {
        try {
            this.dataout.writeShort(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeInt(int n) {
        try {
            this.dataout.writeInt(n);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeFloat(float f) {
        try {
            this.dataout.writeFloat(f);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeDouble(double d) {
        try {
            this.dataout.writeDouble(d);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeLong(long l) {
        try {
            this.dataout.writeLong(l);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeChar(char c) {
        try {
            this.dataout.writeChar(c);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeByteArray(byte[] byArray) {
        try {
            this.dataout.write(byArray);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeCoord(int n, int n2, int n3) {
        this.writeInt(n);
        this.writeInt(n2);
        this.writeInt(n3);
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeCoord(BlockCoord blockCoord) {
        this.writeInt(blockCoord.x);
        this.writeInt(blockCoord.y);
        this.writeInt(blockCoord.z);
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeString(String string) {
        try {
            if (string.length() > 65535) {
                throw new IOException("String length: " + string.length() + "too long.");
            }
            this.dataout.writeShort(string.length());
            this.dataout.writeChars(string);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeItemStack(ItemStack itemStack) {
        this.writeItemStack(itemStack, false);
        return this;
    }

    public MCOutputStreamWrapper writeItemStack(ItemStack itemStack, boolean bl) {
        if (itemStack == null) {
            this.writeShort(-1);
        } else {
            this.writeShort(itemStack._d);
            if (bl) {
                this.writeInt(itemStack._b);
            } else {
                this.writeByte(itemStack._b);
            }
            this.writeShort(itemStack._j());
            this.writeNBTTagCompound(itemStack._e);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeNBTTagCompound(NBTTagCompound nBTTagCompound) {
        try {
            if (nBTTagCompound == null) {
                this.writeShort(-1);
            } else {
                byte[] byArray = bsvf._a(nBTTagCompound);
                this.writeShort((short)byArray.length);
                this.writeByteArray(byArray);
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return this;
    }

    @Override
    public MCOutputStreamWrapper writeFluidStack(FluidStack fluidStack) {
        if (fluidStack == null) {
            this.writeShort(-1);
        } else {
            this.writeShort(fluidStack.fluidID);
            this.writeInt(fluidStack.amount);
            this.writeNBTTagCompound(fluidStack.tag);
        }
        return this;
    }
}

