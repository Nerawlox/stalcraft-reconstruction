/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class samo
extends pzde {
    private Set<String> _d;

    public samo(hanr hanr2) {
        super(hanr2);
        this._d = new HashSet<String>();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._d.size());
        for (String string : this._d) {
            dataOutput.writeUTF(string);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._d.clear();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this._d.add(dataInput.readUTF());
        }
    }

    public void _a(String string) {
        if (this._a()) {
            return;
        }
        this._d.add(string);
        this._c();
    }

    public Set<String> _e() {
        return this._d;
    }

    public samo() {
    }
}

