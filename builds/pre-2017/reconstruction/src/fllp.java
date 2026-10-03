/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fllp
extends zwat {
    public static final byte _a = 0;
    public static final byte _b = 1;
    public byte _c;
    public String _d;
    public String _e = "";
    public String _f;
    public long _g;
    public boolean _h;

    public fllp(String string) {
        this._f = string;
    }

    public fllp _a(long l) {
        this._c = 0;
        this._g = l;
        return this;
    }

    public fllp _a(String string) {
        this._c = 1;
        this._d = string;
        return this;
    }

    public fllp _a(boolean bl) {
        this._h = bl;
        return this;
    }

    public fllp _b(String string) {
        this._e = string;
        return this;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._c = dataInput.readByte();
        this._f = dataInput.readUTF();
        this._e = dataInput.readUTF();
        switch (this._c) {
            case 1: {
                this._d = dataInput.readUTF();
                break;
            }
            case 0: {
                this._g = dataInput.readLong();
                this._h = dataInput.readBoolean();
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._c);
        dataOutput.writeUTF(this._f);
        dataOutput.writeUTF(this._e);
        switch (this._c) {
            case 1: {
                dataOutput.writeUTF(this._d);
                break;
            }
            case 0: {
                dataOutput.writeLong(this._g);
                dataOutput.writeBoolean(this._h);
            }
        }
    }

    public fllp() {
    }
}

