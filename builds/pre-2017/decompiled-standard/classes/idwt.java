/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.party.kjui;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector2f;
import org.apache.commons.lang3.tuple.Pair;

public class idwt
extends zwat {
    private Map<String, Pair<Vector2f, Float>> _a;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, Pair<Vector2f, Float>> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeFloat(entry.getValue().getLeft().x);
            dataOutput.writeFloat(entry.getValue().getLeft().y);
            dataOutput.writeFloat(entry.getValue().getRight().floatValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new HashMap<String, Pair<Vector2f, Float>>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this._a.put(dataInput.readUTF(), Pair.of(new Vector2f(dataInput.readFloat(), dataInput.readFloat()), Float.valueOf(dataInput.readFloat())));
        }
    }

    @Override
    public void processClient(boolean bl) {
        this._a.forEach((string, pair) -> {
            kjui.kjui kjui2 = gloomyfolken.mods.party.zwat._a._a.get(string);
            if (kjui2 == null) {
                return;
            }
            kjui2._a((Vector2f)pair.getLeft());
            kjui2._g = ((Float)pair.getRight()).floatValue();
        });
    }
}

