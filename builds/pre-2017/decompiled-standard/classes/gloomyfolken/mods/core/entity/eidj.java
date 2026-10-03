/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;

public class eidj<T> {
    public Entity _a;
    public final String _b;
    protected final T _c;
    protected final Class<T> _d;
    protected T _e;

    public eidj(Entity entity, String string, T t) {
        this._b = string;
        this._c = t;
        this._e = t;
        this._d = t.getClass();
        this._a = entity;
    }

    public int _a() {
        return this._a.field_70157_k;
    }

    public eidj<T> _b() {
        return this;
    }

    protected boolean _c() {
        return !this._a.field_70170_p.field_72995_K;
    }

    protected void _d() {
        InvokeSideOnly.frontend(() -> {});
    }

    public void _e() {
        this._e = this._c;
    }

    public void _a(T t) {
        if (!(this._e == t || t != null && t.equals(this._e))) {
            this._e = t;
            if (this._c()) {
                this._d();
            }
        }
    }

    public T _f() {
        return this._e;
    }

    public void _a(qoac qoac2) {
        if (qoac2._c(this._b)) {
            this._a(qoac2._k(this._b));
        }
    }

    public void _b(qoac qoac2) {
        qoac2._a(this._b, this._g());
    }

    public byte[] _g() {
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

    private void _a(DataOutput dataOutput) throws IOException {
        if (this._e == null) {
            dataOutput.writeBoolean(true);
        } else {
            dataOutput.writeBoolean(false);
            if (Boolean.class.equals(this._d)) {
                dataOutput.writeBoolean((Boolean)this._e);
            } else if (Byte.class.equals(this._d)) {
                dataOutput.writeByte(((Byte)this._e).byteValue());
            } else if (Short.class.equals(this._d)) {
                dataOutput.writeShort(((Short)this._e).shortValue());
            } else if (Character.class.equals(this._d)) {
                dataOutput.writeChar(((Character)this._e).charValue());
            } else if (Integer.class.equals(this._d)) {
                dataOutput.writeInt((Integer)this._e);
            } else if (Long.class.equals(this._d)) {
                dataOutput.writeLong((Long)this._e);
            } else if (Float.class.equals(this._d)) {
                dataOutput.writeFloat(((Float)this._e).floatValue());
            } else if (Double.class.equals(this._d)) {
                dataOutput.writeDouble((Double)this._e);
            } else if (String.class.equals(this._d)) {
                dataOutput.writeUTF((String)this._e);
            } else if (cvzo.class.equals(this._d)) {
                cezg.func_73270_a((cvzo)this._e, dataOutput);
            } else if (qoac.class.equals(this._d)) {
                byte[] byArray = bsvf._a((qoac)this._e);
                dataOutput.write(byArray.length);
                dataOutput.write(byArray);
            } else if (this._d.isEnum()) {
                dataOutput.writeShort((short)((Enum)this._e).ordinal());
            } else if (qlgf.class.isAssignableFrom(this._d)) {
                ((qlgf)this._e).write(dataOutput);
            } else {
                throw new IOException("Invalid attribute type: " + this._d);
            }
        }
    }

    private void _a(DataInput dataInput) throws ClassNotFoundException, IOException {
        boolean bl = dataInput.readBoolean();
        if (bl) {
            this._a((T)null);
        } else if (Boolean.class.equals(this._d)) {
            this._a(dataInput.readBoolean());
        } else if (Byte.class.equals(this._d)) {
            this._a(dataInput.readByte());
        } else if (Short.class.equals(this._d)) {
            this._a(dataInput.readShort());
        } else if (Character.class.equals(this._d)) {
            this._a(Character.valueOf(dataInput.readChar()));
        } else if (Integer.class.equals(this._d)) {
            this._a(dataInput.readInt());
        } else if (Long.class.equals(this._d)) {
            this._a(dataInput.readLong());
        } else if (Float.class.equals(this._d)) {
            this._a(Float.valueOf(dataInput.readFloat()));
        } else if (Double.class.equals(this._d)) {
            this._a(dataInput.readDouble());
        } else if (String.class.equals(this._d)) {
            this._a(dataInput.readUTF());
        } else if (cvzo.class.equals(this._d)) {
            this._a(cezg.func_73276_c(dataInput));
        } else if (qoac.class.equals(this._d)) {
            int n = dataInput.readInt();
            byte[] byArray = new byte[n];
            dataInput.readFully(byArray);
            this._a((T)bsvf._a(byArray));
        } else if (this._d.isEnum()) {
            T[] TArray = this._d.getEnumConstants();
            this._e = TArray[dataInput.readShort()];
        } else if (qlgf.class.isAssignableFrom(this._d)) {
            ((qlgf)this._e).read(dataInput);
        } else {
            throw new IOException("Invalid attribute type: " + this._d);
        }
    }

    public String toString() {
        return this._e == null ? "null" : this._e.toString();
    }
}

