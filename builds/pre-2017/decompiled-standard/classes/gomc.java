/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class gomc
extends zwat {
    private String _a;
    private List<String> _b;

    public gomc(String string, List<String> list2) {
        this._a = string;
        this._b = list2;
    }

    public static gomc _a(String string, List<turb> list2) {
        return new gomc(string, list2.stream().map(turb::_a).collect(Collectors.toList()));
    }

    public gomc() {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        gomc.writeStringList(this._b, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = gomc.readStringList(dataInput);
    }

    private List<turb> _b() {
        return this._b.stream().map(wmvj::_a).collect(Collectors.toList());
    }
}

