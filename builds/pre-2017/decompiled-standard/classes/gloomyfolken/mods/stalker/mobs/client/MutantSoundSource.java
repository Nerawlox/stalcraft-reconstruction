/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client;

import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/MutantSoundSource;", "", "soundType", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "mcSoundId", "", "time", "", "tickStarted", "", "(Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;Ljava/lang/String;JI)V", "getMcSoundId", "()Ljava/lang/String;", "getSoundType", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "getTickStarted", "()I", "getTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "minecraft"})
public final class MutantSoundSource {
    @NotNull
    private final MutantSoundType soundType;
    @NotNull
    private final String mcSoundId;
    private final long time;
    private final int tickStarted;

    @NotNull
    public final MutantSoundType getSoundType() {
        return this.soundType;
    }

    @NotNull
    public final String getMcSoundId() {
        return this.mcSoundId;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getTickStarted() {
        return this.tickStarted;
    }

    public MutantSoundSource(@NotNull MutantSoundType mutantSoundType, @NotNull String string, long l, int n) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        Intrinsics.checkParameterIsNotNull(string, "mcSoundId");
        this.soundType = mutantSoundType;
        this.mcSoundId = string;
        this.time = l;
        this.tickStarted = n;
    }

    @NotNull
    public final MutantSoundType component1() {
        return this.soundType;
    }

    @NotNull
    public final String component2() {
        return this.mcSoundId;
    }

    public final long component3() {
        return this.time;
    }

    public final int component4() {
        return this.tickStarted;
    }

    @NotNull
    public final MutantSoundSource copy(@NotNull MutantSoundType mutantSoundType, @NotNull String string, long l, int n) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        Intrinsics.checkParameterIsNotNull(string, "mcSoundId");
        return new MutantSoundSource(mutantSoundType, string, l, n);
    }

    @NotNull
    public static /* synthetic */ MutantSoundSource copy$default(MutantSoundSource mutantSoundSource, MutantSoundType mutantSoundType, String string, long l, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            mutantSoundType = mutantSoundSource.soundType;
        }
        if ((n2 & 2) != 0) {
            string = mutantSoundSource.mcSoundId;
        }
        if ((n2 & 4) != 0) {
            l = mutantSoundSource.time;
        }
        if ((n2 & 8) != 0) {
            n = mutantSoundSource.tickStarted;
        }
        return mutantSoundSource.copy(mutantSoundType, string, l, n);
    }

    public String toString() {
        return "MutantSoundSource(soundType=" + (Object)((Object)this.soundType) + ", mcSoundId=" + this.mcSoundId + ", time=" + this.time + ", tickStarted=" + this.tickStarted + ")";
    }

    public int hashCode() {
        MutantSoundType mutantSoundType = this.soundType;
        String string = this.mcSoundId;
        return (((mutantSoundType != null ? ((Object)((Object)mutantSoundType)).hashCode() : 0) * 31 + (string != null ? string.hashCode() : 0)) * 31 + Long.hashCode(this.time)) * 31 + Integer.hashCode(this.tickStarted);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof MutantSoundSource)) break block3;
                MutantSoundSource mutantSoundSource = (MutantSoundSource)object;
                if (!Intrinsics.areEqual((Object)this.soundType, (Object)mutantSoundSource.soundType) || !Intrinsics.areEqual(this.mcSoundId, mutantSoundSource.mcSoundId) || !(this.time == mutantSoundSource.time) || !(this.tickStarted == mutantSoundSource.tickStarted)) break block3;
            }
            return true;
        }
        return false;
    }
}

