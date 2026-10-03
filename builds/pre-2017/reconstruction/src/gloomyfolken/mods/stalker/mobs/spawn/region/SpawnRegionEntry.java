/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn.region;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionBounds;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionEntry;", "", "configuration", "Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionConfiguration;", "bounds", "Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionBounds;", "(Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionConfiguration;Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionBounds;)V", "getBounds", "()Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionBounds;", "getConfiguration", "()Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionConfiguration;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "minecraft"})
public final class SpawnRegionEntry {
    @SerializedName(value="config")
    @NotNull
    private final SpawnRegionConfiguration configuration;
    @SerializedName(value="bounds")
    @NotNull
    private final SpawnRegionBounds bounds;

    @NotNull
    public final SpawnRegionConfiguration getConfiguration() {
        return this.configuration;
    }

    @NotNull
    public final SpawnRegionBounds getBounds() {
        return this.bounds;
    }

    public SpawnRegionEntry(@NotNull SpawnRegionConfiguration spawnRegionConfiguration, @NotNull SpawnRegionBounds spawnRegionBounds) {
        Intrinsics.checkParameterIsNotNull(spawnRegionConfiguration, "configuration");
        Intrinsics.checkParameterIsNotNull(spawnRegionBounds, "bounds");
        this.configuration = spawnRegionConfiguration;
        this.bounds = spawnRegionBounds;
    }

    @NotNull
    public final SpawnRegionConfiguration component1() {
        return this.configuration;
    }

    @NotNull
    public final SpawnRegionBounds component2() {
        return this.bounds;
    }

    @NotNull
    public final SpawnRegionEntry copy(@NotNull SpawnRegionConfiguration spawnRegionConfiguration, @NotNull SpawnRegionBounds spawnRegionBounds) {
        Intrinsics.checkParameterIsNotNull(spawnRegionConfiguration, "configuration");
        Intrinsics.checkParameterIsNotNull(spawnRegionBounds, "bounds");
        return new SpawnRegionEntry(spawnRegionConfiguration, spawnRegionBounds);
    }

    @NotNull
    public static /* synthetic */ SpawnRegionEntry copy$default(SpawnRegionEntry spawnRegionEntry, SpawnRegionConfiguration spawnRegionConfiguration, SpawnRegionBounds spawnRegionBounds, int n, Object object) {
        if ((n & 1) != 0) {
            spawnRegionConfiguration = spawnRegionEntry.configuration;
        }
        if ((n & 2) != 0) {
            spawnRegionBounds = spawnRegionEntry.bounds;
        }
        return spawnRegionEntry.copy(spawnRegionConfiguration, spawnRegionBounds);
    }

    public String toString() {
        return "SpawnRegionEntry(configuration=" + this.configuration + ", bounds=" + this.bounds + ")";
    }

    public int hashCode() {
        SpawnRegionConfiguration spawnRegionConfiguration = this.configuration;
        SpawnRegionBounds spawnRegionBounds = this.bounds;
        return (spawnRegionConfiguration != null ? spawnRegionConfiguration.hashCode() : 0) * 31 + (spawnRegionBounds != null ? spawnRegionBounds.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof SpawnRegionEntry)) break block3;
                SpawnRegionEntry spawnRegionEntry = (SpawnRegionEntry)object;
                if (!Intrinsics.areEqual(this.configuration, spawnRegionEntry.configuration) || !Intrinsics.areEqual(this.bounds, spawnRegionEntry.bounds)) break block3;
            }
            return true;
        }
        return false;
    }
}

