/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import gloomyfolken.mods.physics.core.client.world.DefaultWorldSettings;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldSettings;
import java.util.ArrayList;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldPool;", "", "()V", "WORLD_CLEANUP_TIME", "", "lockObject", "Ljava/lang/Object;", "worldPool", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "Lkotlin/collections/ArrayList;", "getNextFreeDynamicsWorld", "worldSettings", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;", "releaseDynamicsWorld", "", "physicsWorld", "removeOldWorldsFromPool", "minecraft"})
public final class DynamicsWorldPool {
    private final long WORLD_CLEANUP_TIME = 30000L;
    private final ArrayList<DynamicsWorldRef> worldPool;
    private Object lockObject;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final DynamicsWorldRef getNextFreeDynamicsWorld(@NotNull PhysicsWorldSettings physicsWorldSettings) {
        Intrinsics.checkParameterIsNotNull(physicsWorldSettings, "worldSettings");
        Object object = this.lockObject;
        synchronized (object) {
            DynamicsWorldRef dynamicsWorldRef;
            Object v0;
            block5: {
                Iterable iterable = this.worldPool;
                for (Object t : iterable) {
                    DynamicsWorldRef dynamicsWorldRef2 = (DynamicsWorldRef)t;
                    if (!Intrinsics.areEqual(dynamicsWorldRef2.getWorldSettings(), physicsWorldSettings)) continue;
                    v0 = t;
                    break block5;
                }
                v0 = null;
            }
            if ((dynamicsWorldRef = (DynamicsWorldRef)v0) == null) {
                dynamicsWorldRef = physicsWorldSettings.createNewWorld();
            }
            DynamicsWorldRef dynamicsWorldRef3 = dynamicsWorldRef;
            this.worldPool.remove(dynamicsWorldRef3);
            DynamicsWorldRef dynamicsWorldRef4 = dynamicsWorldRef3;
            return dynamicsWorldRef4;
        }
    }

    @NotNull
    public static /* synthetic */ DynamicsWorldRef getNextFreeDynamicsWorld$default(DynamicsWorldPool dynamicsWorldPool, PhysicsWorldSettings physicsWorldSettings, int n, Object object) {
        if ((n & 1) != 0) {
            physicsWorldSettings = new DefaultWorldSettings();
        }
        return dynamicsWorldPool.getNextFreeDynamicsWorld(physicsWorldSettings);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void releaseDynamicsWorld(@NotNull DynamicsWorldRef dynamicsWorldRef) {
        Intrinsics.checkParameterIsNotNull(dynamicsWorldRef, "physicsWorld");
        Object object = this.lockObject;
        synchronized (object) {
            boolean bl = this.worldPool.add(dynamicsWorldRef);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void removeOldWorldsFromPool() {
        Object object = this.lockObject;
        synchronized (object) {
            boolean bl = this.worldPool.removeIf(new Predicate<DynamicsWorldRef>(this){
                final /* synthetic */ DynamicsWorldPool this$0;
                {
                    this.this$0 = dynamicsWorldPool;
                }

                public final boolean test(DynamicsWorldRef dynamicsWorldRef) {
                    return System.currentTimeMillis() > dynamicsWorldRef.getLastPhysicsUpdated() + DynamicsWorldPool.access$getWORLD_CLEANUP_TIME$p(this.this$0);
                }
            });
        }
    }

    public DynamicsWorldPool() {
        DynamicsWorldPool dynamicsWorldPool = this;
        ArrayList arrayList = new ArrayList();
        dynamicsWorldPool.worldPool = arrayList;
        DynamicsWorldPool dynamicsWorldPool2 = this;
        if (dynamicsWorldPool2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        this.lockObject = dynamicsWorldPool2;
    }

    public static final /* synthetic */ long access$getWORLD_CLEANUP_TIME$p(DynamicsWorldPool dynamicsWorldPool) {
        return dynamicsWorldPool.WORLD_CLEANUP_TIME;
    }
}

