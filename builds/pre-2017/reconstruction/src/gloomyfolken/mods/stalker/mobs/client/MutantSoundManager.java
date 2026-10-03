/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client;

import gloomyfolken.mods.stalker.mobs.client.MutantSoundManager;
import gloomyfolken.mods.stalker.mobs.client.MutantSoundSource;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundPlayRule;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/MutantSoundManager;", "", "()V", "playingSounds", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/stalker/mobs/client/MutantSoundSource;", "Lkotlin/collections/ArrayList;", "shouldClearSoundsThisTick", "", "getShouldClearSoundsThisTick", "()Z", "setShouldClearSoundsThisTick", "(Z)V", "canPlaySound", "soundType", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "soundPlayRule", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundPlayRule;", "playSound", "", "soundSource", "postUpdate", "stopAllSounds", "update", "minecraft"})
public final class MutantSoundManager {
    private static final ArrayList<MutantSoundSource> playingSounds;
    private static boolean shouldClearSoundsThisTick;
    public static final MutantSoundManager INSTANCE;

    public final boolean getShouldClearSoundsThisTick() {
        return shouldClearSoundsThisTick;
    }

    public final void setShouldClearSoundsThisTick(boolean bl) {
        shouldClearSoundsThisTick = bl;
    }

    public final void update() {
        playingSounds.removeIf(update.1.INSTANCE);
    }

    public final void postUpdate() {
        shouldClearSoundsThisTick = false;
    }

    public final void playSound(@NotNull MutantSoundSource mutantSoundSource) {
        Intrinsics.checkParameterIsNotNull(mutantSoundSource, "soundSource");
        Collection collection = playingSounds;
        collection.add(mutantSoundSource);
    }

    public final void stopAllSounds() {
        playingSounds.clear();
        shouldClearSoundsThisTick = true;
    }

    public final boolean canPlaySound(@NotNull MutantSoundType mutantSoundType, @NotNull MutantSoundPlayRule mutantSoundPlayRule) {
        Iterable iterable;
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "soundType");
        Intrinsics.checkParameterIsNotNull(mutantSoundPlayRule, "soundPlayRule");
        Iterable iterable2 = iterable = (Iterable)playingSounds;
        Collection collection = new ArrayList();
        for (Object t : iterable2) {
            MutantSoundSource mutantSoundSource = (MutantSoundSource)t;
            if (!Intrinsics.areEqual((Object)mutantSoundSource.getSoundType(), (Object)mutantSoundType)) continue;
            collection.add(t);
        }
        iterable = (List)collection;
        return iterable.size() < mutantSoundPlayRule.getMaxSimultaneousSources();
    }

    private MutantSoundManager() {
        INSTANCE = this;
        playingSounds = new ArrayList();
    }

    static {
        new MutantSoundManager();
    }
}

