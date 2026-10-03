/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class tgpn
extends cezg {
    public int _a;
    public final List _b = new ArrayList();

    public tgpn() {
    }

    public tgpn(int n, Collection collection) {
        this._a = n;
        for (hubf hubf2 : collection) {
            this._b.add(new apzo(this, hubf2._a()._a(), hubf2._b(), hubf2._c()));
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = tgpn.func_73282_a(dataInput, 64);
            double d = dataInput.readDouble();
            ArrayList<xson> arrayList = new ArrayList<xson>();
            int n2 = dataInput.readShort();
            for (int j = 0; j < n2; ++j) {
                UUID uUID = new UUID(dataInput.readLong(), dataInput.readLong());
                arrayList.add(new xson(uUID, "Unknown synced attribute modifier", dataInput.readDouble(), dataInput.readByte()));
            }
            this._b.add(new apzo(this, string, d, arrayList));
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b.size());
        for (apzo apzo2 : this._b) {
            tgpn.func_73271_a(apzo2._a(), dataOutput);
            dataOutput.writeDouble(apzo2._b());
            dataOutput.writeShort(apzo2._c().size());
            for (xson xson2 : apzo2._c()) {
                dataOutput.writeLong(xson2._a().getMostSignificantBits());
                dataOutput.writeLong(xson2._a().getLeastSignificantBits());
                dataOutput.writeDouble(xson2._d());
                dataOutput.writeByte(xson2._c());
            }
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_110773_a(this);
    }

    @Override
    public int func_73284_a() {
        return 8 + this._b.size() * 24;
    }

    public int _a() {
        return this._a;
    }

    public List _b() {
        return this._b;
    }
}

