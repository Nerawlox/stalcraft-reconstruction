/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import gloomyfolken.mods.physics.core.client.DelegatedContextSetup;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldPool;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.core.client.world.PhysicsManager;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.eidj;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0018J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\""}, d2={"Lgloomyfolken/mods/physics/core/client/world/PhysicsManager;", "", "()V", "MAX_ACTIVE_WORLDS", "", "PHYS_TICK_TIME_ABORT", "", "activePhysicsWorlds", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "Lkotlin/collections/ArrayList;", "localPendingContexts", "Lgloomyfolken/mods/physics/core/client/DelegatedContextSetup;", "pendingContexts", "worldPool", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldPool;", "getWorldPool", "()Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldPool;", "addDelegatedContextSetup", "", "setup", "clearAll", "clientTick", "physicsTick", "", "tickTimeLeft", "registerDelegatedContext", "contextSetup", "removeActiveWorld", "worldRef", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "renderTick", "partialTickTime", "setupPendingWorlds", "minecraft"})
public final class PhysicsManager {
    private static final int MAX_ACTIVE_WORLDS = 6;
    private static final long PHYS_TICK_TIME_ABORT = 400L;
    @NotNull
    private static final DynamicsWorldPool worldPool;
    private static final ArrayList<PhysicsWorldContext> activePhysicsWorlds;
    private static final ArrayList<DelegatedContextSetup> pendingContexts;
    private static final ArrayList<DelegatedContextSetup> localPendingContexts;
    public static final PhysicsManager INSTANCE;

    @NotNull
    public final DynamicsWorldPool getWorldPool() {
        return worldPool;
    }

    public final void clientTick() {
        Iterable iterable = activePhysicsWorlds;
        for (Object t : iterable) {
            PhysicsWorldContext physicsWorldContext = (PhysicsWorldContext)t;
            physicsWorldContext.updateMcClientState();
        }
        activePhysicsWorlds.removeIf(clientTick.2.INSTANCE);
        worldPool.removeOldWorldsFromPool();
    }

    private final void removeActiveWorld(DynamicsWorldRef dynamicsWorldRef) {
        DynamicsWorldRef dynamicsWorldRef2 = dynamicsWorldRef.getWorldSettings().createNewWorld();
        dynamicsWorldRef2.setLastPhysicsUpdated(System.currentTimeMillis());
        worldPool.releaseDynamicsWorld(dynamicsWorldRef2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addDelegatedContextSetup(@NotNull DelegatedContextSetup delegatedContextSetup) {
        Intrinsics.checkParameterIsNotNull(delegatedContextSetup, "setup");
        ArrayList<DelegatedContextSetup> arrayList = pendingContexts;
        synchronized (arrayList) {
            pendingContexts.add(0, delegatedContextSetup);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void clearAll() {
        Unit unit;
        ArrayList<DelegatedContextSetup> arrayList = pendingContexts;
        synchronized (arrayList) {
            pendingContexts.clear();
            unit = Unit.INSTANCE;
        }
        arrayList = activePhysicsWorlds;
        synchronized (arrayList) {
            activePhysicsWorlds.clear();
            unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final float setupPendingWorlds(float f) {
        Collection collection;
        Object object;
        float f2 = f;
        localPendingContexts.clear();
        List<DelegatedContextSetup> list = pendingContexts;
        synchronized (list) {
            boolean n = localPendingContexts.addAll((Collection<DelegatedContextSetup>)pendingContexts);
        }
        list = localPendingContexts;
        if (list.size() > 1) {
            object = list;
            Comparator comparator = new Comparator<T>(){

                public final int compare(T t, T t2) {
                    DelegatedContextSetup delegatedContextSetup = (DelegatedContextSetup)t;
                    Comparable comparable = Integer.valueOf(delegatedContextSetup.priority());
                    delegatedContextSetup = (DelegatedContextSetup)t2;
                    Comparable comparable2 = comparable;
                    Integer n = delegatedContextSetup.priority();
                    return ComparisonsKt.compareValues(comparable2, (Comparable)n);
                }
            };
            CollectionsKt.sortWith(object, comparator);
        }
        while (f2 > 0.0f && !(collection = (Collection)localPendingContexts).isEmpty()) {
            int n2;
            block14: {
                int n;
                object = localPendingContexts;
                int n3 = 0;
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    boolean bl;
                    Object e = iterator2.next();
                    DelegatedContextSetup delegatedContextSetup = (DelegatedContextSetup)e;
                    if (!delegatedContextSetup.skipLagCheck() && activePhysicsWorlds.size() > MAX_ACTIVE_WORLDS) {
                        bl = false;
                    } else if (!delegatedContextSetup.readyForSetup()) {
                        bl = false;
                    } else {
                        long l = System.currentTimeMillis();
                        boolean bl2 = delegatedContextSetup.setup();
                        f2 -= (float)(System.currentTimeMillis() - l);
                        bl = bl2;
                    }
                    if (bl) {
                        n = n3;
                        break block14;
                    }
                    ++n3;
                }
                n = n2 = -1;
            }
            if (n2 < 0) break;
            object = localPendingContexts.remove(n2);
            object.setWasSetup(true);
            Object object2 = object;
            Intrinsics.checkExpressionValueIsNotNull(object2, "setup");
            this.registerDelegatedContext((DelegatedContextSetup)object2);
        }
        ArrayList<DelegatedContextSetup> arrayList = pendingContexts;
        synchronized (arrayList) {
            boolean bl = pendingContexts.removeIf(setupPendingWorlds.3.1.INSTANCE);
        }
        return f2;
    }

    private final void registerDelegatedContext(DelegatedContextSetup delegatedContextSetup) {
        DelegatedContextSetup delegatedContextSetup2 = delegatedContextSetup;
        if (delegatedContextSetup2 instanceof PhysicsWorldContext) {
            Collection collection = activePhysicsWorlds;
            collection.add(delegatedContextSetup);
        }
    }

    public final void renderTick(float f) {
        Iterable iterable = activePhysicsWorlds;
        for (Object t : iterable) {
            PhysicsWorldContext physicsWorldContext = (PhysicsWorldContext)t;
            physicsWorldContext.renderTick(f);
        }
    }

    public final float physicsTick(float f) {
        eidj._a()._a();
        float f2 = f;
        if (f2 > 0.0f) {
            Iterator iterator2;
            Object object;
            if ((f2 = this.setupPendingWorlds(f2)) <= 0.0f) {
                return f2;
            }
            Object object2 = activePhysicsWorlds;
            if (object2.size() > 1) {
                object = object2;
                iterator2 = new Comparator<T>(){

                    public final int compare(T t, T t2) {
                        PhysicsWorldContext physicsWorldContext = (PhysicsWorldContext)t;
                        Comparable comparable = Integer.valueOf(physicsWorldContext.priority());
                        physicsWorldContext = (PhysicsWorldContext)t2;
                        Comparable comparable2 = comparable;
                        Integer n = physicsWorldContext.priority();
                        return ComparisonsKt.compareValues(comparable2, (Comparable)n);
                    }
                };
                CollectionsKt.sortWith(object, iterator2);
            }
            object2 = this;
            object = (PhysicsManager)object2;
            Iterator iterator3 = iterator2 = (Iterable)activePhysicsWorlds;
            Collection<Object> collection = new ArrayList();
            Object object3 = iterator3.iterator();
            while (object3.hasNext()) {
                Object t = object3.next();
                PhysicsWorldContext physicsWorldContext = (PhysicsWorldContext)t;
                if (!(!physicsWorldContext.getShouldSimulationStop())) continue;
                collection.add(t);
            }
            iterator2 = (List)collection;
            iterator3 = iterator2.iterator();
            while (iterator3.hasNext()) {
                collection = iterator3.next();
                object3 = (PhysicsWorldContext)((Object)collection);
                float f3 = System.currentTimeMillis() - ((PhysicsWorldContext)object3).getWorldRef().getLastPhysicsUpdated();
                ((PhysicsWorldContext)object3).getWorldRef().setLastPhysicsUpdated(System.currentTimeMillis());
                long l = System.currentTimeMillis();
                ((PhysicsWorldContext)object3).updatePhysics(((PhysicsWorldContext)object3).getDtTime(owkq._c(f3 / (float)1000, 0.016f)));
                long l2 = System.currentTimeMillis() - l;
                if (l2 > PHYS_TICK_TIME_ABORT) {
                    ((PhysicsWorldContext)object3).setShouldSimulationStop(true);
                }
                if (!((f2 -= (float)l2) <= 0.0f)) continue;
                break;
            }
        }
        return f2;
    }

    private PhysicsManager() {
        INSTANCE = this;
        MAX_ACTIVE_WORLDS = 6;
        PHYS_TICK_TIME_ABORT = 400L;
        worldPool = new DynamicsWorldPool();
        activePhysicsWorlds = new ArrayList();
        pendingContexts = new ArrayList();
        localPendingContexts = new ArrayList();
    }

    static {
        new PhysicsManager();
    }

    public static final /* synthetic */ void access$removeActiveWorld(PhysicsManager physicsManager, @NotNull DynamicsWorldRef dynamicsWorldRef) {
        physicsManager.removeActiveWorld(dynamicsWorldRef);
    }
}

