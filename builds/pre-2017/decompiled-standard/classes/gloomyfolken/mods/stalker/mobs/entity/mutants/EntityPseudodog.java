/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityPseudodog;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "getEntityName", "", "minecraft"})
public final class EntityPseudodog
extends EntityMutant {
    @Override
    @NotNull
    public String func_70023_ak() {
        return "\u041f\u0441\u0435\u0432\u0434\u043e\u043f\u0451\u0441";
    }

    public EntityPseudodog(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        super(ozlu2);
        this.func_70105_a(0.99f, 0.8f);
    }
}

