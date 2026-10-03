/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.client.render.AnimationEntryRagdoll;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationStateDynamic;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationStateFrozen;
import gloomyfolken.mods.physics.ragdolls.client.render.ICorpseAnimationState;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;", "", "corpse", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "state", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "(Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;)V", "getCorpse", "()Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "<set-?>", "Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;", "ctx", "getCtx", "()Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;", "setCtx", "(Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;)V", "dynamicState", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationStateDynamic;", "enteredCorpseState", "", "firstTick", "frozenState", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationStateFrozen;", "getAnimationState", "Lgloomyfolken/mods/physics/ragdolls/client/render/ICorpseAnimationState;", "saveRagdollState", "", "setRagdollCorpse", "ragdollCorpse", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "tick", "Companion", "minecraft"})
public final class CorpseAnimationHandler {
    @NotNull
    private nuct ctx;
    private CorpseAnimationStateDynamic dynamicState;
    private CorpseAnimationStateFrozen frozenState;
    private boolean firstTick;
    private boolean enteredCorpseState;
    @NotNull
    private final EntityRagdollCorpse corpse;
    @NotNull
    private static final nuco animationLayer;
    public static final Companion Companion;

    @NotNull
    public final nuct getCtx() {
        return this.ctx;
    }

    private final void setCtx(nuct nuct2) {
        this.ctx = nuct2;
    }

    public final void tick() {
        CorpseRagdollContext corpseRagdollContext;
        CorpseRagdollState corpseRagdollState = this.corpse.getPhysicsState();
        CorpseRagdollContext corpseRagdollContext2 = corpseRagdollContext = corpseRagdollState != null ? corpseRagdollState.getClientPhysicsContext() : null;
        if (corpseRagdollContext != null) {
            RagdollCorpse ragdollCorpse = corpseRagdollContext.getCorpse();
            if (!this.enteredCorpseState() && corpseRagdollContext.wasSetup() && ragdollCorpse != null) {
                this.enteredCorpseState = true;
                this.setRagdollCorpse(ragdollCorpse);
                corpseRagdollContext.updateOwnerPosBounds();
                Entity entity = this.corpse;
                Vec3 vec3 = this.corpse.getPhysCorpseWorldPos();
                Intrinsics.checkExpressionValueIsNotNull(vec3, "corpse.physCorpseWorldPos");
                McExtensionsKt.setPrevPos(entity, vec3);
                Entity entity2 = this.corpse;
                Vec3 vec32 = this.corpse.getPhysCorpseWorldPos();
                Intrinsics.checkExpressionValueIsNotNull(vec32, "corpse.physCorpseWorldPos");
                McExtensionsKt.setLastTickPos(entity2, vec32);
                Entity entity3 = this.corpse;
                Vec3 vec33 = this.corpse.getPhysCorpseWorldPos();
                Intrinsics.checkExpressionValueIsNotNull(vec33, "corpse.physCorpseWorldPos");
                McExtensionsKt.setPos(entity3, vec33);
            }
            if (corpseRagdollContext.wasReleased() && this.dynamicState != null) {
                CorpseAnimationStateDynamic corpseAnimationStateDynamic = this.dynamicState;
                if (corpseAnimationStateDynamic == null) {
                    Intrinsics.throwNpe();
                }
                corpseAnimationStateDynamic.interpolate(0.0f);
                CorpseAnimationStateDynamic corpseAnimationStateDynamic2 = this.dynamicState;
                if (corpseAnimationStateDynamic2 == null) {
                    Intrinsics.throwNpe();
                }
                this.frozenState.setFromDynamicState(corpseAnimationStateDynamic2);
                this.dynamicState = null;
                this.saveRagdollState();
            }
        }
        if (this.firstTick) {
            this.firstTick = false;
            this.ctx._b();
        }
        this.ctx._b();
    }

    public final void saveRagdollState() {
        CorpseRagdollContext corpseRagdollContext;
        CorpseRagdollState corpseRagdollState = this.corpse.getPhysicsState();
        CorpseRagdollContext corpseRagdollContext2 = corpseRagdollContext = corpseRagdollState != null ? corpseRagdollState.getClientPhysicsContext() : null;
        if (corpseRagdollContext != null) {
            Vec3 vec3 = this.corpse.getPhysCorpseWorldPos();
            Intrinsics.checkExpressionValueIsNotNull(vec3, "corpse.physCorpseWorldPos");
            Vec3 vec32 = VecExtensionsKt.vec3(vec3);
            ivtm ivtm2 = new ivtm(this.frozenState.getState());
            Object[] objectArray = ivtm2._a;
            for (int i = 0; i < objectArray.length; ++i) {
                Object object = objectArray[i];
                Vector3f vector3f = (Vector3f)object;
                vector3f.scale(1.0f / this.corpse.getOwnerScale());
            }
            RagdollsMod.instance.saveRagdollState(this.corpse.entityId, ivtm2, vec32, this.corpse.boundingBox);
        }
    }

    public final boolean enteredCorpseState() {
        return this.enteredCorpseState;
    }

    public final void setRagdollCorpse(@NotNull RagdollCorpse ragdollCorpse) {
        Intrinsics.checkParameterIsNotNull(ragdollCorpse, "ragdollCorpse");
        this.dynamicState = new CorpseAnimationStateDynamic(ragdollCorpse);
    }

    @NotNull
    public final ICorpseAnimationState getAnimationState() {
        CorpseAnimationStateDynamic corpseAnimationStateDynamic = this.dynamicState;
        return corpseAnimationStateDynamic != null ? (ICorpseAnimationState)corpseAnimationStateDynamic : (ICorpseAnimationState)this.frozenState;
    }

    @NotNull
    public final EntityRagdollCorpse getCorpse() {
        return this.corpse;
    }

    public CorpseAnimationHandler(@NotNull EntityRagdollCorpse entityRagdollCorpse, @NotNull ivtm ivtm2) {
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "corpse");
        Intrinsics.checkParameterIsNotNull(ivtm2, "state");
        this.corpse = entityRagdollCorpse;
        this.frozenState = new CorpseAnimationStateFrozen(new ivtm(ivtm2), this.corpse.getOwnerScale());
        this.firstTick = true;
        this.ctx = this.corpse.createAnimationContext();
        this.ctx._b(new AnimationEntryRagdoll(Companion.getAnimationLayer(), this));
    }

    static {
        Companion = new Companion(null);
        animationLayer = new nuco();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler$Companion;", "", "()V", "animationLayer", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "getAnimationLayer", "()Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "minecraft"})
    public static final class Companion {
        @NotNull
        public final nuco getAnimationLayer() {
            return animationLayer;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

