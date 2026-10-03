/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector2f;
import org.apache.commons.lang3.tuple.Pair;

public class flkj
extends zwat {
    public Map<String, Pair<Vector2f, Float>> _a;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, Pair<Vector2f, Float>> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            Vector2f vector2f = entry.getValue().getLeft();
            dataOutput.writeFloat(vector2f.x);
            dataOutput.writeFloat(vector2f.y);
            float f = entry.getValue().getRight().floatValue();
            dataOutput.writeFloat(f);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new HashMap<String, Pair<Vector2f, Float>>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            Pair<Vector2f, Float> pair = Pair.of(new Vector2f(dataInput.readFloat(), dataInput.readFloat()), Float.valueOf(dataInput.readFloat()));
            this._a.put(string, pair);
        }
    }

    @Override
    public void processClient(boolean bl) {
        ClansMod._B._e._a(this._a);
    }
}

