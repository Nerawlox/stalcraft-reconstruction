/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundPlayRule;", "", "soundType", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "(Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;)V", "loudness", "", "getLoudness", "()F", "setLoudness", "(F)V", "maxSimultaneousSources", "", "getMaxSimultaneousSources", "()I", "setMaxSimultaneousSources", "(I)V", "minIntervalTicks", "getMinIntervalTicks", "setMinIntervalTicks", "getSoundType", "()Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "minecraft"})
public final class MutantSoundPlayRule {
    @SerializedName(value="minIntervalTicks")
    private int minIntervalTicks;
    @SerializedName(value="maxSimultaneousSources")
    private int maxSimultaneousSources;
    @SerializedName(value="loudness")
    private float loudness;
    @SerializedName(value="soundType")
    @NotNull
    private final MutantSoundType soundType;

    public final int getMinIntervalTicks() {
        return this.minIntervalTicks;
    }

    public final void setMinIntervalTicks(int n) {
        this.minIntervalTicks = n;
    }

    public final int getMaxSimultaneousSources() {
        return this.maxSimultaneousSources;
    }

    public final void setMaxSimultaneousSources(int n) {
        this.maxSimultaneousSources = n;
    }

    public final float getLoudness() {
        return this.loudness;
    }

    public final void setLoudness(float f) {
        this.loudness = f;
    }

    @NotNull
    public final MutantSoundType getSoundType() {
        return this.soundType;
    }

    public MutantSoundPlayRule(@NotNull MutantSoundType mutantSoundType) {
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        this.soundType = mutantSoundType;
        this.minIntervalTicks = 10;
        this.maxSimultaneousSources = 6;
        this.loudness = 1.0f;
    }
}

