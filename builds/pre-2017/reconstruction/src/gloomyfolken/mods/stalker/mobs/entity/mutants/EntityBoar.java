/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityBoar;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "getEntityName", "", "minecraft"})
public final class EntityBoar
extends EntityMutant {
    @Override
    @NotNull
    public String getEntityName() {
        return "\u041a\u0430\u0431\u0430\u043d";
    }

    public EntityBoar(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        super(world);
        this.setSize(1.2f, 1.2f);
    }
}

