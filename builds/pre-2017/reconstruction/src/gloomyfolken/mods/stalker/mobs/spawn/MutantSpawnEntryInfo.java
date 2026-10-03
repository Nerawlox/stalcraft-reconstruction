/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn;

import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/MutantSpawnEntryInfo;", "Lgloomyfolken/mods/core/spawn/EntitySpawnEntryInfo;", "configurationName", "", "weight", "", "(Ljava/lang/String;F)V", "getConfigurationClient", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "getSpawnConfiguration", "getSpawnWeight", "minecraft"})
public final class MutantSpawnEntryInfo
extends qman {
    @Nullable
    public MutantConfiguration getSpawnConfiguration() {
        return MutantConfigHelper.SERVER.getMobConfiguration(this.getConfigurationName());
    }

    @Nullable
    public final MutantConfiguration getConfigurationClient() {
        return MutantConfigHelper.CLIENT.getMobConfiguration(this.getConfigurationName());
    }

    @Override
    public float getSpawnWeight() {
        return this.getWeight();
    }

    public MutantSpawnEntryInfo(@NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(string, "configurationName");
        super(string, f);
    }
}

