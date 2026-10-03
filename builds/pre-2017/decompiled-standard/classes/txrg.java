/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraftforge.common.ForgeDummyContainer;

public class txrg
extends cezg {
    public int _a;
    public int _b;
    public byte[] _c;
    public int _d;
    public static byte[] _e = new byte[0];

    public txrg() {
        this.field_73287_r = true;
    }

    public txrg(int n, int n2, short[] sArray, int n3, ozlu ozlu2) {
        this.field_73287_r = true;
        this._a = n;
        this._b = n2;
        this._d = n3;
        int n4 = 4 * n3;
        ixzi ixzi2 = ozlu2.func_72964_e(n, n2);
        try {
            if (n3 >= ForgeDummyContainer.clumpingThreshold) {
                if (_e.length < n4) {
                    _e = new byte[n4];
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n4);
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                for (int i = 0; i < n3; ++i) {
                    int n5 = sArray[i] >> 12 & 0xF;
                    int n6 = sArray[i] >> 8 & 0xF;
                    int n7 = sArray[i] & 0xFF;
                    dataOutputStream.writeShort(sArray[i]);
                    dataOutputStream.writeShort((short)((ixzi2._d(n5, n7, n6) & 0xFFF) << 4 | ixzi2._e(n5, n7, n6) & 0xF));
                }
                this._c = byteArrayOutputStream.toByteArray();
                if (this._c.length != n4) {
                    throw new RuntimeException("Expected length " + n4 + " doesn't match received length " + this._c.length);
                }
            }
        }
        catch (IOException iOException) {
            this.field_98193_m._b("Couldn't create chunk packet", iOException);
            this._c = null;
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._d = dataInput.readShort() & 0xFFFF;
        int n = dataInput.readInt();
        if (n > 0) {
            this._c = new byte[n];
            dataInput.readFully(this._c);
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeShort((short)this._d);
        if (this._c != null) {
            dataOutput.writeInt(this._c.length);
            dataOutput.write(this._c);
        } else {
            dataOutput.writeInt(0);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72496_a(this);
    }

    @Override
    public int func_73284_a() {
        return 10 + this._d * 4;
    }
}

