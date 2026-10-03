/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class srpu
extends zwat {
    public long _a;
    public ArrayList<ezfa> _b;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(System.currentTimeMillis());
        dataOutput.writeInt(this._b.size());
        for (ezfa ezfa2 : this._b) {
            dataOutput.writeUTF(ezfa2._a);
            dataOutput.writeByte(ezfa2._a().ordinal());
            dataOutput.writeLong(ezfa2._d());
            dataOutput.writeInt(ezfa2._e());
            dataOutput.writeInt(ezfa2._f());
            dataOutput.writeBoolean(ezfa2._g());
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
        int n = dataInput.readInt();
        this._b = new ArrayList(n);
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            vjsq vjsq2 = vjsq.values()[dataInput.readByte()];
            long l = dataInput.readLong();
            int n2 = dataInput.readInt();
            int n3 = dataInput.readInt();
            boolean bl = dataInput.readBoolean();
            this._b.add(new ezfa(string, vjsq2, l, n2, n3, bl));
        }
    }

    @Override
    public void processClient(boolean bl) {
        yuch._a._a(this._a, this._b);
        if (Minecraft._E()._B instanceof kjui) {
            ((kjui)((Object)Minecraft._E()._B))._a(this._b);
        }
    }

    public static interface kjui {
        public void _a(List<ezfa> var1);
    }
}

