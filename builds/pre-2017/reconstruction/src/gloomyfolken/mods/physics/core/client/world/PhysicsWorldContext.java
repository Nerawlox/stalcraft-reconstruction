/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import gloomyfolken.mods.physics.core.client.DefaultContextSetup;
import gloomyfolken.mods.physics.core.client.DelegatedContextSetup;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import gloomyfolken.mods.physics.core.client.utils.BulletHelper;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldRenderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u001c\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0006\u0010+\u001a\u00020)J\u0011\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0001H\u0096\u0003J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0018H\u0016J\u0006\u00100\u001a\u00020\u001bJ\t\u00101\u001a\u00020\u001bH\u0096\u0001J\t\u00102\u001a\u00020\u0012H\u0096\u0001J\b\u00103\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u001bH\u0016J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0018H\u0014J\u000e\u00108\u001a\u00020)2\u0006\u00107\u001a\u00020\u0018J\u0011\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010;\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0012H\u0096\u0001J\b\u0010<\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\t\u0010>\u001a\u00020\u0012H\u0096\u0001J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0018H\u0016J\b\u0010A\u001a\u00020)H\u0016J\u0010\u0010B\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0018H\u0016J\t\u0010C\u001a\u00020\u0012H\u0096\u0001J\t\u0010D\u001a\u00020\u0012H\u0096\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u00a8\u0006E"}, d2={"Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "Lgloomyfolken/mods/physics/core/client/DelegatedContextSetup;", "worldRef", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "(Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;)V", "bulletHelper", "Lgloomyfolken/mods/physics/core/client/utils/BulletHelper;", "getBulletHelper", "()Lgloomyfolken/mods/physics/core/client/utils/BulletHelper;", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "physicsRenderer", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldRenderer;", "getPhysicsRenderer", "()Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldRenderer;", "shouldSimulationStop", "", "getShouldSimulationStop", "()Z", "setShouldSimulationStop", "(Z)V", "simulationTimeLeftover", "", "users", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/physics/core/client/PhysicsEntityContext;", "Lkotlin/collections/HashMap;", "getUsers", "()Ljava/util/HashMap;", "worldAabbMax", "Ljavax/vecmath/Vector3f;", "getWorldAabbMax", "()Ljavax/vecmath/Vector3f;", "worldAabbMin", "getWorldAabbMin", "getWorldRef", "()Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "addUserInWorld", "", "user", "clearWorldUsers", "compareTo", "other", "getDtTime", "dtRealTime", "getMaxSubsteps", "priority", "readyForSetup", "release", "removeUserFromWorld", "id", "render", "partialTickTime", "renderTick", "setWasReleased", "flag", "setWasSetup", "setup", "shouldDoDebugRendering", "skipLagCheck", "updateContext", "dt", "updateMcClientState", "updatePhysics", "wasReleased", "wasSetup", "minecraft"})
public abstract class PhysicsWorldContext
implements DelegatedContextSetup {
    @NotNull
    private final BulletHelper bulletHelper;
    private boolean shouldSimulationStop;
    @NotNull
    private final PhysicsWorldRenderer physicsRenderer;
    @NotNull
    private final Vector3f worldAabbMin;
    @NotNull
    private final Vector3f worldAabbMax;
    @NotNull
    private final HashMap<Integer, PhysicsEntityContext> users;
    private float simulationTimeLeftover;
    @NotNull
    private final DynamicsWorldRef worldRef;
    private final /* synthetic */ DefaultContextSetup $$delegate_0;

    @NotNull
    public final BulletHelper getBulletHelper() {
        return this.bulletHelper;
    }

    public final boolean getShouldSimulationStop() {
        return this.shouldSimulationStop;
    }

    public final void setShouldSimulationStop(boolean bl) {
        this.shouldSimulationStop = bl;
    }

    @NotNull
    protected final PhysicsWorldRenderer getPhysicsRenderer() {
        return this.physicsRenderer;
    }

    @NotNull
    protected final Minecraft getMc() {
        Minecraft minecraft = Minecraft._E();
        Intrinsics.checkExpressionValueIsNotNull(minecraft, "Minecraft.getMinecraft()");
        return minecraft;
    }

    @NotNull
    public final Vector3f getWorldAabbMin() {
        return this.worldAabbMin;
    }

    @NotNull
    public final Vector3f getWorldAabbMax() {
        return this.worldAabbMax;
    }

    @NotNull
    protected final HashMap<Integer, PhysicsEntityContext> getUsers() {
        return this.users;
    }

    @Override
    public boolean setup() {
        return true;
    }

    public boolean shouldDoDebugRendering() {
        return this.getMc()._M.showDebugInfo && this.wasSetup();
    }

    public void addUserInWorld(@NotNull PhysicsEntityContext physicsEntityContext) {
        Intrinsics.checkParameterIsNotNull(physicsEntityContext, "user");
        this.users.putIfAbsent(physicsEntityContext.getPhysicsState().getOwnerEntity().entityId, physicsEntityContext);
    }

    public void removeUserFromWorld(@NotNull PhysicsEntityContext physicsEntityContext) {
        Intrinsics.checkParameterIsNotNull(physicsEntityContext, "user");
        this.removeUserFromWorld(physicsEntityContext.getPhysicsState().getOwnerEntity().entityId);
    }

    public void removeUserFromWorld(int n) {
        block0: {
            PhysicsEntityContext physicsEntityContext = this.users.remove(n);
            if (physicsEntityContext == null) break block0;
            physicsEntityContext.release();
        }
    }

    public final void clearWorldUsers() {
        Iterable iterable = this.users.keySet();
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList();
        Object object = iterable2.iterator();
        while (object.hasNext()) {
            Object t = object.next();
            Integer n = (Integer)t;
            if (!true) continue;
            collection2.add(t);
        }
        iterable = (List)collection2;
        for (Collection collection2 : iterable) {
            Object object2 = object = (Integer)((Object)collection2);
            Intrinsics.checkExpressionValueIsNotNull(object2, "it");
            this.removeUserFromWorld((Integer)object2);
        }
    }

    public void updatePhysics(float f) {
        float f2;
        int n = this.getMaxSubsteps();
        float f3 = 0.016666668f;
        float f4 = owkq._b(f * 1.25f, 0.0f, f3 * (float)n);
        for (f2 = f4 + this.simulationTimeLeftover; f2 >= f3; f2 -= f3) {
            this.updateContext(f3);
            this.worldRef.getDynamicsWorld().stepSimulation(f3, 1, f3);
        }
        this.simulationTimeLeftover = f2;
    }

    public void updateContext(float f) {
        Iterable iterable = this.users.values();
        for (Object t : iterable) {
            PhysicsEntityContext physicsEntityContext = (PhysicsEntityContext)t;
            physicsEntityContext.updateContext(f);
        }
    }

    public final int getMaxSubsteps() {
        return 5;
    }

    public float getDtTime(float f) {
        return f;
    }

    @Override
    public void release() {
        this.clearWorldUsers();
    }

    public void updateMcClientState() {
        Iterable iterable = this.users.values();
        for (Object t : iterable) {
            PhysicsEntityContext physicsEntityContext = (PhysicsEntityContext)t;
            physicsEntityContext.updateEntityState();
        }
    }

    protected void render(float f) {
        this.physicsRenderer.renderme(this.worldRef.getDynamicsWorld());
    }

    public final void renderTick(float f) {
        if (this.shouldDoDebugRendering()) {
            this.render(f);
        }
    }

    @NotNull
    public final DynamicsWorldRef getWorldRef() {
        return this.worldRef;
    }

    public PhysicsWorldContext(@NotNull DynamicsWorldRef dynamicsWorldRef) {
        Intrinsics.checkParameterIsNotNull(dynamicsWorldRef, "worldRef");
        this.$$delegate_0 = new DefaultContextSetup();
        this.worldRef = dynamicsWorldRef;
        this.bulletHelper = new BulletHelper();
        this.physicsRenderer = new PhysicsWorldRenderer(this);
        this.worldAabbMin = new Vector3f();
        this.worldAabbMax = new Vector3f();
        PhysicsWorldContext physicsWorldContext = this;
        HashMap hashMap = new HashMap();
        physicsWorldContext.users = hashMap;
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

