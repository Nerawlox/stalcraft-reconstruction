/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0015\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityChimera;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "world", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "getEntityName", "", "registerBehaviors", "", "minecraft"})
public final class EntityChimera
extends EntityMutant {
    @Override
    @NotNull
    public String getEntityName() {
        return "\u0425\u0438\u043c\u0435\u0440\u0430";
    }

    public EntityChimera(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        super(world);
        this.setSize(1.3f, 1.2f);
    }
}

