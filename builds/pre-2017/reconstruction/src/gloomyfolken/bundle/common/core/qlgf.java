/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

public abstract class qlgf {
    public static void writeStringList(List<String> list, DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(list.size());
        for (int i = 0; i < list.size(); ++i) {
            dataOutput.writeUTF(list.get(i));
        }
    }

    public static List<String> readStringList(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        ArrayList<String> arrayList = new ArrayList<String>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add(dataInput.readUTF());
        }
        return arrayList;
    }

    public static void writeNBTTagCompound(NBTTagCompound nBTTagCompound, DataOutput dataOutput) throws IOException {
        if (nBTTagCompound == null) {
            dataOutput.writeInt(-1);
        } else {
            byte[] byArray = bsvf._a(nBTTagCompound);
            dataOutput.writeInt(byArray.length);
            dataOutput.write(byArray);
        }
    }

    public static NBTTagCompound readNBTTagCompound(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        if (n < 0) {
            return null;
        }
        byte[] byArray = new byte[n];
        dataInput.readFully(byArray);
        return bsvf._a(byArray);
    }

    @ezey(_a={eidj.CLIENT, eidj.FRONTEND})
    public static void writeItemStack(ItemStack itemStack, DataOutput dataOutput) throws IOException {
        if (itemStack == null) {
            dataOutput.writeInt(-1);
        } else {
            dataOutput.writeInt(itemStack._d);
            dataOutput.writeInt(itemStack._b);
            dataOutput.writeInt(itemStack._f);
            zwat.writeNBTTagCompound(itemStack._e, dataOutput);
        }
    }

    @ezey(_a={eidj.CLIENT, eidj.FRONTEND})
    public static ItemStack readItemStack(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        if (n >= 0) {
            ItemStack itemStack = new ItemStack(n, dataInput.readInt(), dataInput.readInt());
            itemStack._e = zwat.readNBTTagCompound(dataInput);
            return itemStack;
        }
        return null;
    }

    public static wnce readItemStackData(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        if (n >= 0) {
            return new wnce(n, dataInput.readInt(), dataInput.readInt(), qlgf.readNBTTagCompound(dataInput));
        }
        return null;
    }

    public static void writeItemStackData(wnce wnce2, DataOutput dataOutput) throws IOException {
        if (wnce2 == null) {
            dataOutput.writeShort(-1);
        } else {
            dataOutput.writeInt(wnce2._c());
            dataOutput.writeInt(wnce2._d());
            dataOutput.writeInt(wnce2._e());
            qlgf.writeNBTTagCompound(wnce2._f(), dataOutput);
        }
    }

    public void write(@NotNull DataOutput dataOutput) throws IOException {
        if (dataOutput == null) {
            qlgf.$$$reportNull$$$0(0);
        }
        throw new RuntimeException("write not implemented");
    }

    public void read(@NotNull DataInput dataInput) throws IOException {
        if (dataInput == null) {
            qlgf.$$$reportNull$$$0(1);
        }
        throw new RuntimeException("read not implemented");
    }

    public byte[] toByteArray() {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        try {
            this.write(byteArrayDataOutput);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return byteArrayDataOutput.toByteArray();
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "output";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "input";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/bundle/common/core/ReadAndWriteAble";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "write";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "read";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

