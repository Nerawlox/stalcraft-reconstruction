/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ntaf
extends zwat {
    private Map<String, Object> _a;

    @ezey(_a={eidj.CLIENT})
    public ntaf(bqss bqss2) {
        this._a = new LinkedHashMap<String, Object>();
        this._a = new LinkedHashMap<String, Object>(bqss2._b());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, Object> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            this._a(dataOutput, entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new LinkedHashMap<String, Object>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            Object object = this._a(dataInput);
            if (object == null) continue;
            this._a.put(string, object);
        }
    }

    private void _a(DataOutput dataOutput, Object object) throws IOException {
        if (object instanceof Integer) {
            dataOutput.writeByte(0);
            dataOutput.writeInt((Integer)object);
        } else if (object instanceof String) {
            dataOutput.writeByte(1);
            dataOutput.writeUTF((String)object);
        } else if (object instanceof Long) {
            dataOutput.writeByte(2);
            dataOutput.writeLong((Long)object);
        } else if (object instanceof Float) {
            dataOutput.writeByte(3);
            dataOutput.writeFloat(((Float)object).floatValue());
        } else if (object instanceof Boolean) {
            dataOutput.writeByte(4);
            dataOutput.writeBoolean((Boolean)object);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + object.getClass());
        }
    }

    private Object _a(DataInput dataInput) throws IOException {
        byte by = dataInput.readByte();
        if (by == 0) {
            return dataInput.readInt();
        }
        if (by == 1) {
            return dataInput.readUTF();
        }
        if (by == 2) {
            return dataInput.readLong();
        }
        if (by == 3) {
            return Float.valueOf(dataInput.readFloat());
        }
        if (by == 4) {
            return dataInput.readBoolean();
        }
        pidb._c("Unknown data type: " + by, new String[0]);
        return null;
    }

    public ntaf() {
    }
}

