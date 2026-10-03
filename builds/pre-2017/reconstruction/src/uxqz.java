/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class uxqz
extends qlgf {
    private String _b = "";
    protected Map<turb, pzde> _a = new HashMap<turb, pzde>();

    public uxqz(String string) {
        this._b = string;
    }

    public uxqz() {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._b);
        dataOutput.writeShort(this._a.size());
        for (Map.Entry<turb, pzde> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey()._a());
            ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
            entry.getValue().write(byteArrayDataOutput);
            byte[] byArray = byteArrayDataOutput.toByteArray();
            dataOutput.writeInt(byArray.length);
            dataOutput.write(byArray);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = dataInput.readUTF();
        this._a.clear();
        int n = dataInput.readShort();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            int n2 = dataInput.readInt();
            turb turb2 = wmvj._a(string);
            if (turb2 == null) {
                pidb._c("Unable to read achievement with id " + string + " because it is not registered. It's state will be lost.", new String[0]);
                dataInput.skipBytes(n2);
                continue;
            }
            Object s = turb2._f();
            ((pzde)s).read(dataInput);
            ((pzde)s)._a = this._b;
            this._a.put(turb2, (pzde)s);
        }
    }

    public pzde _a(turb turb2) {
        return this._a.get(turb2);
    }

    public void _a(turb turb2, pzde pzde2) {
        this._a.put(turb2, pzde2);
    }

    public Map<turb, pzde> _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }

    public static uxqz _a(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        uxqz uxqz2 = new uxqz();
        try {
            uxqz2.read(byteArrayDataInput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return uxqz2;
    }
}

