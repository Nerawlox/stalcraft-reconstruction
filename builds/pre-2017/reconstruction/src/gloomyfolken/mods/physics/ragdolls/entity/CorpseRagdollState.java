/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.EntityPhysicsState;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldPool;
import gloomyfolken.mods.physics.core.client.world.PhysicsManager;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseConstructionInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SavedAnimationStateEntry;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0015\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0001\u00a2\u0006\u0002\b$J\u0012\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u001fH\u0017R\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/CorpseRagdollState;", "Lgloomyfolken/mods/physics/core/EntityPhysicsState;", "()V", "deathPos", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "getDeathPos", "()Lnet/minecraft/util/Vec3;", "setDeathPos", "(Lnet/minecraft/util/Vec3;)V", "deathScale", "", "getDeathScale", "()F", "setDeathScale", "(F)V", "deathYaw", "getDeathYaw", "setDeathYaw", "ragdollContext", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "getClientPhysicsContext", "getOwnerEntity", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "init", "", "entity", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/world/World;", "initClientPhysicsContext", "Lgloomyfolken/mods/physics/core/client/PhysicsEntityContext;", "onEntityJoinedWorld", "restoreRagdollState", "corpseState", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SavedAnimationStateEntry;", "restoreRagdollState$minecraft", "setClientPhysicsContext", "ctx", "minecraft"})
public final class CorpseRagdollState
extends EntityPhysicsState {
    @ezey(_a={eidj.CLIENT})
    private CorpseRagdollContext ragdollContext;
    private Vec3 deathPos = VecExtensionsKt.vec3();
    private float deathYaw;
    private float deathScale = 1.0f;

    public final Vec3 getDeathPos() {
        return this.deathPos;
    }

    public final void setDeathPos(Vec3 vec3) {
        this.deathPos = vec3;
    }

    public final float getDeathYaw() {
        return this.deathYaw;
    }

    public final void setDeathYaw(float f) {
        this.deathYaw = f;
    }

    public final float getDeathScale() {
        return this.deathScale;
    }

    public final void setDeathScale(float f) {
        this.deathScale = f;
    }

    @Override
    public void init(@NotNull Entity entity, @NotNull World world) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(world, "world");
        if (!(entity instanceof EntityRagdollCorpse)) {
            throw (Throwable)new IllegalArgumentException("Couldn't create CorpseRagdollState with entity that is not an instance ofEntityRagdollCorpse!");
        }
        super.init(entity, world);
    }

    @Override
    public void onEntityJoinedWorld(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        if (this.getOwnerEntity().isLeftovers()) {
            return;
        }
        this.getOwnerEntity().setPhysicsState(this);
        Vec3 vec3 = this.getOwnerEntity().getOwnerDeathPos();
        Intrinsics.checkExpressionValueIsNotNull(vec3, "getOwnerEntity().ownerDeathPos");
        VecExtensionsKt.set(this.deathPos, vec3);
        this.deathYaw = this.getOwnerEntity().getOwnerDeathYaw();
        this.deathScale = this.getOwnerEntity().getOwnerScale();
        if (world.isRemote) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ CorpseRagdollState this$0;

                public final void run() {
                    block0: {
                        this.this$0.setClientPhysicsContext(this.this$0.initClientPhysicsContext());
                        CorpseAnimationHandler corpseAnimationHandler = this.this$0.getOwnerEntity().getAnimationHandler();
                        if (corpseAnimationHandler == null) break block0;
                        corpseAnimationHandler.tick();
                    }
                }
                {
                    this.this$0 = corpseRagdollState;
                }
            });
            this.getOwnerEntity().killOwner();
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @Nullable
    public PhysicsEntityContext initClientPhysicsContext() {
        SavedAnimationStateEntry savedAnimationStateEntry = RagdollsMod.instance.getSavedRagdollState(this.getOwnerEntity().entityId);
        if (savedAnimationStateEntry == null) {
            RagdollWorldContext ragdollWorldContext = new RagdollWorldContext(DynamicsWorldPool.getNextFreeDynamicsWorld$default(PhysicsManager.INSTANCE.getWorldPool(), null, 1, null));
            CorpseRagdollContext corpseRagdollContext = new CorpseRagdollContext(this);
            corpseRagdollContext.setWorldContext(ragdollWorldContext);
            corpseRagdollContext.setCorpseConstructionInfo(new CorpseConstructionInfo(this.getOwnerEntity().getCorpseInitialState(), -this.deathYaw, null, this.deathScale, false, 16, null));
            ragdollWorldContext.addUserInWorld(corpseRagdollContext);
            PhysicsManager.INSTANCE.addDelegatedContextSetup(ragdollWorldContext);
            PhysicsManager.INSTANCE.addDelegatedContextSetup(corpseRagdollContext);
            return corpseRagdollContext;
        }
        this.restoreRagdollState$minecraft(savedAnimationStateEntry);
        return null;
    }

    @ezey(_a={eidj.CLIENT})
    public final void restoreRagdollState$minecraft(@NotNull SavedAnimationStateEntry savedAnimationStateEntry) {
        Intrinsics.checkParameterIsNotNull(savedAnimationStateEntry, "corpseState");
        this.getOwnerEntity().setInitialDeath(true);
        VecExtensionsKt.set(this.getOwnerEntity().getPhysCorpseWorldPos(), savedAnimationStateEntry.getPos());
        this.getOwnerEntity().rotationYaw = 0.0f;
        this.getOwnerEntity().boundingBox._c(savedAnimationStateEntry.getAabb());
        this.getOwnerEntity().width = (float)owkq._d(savedAnimationStateEntry.getAabb()._g - savedAnimationStateEntry.getAabb()._d, savedAnimationStateEntry.getAabb()._e - savedAnimationStateEntry.getAabb()._b);
        this.getOwnerEntity().height = (float)(savedAnimationStateEntry.getAabb()._f - savedAnimationStateEntry.getAabb()._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @Nullable
    public CorpseRagdollContext getClientPhysicsContext() {
        return this.ragdollContext;
    }

    @Override
    @NotNull
    public EntityRagdollCorpse getOwnerEntity() {
        Entity entity = this.getEntity();
        if (entity == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse");
        }
        return (EntityRagdollCorpse)entity;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void setClientPhysicsContext(@Nullable PhysicsEntityContext physicsEntityContext) {
        if (physicsEntityContext instanceof CorpseRagdollContext) {
            this.ragdollContext = (CorpseRagdollContext)physicsEntityContext;
        }
    }
}

