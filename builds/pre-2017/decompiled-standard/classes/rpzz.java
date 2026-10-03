/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.stats.PlayerStats;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public class rpzz
extends qlgf {
    private Map<String, Pair<Object, Object>> _a;

    public rpzz(Map<String, Pair<Object, Object>> map) {
        this._a = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.size());
        for (Map.Entry<String, Pair<Object, Object>> entry : this._a.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            StatsType statsType = Stat.getById((String)entry.getKey()).type;
            statsType.write(entry.getValue().getLeft(), dataOutput);
            statsType.write(entry.getValue().getRight(), dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new LinkedHashMap<String, Pair<Object, Object>>();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            StatsType statsType = Stat.getById((String)string).type;
            Object object = statsType.read(dataInput);
            Object object2 = statsType.read(dataInput);
            this._a.put(string, Pair.of(object, object2));
        }
    }

    public Map<String, Pair<Object, Object>> _a() {
        return this._a;
    }

    public static rpzz _a(PlayerStats playerStats, PlayerStats playerStats2) {
        LinkedHashMap<String, Pair<Object, Object>> linkedHashMap = new LinkedHashMap<String, Pair<Object, Object>>();
        if (playerStats != null && playerStats2 != null) {
            for (Stat stat : Stat.statRegistry.values()) {
                if (!stat.isDisplayOnDeath()) continue;
                Object object = playerStats.get(stat);
                Object object2 = playerStats2.get(stat);
                if (object2 != null && object == null) {
                    object = stat.type.getDefault();
                }
                if (object == object2 || object.equals(object2)) continue;
                linkedHashMap.put(stat.id, Pair.of(object, object2));
            }
        }
        return new rpzz(linkedHashMap);
    }

    public rpzz() {
    }
}

