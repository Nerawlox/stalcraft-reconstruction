/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLiving;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/core/spawn/ScheduledSpawnTaskEntry;", "", "spawnConfigurationProvider", "Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;", "Lnet/minecraft/entity/EntityLiving;", "taskExecutionTime", "", "(Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;J)V", "getSpawnConfigurationProvider", "()Lgloomyfolken/mods/core/spawn/IEntitySpawnProvider;", "getTaskExecutionTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "minecraft"})
public final class lnvg {
    @NotNull
    private final uyqc<EntityLiving> _a;
    private final long _b;

    @NotNull
    public final uyqc<EntityLiving> _a() {
        return this._a;
    }

    public final long _b() {
        return this._b;
    }

    public lnvg(@NotNull uyqc<? extends EntityLiving> uyqc2, long l) {
        Intrinsics.checkParameterIsNotNull(uyqc2, "spawnConfigurationProvider");
        this._a = uyqc2;
        this._b = l;
    }

    @NotNull
    public final uyqc<EntityLiving> _c() {
        return this._a;
    }

    public final long _d() {
        return this._b;
    }

    @NotNull
    public final lnvg _a(@NotNull uyqc<? extends EntityLiving> uyqc2, long l) {
        Intrinsics.checkParameterIsNotNull(uyqc2, "spawnConfigurationProvider");
        return new lnvg(uyqc2, l);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ lnvg _a(lnvg lnvg2, uyqc uyqc2, long l, int n, Object object) {
        if ((n & 1) != 0) {
            uyqc2 = lnvg2._a;
        }
        if ((n & 2) != 0) {
            l = lnvg2._b;
        }
        return lnvg2._a(uyqc2, l);
    }

    public String toString() {
        return "ScheduledSpawnTaskEntry(spawnConfigurationProvider=" + this._a + ", taskExecutionTime=" + this._b + ")";
    }

    public int hashCode() {
        uyqc<EntityLiving> uyqc2 = this._a;
        return (uyqc2 != null ? uyqc2.hashCode() : 0) * 31 + Long.hashCode(this._b);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof lnvg)) break block3;
                lnvg lnvg2 = (lnvg)object;
                if (!Intrinsics.areEqual(this._a, lnvg2._a) || !(this._b == lnvg2._b)) break block3;
            }
            return true;
        }
        return false;
    }
}

