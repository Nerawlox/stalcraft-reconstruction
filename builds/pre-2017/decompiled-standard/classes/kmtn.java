/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class kmtn
extends cezg {
    public static final int _a = new jjqf().func_73281_k();
    public int _b;
    public String _c;
    public int _d;

    public kmtn() {
    }

    public kmtn(int n, String string, int n2) {
        this._b = n;
        this._c = string;
        this._d = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        try {
            this._b = dataInput.readByte();
            try {
                dataInput.readByte();
                kmtn.func_73282_a(dataInput, 255);
                dataInput.readShort();
                this._b = dataInput.readByte();
                if (this._b >= 73) {
                    this._c = kmtn.func_73282_a(dataInput, 255);
                    this._d = dataInput.readInt();
                }
            }
            catch (Throwable throwable) {
                this._c = "";
            }
        }
        catch (Throwable throwable) {
            this._b = 0;
            this._c = "";
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(1);
        dataOutput.writeByte(_a);
        cezg.func_73271_a("MC|PingHost", dataOutput);
        dataOutput.writeShort(3 + 2 * this._c.length() + 4);
        dataOutput.writeByte(this._b);
        cezg.func_73271_a(this._c, dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72467_a(this);
    }

    @Override
    public int func_73284_a() {
        return 3 + this._c.length() * 2 + 4;
    }

    public boolean _a() {
        return this._b == 0;
    }
}

