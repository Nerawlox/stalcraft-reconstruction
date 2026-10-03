/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import kotlin.Metadata;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/DamageSourceMutant;", "Lnet/minecraft/util/EntityDamageSource;", "par2Entity", "Lnet/minecraft/entity/Entity;", "(Lnet/minecraft/entity/Entity;)V", "isDifficultyScaled", "", "minecraft"})
public final class DamageSourceMutant
extends EntityDamageSource {
    @Override
    public boolean isDifficultyScaled() {
        return false;
    }

    public DamageSourceMutant(@Nullable Entity entity) {
        super("mob", entity);
    }
}

