/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;

public class bqwg<T> {
    public final ccxr _a;
    public final String _b;
    private T _f;
    private T _g;
    private Class<T> _h;
    public final boolean _c;
    public final boolean _d;
    public final boolean _e;

    private bqwg(kjui<T> kjui2) {
        this._a = ((kjui)kjui2)._a;
        this._b = ((kjui)kjui2)._b;
        this._g = ((kjui)kjui2)._c;
        this._f = this._g;
        this._h = ((kjui)kjui2)._d;
        this._c = ((kjui)kjui2)._e;
        this._d = ((kjui)kjui2)._f;
        this._e = ((kjui)kjui2)._g;
    }

    void _a() {
        this._f = this._g;
    }

    public void _a(T t) {
        if (!(this._f == t || t != null && t.equals(this._f))) {
            this._f = t;
            if (!this._a._a.worldObj.isRemote && this._a._b()) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
    }

    public T _b() {
        return this._f;
    }

    private void _a(DataOutput dataOutput) throws IOException {
        if (this._f == null) {
            dataOutput.writeBoolean(true);
        } else {
            dataOutput.writeBoolean(false);
            if (Boolean.class.equals(this._h)) {
                dataOutput.writeBoolean((Boolean)this._f);
            } else if (Byte.class.equals(this._h)) {
                dataOutput.writeByte(((Byte)this._f).byteValue());
            } else if (Short.class.equals(this._h)) {
                dataOutput.writeShort(((Short)this._f).shortValue());
            } else if (Character.class.equals(this._h)) {
                dataOutput.writeChar(((Character)this._f).charValue());
            } else if (Integer.class.equals(this._h)) {
                dataOutput.writeInt((Integer)this._f);
            } else if (Long.class.equals(this._h)) {
                dataOutput.writeLong((Long)this._f);
            } else if (Float.class.equals(this._h)) {
                dataOutput.writeFloat(((Float)this._f).floatValue());
            } else if (Double.class.equals(this._h)) {
                dataOutput.writeDouble((Double)this._f);
            } else if (String.class.equals(this._h)) {
                dataOutput.writeUTF((String)this._f);
            } else if (ItemStack.class.equals(this._h)) {
                Packet.writeItemStack((ItemStack)this._f, dataOutput);
            } else if (NBTTagCompound.class.equals(this._h)) {
                byte[] byArray = bsvf._a((NBTTagCompound)this._f);
                dataOutput.write(byArray.length);
                dataOutput.write(byArray);
            } else if (this._h.isEnum()) {
                dataOutput.writeShort((short)((Enum)this._f).ordinal());
            } else if (qlgf.class.isAssignableFrom(this._h)) {
                ((qlgf)this._f).write(dataOutput);
            } else {
                throw new IOException("Invalid attribute type: " + this._h);
            }
        }
    }

    private void _a(DataInput dataInput) throws ClassNotFoundException, IOException {
        boolean bl = dataInput.readBoolean();
        if (bl) {
            this._a((T)null);
        } else if (Boolean.class.equals(this._h)) {
            this._a(dataInput.readBoolean());
        } else if (Byte.class.equals(this._h)) {
            this._a(dataInput.readByte());
        } else if (Short.class.equals(this._h)) {
            this._a(dataInput.readShort());
        } else if (Character.class.equals(this._h)) {
            this._a(Character.valueOf(dataInput.readChar()));
        } else if (Integer.class.equals(this._h)) {
            this._a(dataInput.readInt());
        } else if (Long.class.equals(this._h)) {
            this._a(dataInput.readLong());
        } else if (Float.class.equals(this._h)) {
            this._a(Float.valueOf(dataInput.readFloat()));
        } else if (Double.class.equals(this._h)) {
            this._a(dataInput.readDouble());
        } else if (String.class.equals(this._h)) {
            this._a(dataInput.readUTF());
        } else if (ItemStack.class.equals(this._h)) {
            this._a(Packet.readItemStack(dataInput));
        } else if (NBTTagCompound.class.equals(this._h)) {
            int n = dataInput.readInt();
            byte[] byArray = new byte[n];
            dataInput.readFully(byArray);
            this._a((T)bsvf._a(byArray));
        } else if (this._h.isEnum()) {
            T[] TArray = this._h.getEnumConstants();
            this._f = TArray[dataInput.readShort()];
        } else if (qlgf.class.isAssignableFrom(this._h)) {
            ((qlgf)this._f).read(dataInput);
        } else {
            throw new IOException("Invalid attribute type: " + this._h);
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c(this._b)) {
            this._a(nBTTagCompound._k(this._b));
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a(this._b, this._c());
    }

    public byte[] _c() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            this._a(dataOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return new byte[0];
        }
    }

    public void _a(byte[] byArray) {
        try {
            this._a(new DataInputStream(new ByteArrayInputStream(byArray)));
        }
        catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public String toString() {
        return this._f == null ? "null" : this._f.toString();
    }

    public static class kjui<T> {
        private ccxr _a;
        private String _b;
        private T _c;
        private Class<T> _d;
        private boolean _e;
        private boolean _f;
        private boolean _g;

        public kjui(ccxr ccxr2, String string, Class<T> clazz) {
            this._a = ccxr2;
            this._b = string;
            this._d = clazz;
        }

        public kjui(ccxr ccxr2, String string, T t) {
            this(ccxr2, string, t.getClass());
            this._c = t;
        }

        public kjui<T> _a() {
            this._e = true;
            return this;
        }

        public kjui<T> _b() {
            this._g = true;
            this._f = true;
            return this;
        }

        public kjui<T> _c() {
            this._f = true;
            return this;
        }

        public kjui<T> _d() {
            this._g = true;
            return this;
        }

        public bqwg<T> _e() {
            return new bqwg(this);
        }

        public bqwg<T> _f() {
            bqwg<T> bqwg2 = this._e();
            this._a._a(bqwg2);
            return bqwg2;
        }
    }
}

