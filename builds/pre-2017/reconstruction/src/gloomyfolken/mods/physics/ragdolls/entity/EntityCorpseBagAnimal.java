/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBagAnimal;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBag;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "owner", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "(Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;)V", "getLeftoverRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "render", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "entity", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "minecraft"})
public final class EntityCorpseBagAnimal
extends EntityCorpseBag {
    @Override
    @NotNull
    public kjui getLeftoverRenderer(@NotNull RenderCorpseLeftovers renderCorpseLeftovers, @NotNull ILeftoversRenderInfo iLeftoversRenderInfo) {
        Intrinsics.checkParameterIsNotNull(renderCorpseLeftovers, "render");
        Intrinsics.checkParameterIsNotNull(iLeftoversRenderInfo, "entity");
        kjui kjui2 = renderCorpseLeftovers.getAnimalLeftoversRenderer()._b();
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "render.animalLeftoversRe\u2026r.defaultMaterialRenderer");
        return kjui2;
    }

    public EntityCorpseBagAnimal(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        super(world);
    }

    public EntityCorpseBagAnimal(@NotNull EntityRagdollCorpse entityRagdollCorpse) {
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "owner");
        super(entityRagdollCorpse);
    }
}

