/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core.stats;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerStats
extends qlgf {
    protected Map<Stat, Object> values = new HashMap<Stat, Object>();
    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public EntityPlayer player;

    public PlayerStats() {
    }

    public PlayerStats(Map<Stat, Object> map) {
        this.values = map;
    }

    public Object get(Stat stat) {
        return this.values.get(stat);
    }

    public boolean contains(Stat stat) {
        return this.values.containsKey(stat);
    }

    public Object getOr(Stat stat, Object object) {
        return this.values.getOrDefault(stat, object);
    }

    public int getInt(Stat stat) {
        PlayerStats.checkValidType(stat, StatsType.INTEGER);
        return (Integer)this.values.getOrDefault(stat, 0);
    }

    public double getDecimal(Stat stat) {
        PlayerStats.checkValidType(stat, StatsType.DECIMAL);
        return (Double)this.values.getOrDefault(stat, 0.0);
    }

    public Instant getDate(Stat stat) {
        PlayerStats.checkValidType(stat, StatsType.DATE);
        return this.values.getOrDefault(stat, null);
    }

    public long getDuration(Stat stat) {
        PlayerStats.checkValidType(stat, StatsType.DURATION);
        return (Long)this.values.getOrDefault(stat, 0);
    }

    public String getFormatted(Stat stat) {
        Object object = this.get(stat);
        if (object != null) {
            return stat.displayer.format(stat, object);
        }
        return null;
    }

    public void clearIf(Predicate<Map.Entry<Stat, Object>> predicate) {
        this.values.entrySet().removeIf(predicate);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.values.size());
        for (Map.Entry<Stat, Object> entry : this.values.entrySet()) {
            dataOutput.writeUTF(entry.getKey().id);
            dataOutput.writeByte(entry.getKey().type.ordinal());
            entry.getKey().type.write(entry.getValue(), dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            Stat stat = Stat.getById(string);
            StatsType statsType = StatsType.values()[dataInput.readByte()];
            Object object = statsType.read(dataInput);
            if (stat == null) {
                pidb._c("Stored stat of type %s with id %s and value %s is not registered, ignoring.", statsType.name(), string, object.toString());
                return;
            }
            this.values.put(stat, object);
        }
    }

    public PlayerStats copy() {
        return new PlayerStats(new HashMap<Stat, Object>(this.values));
    }

    private static void checkValidType(Stat stat, StatsType statsType) {
        if (stat.type != statsType) {
            throw new IllegalArgumentException("Invalid stat type " + (Object)((Object)statsType) + ". Should be " + (Object)((Object)stat.type));
        }
    }

    public static PlayerStats fromBytes(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        PlayerStats playerStats = new PlayerStats();
        try {
            playerStats.read(byteArrayDataInput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return playerStats;
    }
}

