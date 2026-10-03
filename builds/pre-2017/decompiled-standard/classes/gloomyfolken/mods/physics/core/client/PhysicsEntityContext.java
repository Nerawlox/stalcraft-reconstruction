/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import gloomyfolken.mods.physics.core.EntityPhysicsState;
import gloomyfolken.mods.physics.core.PhysicsImpulse;
import gloomyfolken.mods.physics.core.client.DefaultContextSetup;
import gloomyfolken.mods.physics.core.client.DelegatedContextSetup;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0096\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&J\t\u0010\u0015\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0011\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\t\u0010\u001f\u001a\u00020\u0017H\u0096\u0001J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\t\u0010%\u001a\u00020\u0017H\u0096\u0001J\t\u0010&\u001a\u00020\u0017H\u0096\u0001R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/physics/core/client/PhysicsEntityContext;", "Lgloomyfolken/mods/physics/core/client/DelegatedContextSetup;", "state", "Lgloomyfolken/mods/physics/core/EntityPhysicsState;", "(Lgloomyfolken/mods/physics/core/EntityPhysicsState;)V", "<set-?>", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "_physCtx", "get_physCtx", "()Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "set_physCtx", "(Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;)V", "applyImpulse", "", "physicsImpulse", "Lgloomyfolken/mods/physics/core/PhysicsImpulse;", "compareTo", "", "other", "getPhysicsState", "getWorldContext", "priority", "readyForSetup", "", "release", "setWasReleased", "flag", "setWasSetup", "setWorldContext", "physicsWorldContext", "setup", "skipLagCheck", "updateContext", "dt", "", "updateEntityState", "updateOwnerPosBounds", "wasReleased", "wasSetup", "minecraft"})
public abstract class PhysicsEntityContext
implements DelegatedContextSetup {
    @Nullable
    private PhysicsWorldContext _physCtx;
    private final EntityPhysicsState state;
    private final /* synthetic */ DefaultContextSetup $$delegate_0;

    @Nullable
    protected final PhysicsWorldContext get_physCtx() {
        return this._physCtx;
    }

    private final void set_physCtx(PhysicsWorldContext physicsWorldContext) {
        this._physCtx = physicsWorldContext;
    }

    @NotNull
    public EntityPhysicsState getPhysicsState() {
        return this.state;
    }

    @Override
    public boolean setup() {
        PhysicsWorldContext physicsWorldContext = this.getWorldContext();
        if (physicsWorldContext == null) {
            Intrinsics.throwNpe();
        }
        physicsWorldContext.addUserInWorld(this);
        return true;
    }

    public void updateEntityState() {
        this.updateOwnerPosBounds();
    }

    @Override
    public void release() {
        DelegatedContextSetup.DefaultImpls.release(this);
        this.setWorldContext(null);
    }

    public void updateContext(float f) {
    }

    public void applyImpulse(@NotNull PhysicsImpulse physicsImpulse) {
        Intrinsics.checkParameterIsNotNull(physicsImpulse, "physicsImpulse");
    }

    public void updateOwnerPosBounds() {
    }

    @Nullable
    public abstract PhysicsWorldContext getWorldContext();

    public void setWorldContext(@Nullable PhysicsWorldContext physicsWorldContext) {
        this._physCtx = physicsWorldContext;
    }

    public PhysicsEntityContext(@NotNull EntityPhysicsState entityPhysicsState) {
        Intrinsics.checkParameterIsNotNull(entityPhysicsState, "state");
        this.$$delegate_0 = new DefaultContextSetup();
        this.state = entityPhysicsState;
    }

    @Override
    public int compareTo(@NotNull DelegatedContextSetup delegatedContextSetup) {
        Intrinsics.checkParameterIsNotNull(delegatedContextSetup, "other");
        return this.$$delegate_0.compareTo(delegatedContextSetup);
    }

    @Override
    public int priority() {
        return this.$$delegate_0.priority();
    }

    @Override
    public boolean readyForSetup() {
        return this.$$delegate_0.readyForSetup();
    }

    @Override
    public void setWasReleased(boolean bl) {
        this.$$delegate_0.setWasReleased(bl);
    }

    @Override
    public void setWasSetup(boolean bl) {
        this.$$delegate_0.setWasSetup(bl);
    }

    @Override
    public boolean skipLagCheck() {
        return this.$$delegate_0.skipLagCheck();
    }

    @Override
    public boolean wasReleased() {
        return this.$$delegate_0.wasReleased();
    }

    @Override
    public boolean wasSetup() {
        return this.$$delegate_0.wasSetup();
    }
}

