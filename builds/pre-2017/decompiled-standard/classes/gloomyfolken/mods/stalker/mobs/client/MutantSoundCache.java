/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client;

import gloomyfolken.mods.stalker.mobs.client.MutantSoundCache;
import gloomyfolken.mods.stalker.mobs.client.MutantSoundManager;
import gloomyfolken.mods.stalker.mobs.client.MutantSoundSource;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantSoundType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/MutantSoundCache;", "", "entityMutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "getEntityMutant", "()Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "playingSounds", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/stalker/mobs/client/MutantSoundSource;", "Lkotlin/collections/ArrayList;", "canPlaySound", "", "sound", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantSoundType;", "playSound", "", "soundSource", "update", "minecraft"})
public final class MutantSoundCache {
    private final ArrayList<MutantSoundSource> playingSounds;
    @NotNull
    private final EntityMutant entityMutant;

    public final void update() {
        if (MutantSoundManager.INSTANCE.getShouldClearSoundsThisTick()) {
            this.playingSounds.clear();
        }
        this.playingSounds.removeIf(update.1.INSTANCE);
    }

    public final void playSound(@NotNull MutantSoundSource mutantSoundSource) {
        Intrinsics.checkParameterIsNotNull(mutantSoundSource, "soundSource");
        Collection collection = this.playingSounds;
        collection.add(mutantSoundSource);
        MutantSoundManager.INSTANCE.playSound(mutantSoundSource);
    }

    public final boolean canPlaySound(@NotNull MutantSoundType mutantSoundType) {
        Iterable iterable;
        Intrinsics.checkParameterIsNotNull((Object)mutantSoundType, "sound");
        Iterable iterable2 = iterable = (Iterable)this.playingSounds;
        Collection collection = new ArrayList();
        for (Object t : iterable2) {
            MutantSoundSource mutantSoundSource = (MutantSoundSource)t;
            if (!Intrinsics.areEqual((Object)mutantSoundSource.getSoundType(), (Object)mutantSoundType)) continue;
            collection.add(t);
        }
        MutantSoundSource mutantSoundSource = (MutantSoundSource)CollectionsKt.firstOrNull((List)collection);
        return mutantSoundSource == null;
    }

    @NotNull
    public final EntityMutant getEntityMutant() {
        return this.entityMutant;
    }

    public MutantSoundCache(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entityMutant");
        this.entityMutant = entityMutant;
        MutantSoundCache mutantSoundCache = this;
        ArrayList arrayList = new ArrayList();
        mutantSoundCache.playingSounds = arrayList;
    }
}

