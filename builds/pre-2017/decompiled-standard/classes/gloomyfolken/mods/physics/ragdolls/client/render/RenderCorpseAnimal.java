/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseAnimal;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.stalker.mobs.client.render.RenderMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseAnimal;", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpse;", "()V", "prepareRenderCorpse", "", "entityRagdollCorpse", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "frame", "", "minecraft"})
public final class RenderCorpseAnimal
extends RenderCorpse {
    @Override
    public void prepareRenderCorpse(@NotNull EntityRagdollCorpse entityRagdollCorpse, float f) {
        Class<? extends EntityMutant> clazz;
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "entityRagdollCorpse");
        EntityCorpseAnimal entityCorpseAnimal = (EntityCorpseAnimal)entityRagdollCorpse;
        Class<? extends EntityMutant> clazz2 = MutantRegistry.INSTANCE.getRegisteredMobs().get(((EntityCorpseAnimal)entityRagdollCorpse).getMobTypeId());
        if (clazz2 == null) {
            Intrinsics.throwNpe();
        }
        Class<? extends EntityMutant> clazz3 = clazz = clazz2;
        Intrinsics.checkExpressionValueIsNotNull(clazz3, "renderclass");
        kjui kjui2 = RenderMutant.Companion.getCachedRenderer(clazz3, ((EntityCorpseAnimal)entityRagdollCorpse).getMobTypeId(), entityCorpseAnimal.getSkinId());
        CorpseAnimationHandler corpseAnimationHandler = entityCorpseAnimal.getAnimationHandler();
        if (corpseAnimationHandler != null && kjui2 != null && kjui2._i()) {
            EntityRagdollCorpse entityRagdollCorpse2 = entityCorpseAnimal;
            Object t = kjui2._u_();
            Intrinsics.checkExpressionValueIsNotNull(t, "mcsaRenderer.get()");
            RenderCorpse.renderCorpseInternal$default(this, entityRagdollCorpse2, corpseAnimationHandler, (ugqx)t, 0.0f, 8, null);
        }
    }
}

