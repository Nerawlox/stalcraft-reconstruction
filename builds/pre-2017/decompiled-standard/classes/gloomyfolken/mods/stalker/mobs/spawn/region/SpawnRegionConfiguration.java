/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn.region;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnerConfiguration;
import kotlin.Metadata;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionConfiguration;", "Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnerConfiguration;", "()V", "entityCountPercentage", "", "getEntityCountPercentage", "()D", "setEntityCountPercentage", "(D)V", "yMax", "", "getYMax", "()I", "setYMax", "(I)V", "yMin", "getYMin", "setYMin", "getSpawnableEntityCount", "minecraft"})
public final class SpawnRegionConfiguration
extends MutantSpawnerConfiguration {
    @SerializedName(value="y_min")
    private int yMin = -1;
    @SerializedName(value="y_max")
    private int yMax = -1;
    private transient double entityCountPercentage = 1.0;

    public final int getYMin() {
        return this.yMin;
    }

    public final void setYMin(int n) {
        this.yMin = n;
    }

    public final int getYMax() {
        return this.yMax;
    }

    public final void setYMax(int n) {
        this.yMax = n;
    }

    public final double getEntityCountPercentage() {
        return this.entityCountPercentage;
    }

    public final void setEntityCountPercentage(double d) {
        this.entityCountPercentage = d;
    }

    @Override
    public int getSpawnableEntityCount() {
        return (int)Math.ceil((double)super.getSpawnableEntityCount() * this.entityCountPercentage);
    }
}

