/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.client.render.ModelGenericPlaceholder;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\fH\u0004\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpse;", "Lnet/minecraft/client/renderer/entity/RenderLiving;", "()V", "doRender", "", "entity", "Lnet/minecraft/entity/Entity;", "translateX", "", "translateY", "translateZ", "f", "", "frame", "getEntityTexture", "", "prepareRenderCorpse", "entityRagdollCorpse", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "renderCorpseInternal", "mob", "animationHandler", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;", "mcsaRenderer", "Lgloomyfolken/mods/effects/client/mcsa/McsaRenderer;", "scale", "minecraft"})
public abstract class RenderCorpse
extends RenderLiving {
    @Nullable
    protected Void getEntityTexture(@Nullable Entity entity) {
        return null;
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return (ResourceLocation)((Object)this.getEntityTexture(entity));
    }

    @Override
    public void doRender(@NotNull Entity entity, double d, double d2, double d3, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        if (entity instanceof ILeftoversRenderInfo && ((ILeftoversRenderInfo)((Object)entity)).shouldUseLeftoversRenderer()) {
            RenderCorpseLeftovers.Companion.getInstance().doRender(entity, d, d2, d3, f, f2);
        } else {
            ezfc._a();
            ezfc._a((float)d, (float)d2, (float)d3);
            this.prepareRenderCorpse((EntityRagdollCorpse)entity, f2);
            ezfc._b();
        }
    }

    public void prepareRenderCorpse(@NotNull EntityRagdollCorpse entityRagdollCorpse, float f) {
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "entityRagdollCorpse");
    }

    protected final void renderCorpseInternal(@NotNull EntityRagdollCorpse entityRagdollCorpse, @NotNull CorpseAnimationHandler corpseAnimationHandler, @NotNull ugqx ugqx2, float f) {
        CorpseRagdollContext corpseRagdollContext;
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "mob");
        Intrinsics.checkParameterIsNotNull(corpseAnimationHandler, "animationHandler");
        Intrinsics.checkParameterIsNotNull(ugqx2, "mcsaRenderer");
        CorpseRagdollState corpseRagdollState = entityRagdollCorpse.getPhysicsState();
        CorpseRagdollContext corpseRagdollContext2 = corpseRagdollContext = corpseRagdollState != null ? corpseRagdollState.getClientPhysicsContext() : null;
        if (corpseRagdollContext != null && corpseRagdollContext.wasReleased() || entityRagdollCorpse.getInitialDeath()) {
            if (!corpseAnimationHandler.enteredCorpseState() && !(entityRagdollCorpse instanceof EntityCorpseBiped)) {
                ezfc._a(-entityRagdollCorpse.rotationYaw, 0.0f, 1.0f, 0.0f);
            }
            ezfc._b(entityRagdollCorpse.getOwnerScale(), entityRagdollCorpse.getOwnerScale(), entityRagdollCorpse.getOwnerScale());
            ezfc._b(f, f, f);
            ugqx2._b().renderAll(corpseAnimationHandler.getCtx());
        }
    }

    public static /* synthetic */ void renderCorpseInternal$default(RenderCorpse renderCorpse, EntityRagdollCorpse entityRagdollCorpse, CorpseAnimationHandler corpseAnimationHandler, ugqx ugqx2, float f, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderCorpseInternal");
        }
        if ((n & 8) != 0) {
            f = 1.0f;
        }
        renderCorpse.renderCorpseInternal(entityRagdollCorpse, corpseAnimationHandler, ugqx2, f);
    }

    public RenderCorpse() {
        super(new ModelGenericPlaceholder(), 0.0f);
    }
}

