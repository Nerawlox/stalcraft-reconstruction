/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u001aj\b\u0012\u0004\u0012\u00020)`\u001c8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R&\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006?"}, d2={"Lgloomyfolken/mods/core/spawn/SpawnerConfiguration;", "", "()V", "MAX_TRIES", "", "getMAX_TRIES", "()I", "setMAX_TRIES", "(I)V", "SEARCH_X_RANGE", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getSEARCH_X_RANGE", "()Lkotlin/ranges/ClosedFloatingPointRange;", "setSEARCH_X_RANGE", "(Lkotlin/ranges/ClosedFloatingPointRange;)V", "SEARCH_Y_RANGE", "getSEARCH_Y_RANGE", "setSEARCH_Y_RANGE", "SEARCH_Z_RANGE", "getSEARCH_Z_RANGE", "setSEARCH_Z_RANGE", "dayOfTimeType", "getDayOfTimeType", "setDayOfTimeType", "dungeons", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDungeons", "()Ljava/util/ArrayList;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "maxEntityCount", "getMaxEntityCount", "setMaxEntityCount", "possibleSpawnEntries", "Lgloomyfolken/mods/core/spawn/EntitySpawnEntryInfo;", "getPossibleSpawnEntries", "spawnCooldownMax", "", "getSpawnCooldownMax", "()J", "setSpawnCooldownMax", "(J)V", "spawnCooldownMin", "getSpawnCooldownMin", "setSpawnCooldownMin", "sufficientBlocks", "", "getSufficientBlocks", "()[Ljava/lang/Integer;", "setSufficientBlocks", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getSpawnCooldown", "random", "Ljava/util/Random;", "getSpawnableEntityCount", "minecraft"})
public class hskr {
    private transient int MAX_TRIES = 20;
    @NotNull
    private transient ClosedFloatingPointRange<Double> SEARCH_X_RANGE = RangesKt.rangeTo(-3.5, 3.5);
    @NotNull
    private transient ClosedFloatingPointRange<Double> SEARCH_Z_RANGE = RangesKt.rangeTo(-3.5, 3.5);
    @NotNull
    private transient ClosedFloatingPointRange<Double> SEARCH_Y_RANGE = RangesKt.rangeTo(0.0, 0.0);
    @NotNull
    private final transient ArrayList<qman> possibleSpawnEntries;
    @SerializedName(value="enabled")
    private boolean enabled;
    @SerializedName(value="dayOfTimeType")
    private int dayOfTimeType;
    @SerializedName(value="max_entity_count")
    private int maxEntityCount;
    @SerializedName(value="suitable_blocks")
    @NotNull
    private Integer[] sufficientBlocks;
    @SerializedName(value="spawn_cooldown_min")
    private long spawnCooldownMin;
    @SerializedName(value="spawn_cooldown_max")
    private long spawnCooldownMax;
    @SerializedName(value="dungeons")
    @NotNull
    private final ArrayList<String> dungeons;

    public final int getMAX_TRIES() {
        return this.MAX_TRIES;
    }

    public final void setMAX_TRIES(int n) {
        this.MAX_TRIES = n;
    }

    @NotNull
    public final ClosedFloatingPointRange<Double> getSEARCH_X_RANGE() {
        return this.SEARCH_X_RANGE;
    }

    public final void setSEARCH_X_RANGE(@NotNull ClosedFloatingPointRange<Double> closedFloatingPointRange) {
        Intrinsics.checkParameterIsNotNull(closedFloatingPointRange, "<set-?>");
        this.SEARCH_X_RANGE = closedFloatingPointRange;
    }

    @NotNull
    public final ClosedFloatingPointRange<Double> getSEARCH_Z_RANGE() {
        return this.SEARCH_Z_RANGE;
    }

    public final void setSEARCH_Z_RANGE(@NotNull ClosedFloatingPointRange<Double> closedFloatingPointRange) {
        Intrinsics.checkParameterIsNotNull(closedFloatingPointRange, "<set-?>");
        this.SEARCH_Z_RANGE = closedFloatingPointRange;
    }

    @NotNull
    public final ClosedFloatingPointRange<Double> getSEARCH_Y_RANGE() {
        return this.SEARCH_Y_RANGE;
    }

    public final void setSEARCH_Y_RANGE(@NotNull ClosedFloatingPointRange<Double> closedFloatingPointRange) {
        Intrinsics.checkParameterIsNotNull(closedFloatingPointRange, "<set-?>");
        this.SEARCH_Y_RANGE = closedFloatingPointRange;
    }

    @NotNull
    public final ArrayList<qman> getPossibleSpawnEntries() {
        return this.possibleSpawnEntries;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public final int getDayOfTimeType() {
        return this.dayOfTimeType;
    }

    public final void setDayOfTimeType(int n) {
        this.dayOfTimeType = n;
    }

    public final int getMaxEntityCount() {
        return this.maxEntityCount;
    }

    public final void setMaxEntityCount(int n) {
        this.maxEntityCount = n;
    }

    @NotNull
    public final Integer[] getSufficientBlocks() {
        return this.sufficientBlocks;
    }

    public final void setSufficientBlocks(@NotNull Integer[] integerArray) {
        Intrinsics.checkParameterIsNotNull(integerArray, "<set-?>");
        this.sufficientBlocks = integerArray;
    }

    public final long getSpawnCooldownMin() {
        return this.spawnCooldownMin;
    }

    public final void setSpawnCooldownMin(long l) {
        this.spawnCooldownMin = l;
    }

    public final long getSpawnCooldownMax() {
        return this.spawnCooldownMax;
    }

    public final void setSpawnCooldownMax(long l) {
        this.spawnCooldownMax = l;
    }

    @NotNull
    public final ArrayList<String> getDungeons() {
        return this.dungeons;
    }

    public int getSpawnableEntityCount() {
        return this.maxEntityCount;
    }

    public long getSpawnCooldown(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "random");
        return this.spawnCooldownMin + (long)((int)(random.nextDouble() * (double)(this.spawnCooldownMax - this.spawnCooldownMin)));
    }

    public hskr() {
        hskr hskr2 = this;
        Object object = new ArrayList();
        hskr2.possibleSpawnEntries = object;
        this.dayOfTimeType = 3;
        this.maxEntityCount = 8;
        Object[] objectArray = new Integer[]{1, 2, 3, 4};
        hskr2 = this;
        object = objectArray;
        hskr2.sufficientBlocks = (Integer[])object;
        this.spawnCooldownMin = 10L;
        this.spawnCooldownMax = 100L;
        hskr2 = this;
        hskr2.dungeons = object = new ArrayList();
    }
}

