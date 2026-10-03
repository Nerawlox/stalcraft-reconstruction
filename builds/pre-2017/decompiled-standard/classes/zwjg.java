/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.main.ClientProxy;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zwjg
extends zwat {
    private List<String> _a;
    private bqdo _b;

    public zwjg(bqdo bqdo2) {
        this._a = new ArrayList<String>();
        this._b = bqdo2;
    }

    public zwjg(List<String> list, bqdo bqdo2) {
        this._a = list;
        this._b = bqdo2;
    }

    public zwjg(String string, bqdo bqdo2) {
        this(Collections.singletonList(string), bqdo2);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        zwjg.writeStringList(this._a, dataOutput);
        this._b.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = zwjg.readStringList(dataInput);
        this._b = new bqdo();
        this._b.read(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        ClientProxy.publishNotification(this._b);
    }

    public zwjg() {
    }
}

