/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.broadphase.OverlapCallback;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.DefaultNearCallback;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.dispatch.NearCallback;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import java.util.Collections;

public class CollisionDispatcher
extends Dispatcher {
    protected final ObjectPool<PersistentManifold> manifoldsPool = ObjectPool.get(PersistentManifold.class);
    private static final int MAX_BROADPHASE_COLLISION_TYPES = BroadphaseNativeType.MAX_BROADPHASE_COLLISION_TYPES.ordinal();
    private int count = 0;
    private final ObjectArrayList<PersistentManifold> manifoldsPtr = new ObjectArrayList();
    private boolean useIslands = true;
    private boolean staticWarningReported = false;
    private ManifoldResult defaultManifoldResult;
    private NearCallback nearCallback;
    private final CollisionAlgorithmCreateFunc[][] doubleDispatch = new CollisionAlgorithmCreateFunc[MAX_BROADPHASE_COLLISION_TYPES][MAX_BROADPHASE_COLLISION_TYPES];
    private CollisionConfiguration collisionConfiguration;
    private CollisionAlgorithmConstructionInfo tmpCI = new CollisionAlgorithmConstructionInfo();
    private CollisionPairCallback collisionPairCallback = new CollisionPairCallback();

    public CollisionDispatcher(CollisionConfiguration collisionConfiguration) {
        this.collisionConfiguration = collisionConfiguration;
        this.setNearCallback(new DefaultNearCallback());
        for (int i = 0; i < MAX_BROADPHASE_COLLISION_TYPES; ++i) {
            for (int j = 0; j < MAX_BROADPHASE_COLLISION_TYPES; ++j) {
                this.doubleDispatch[i][j] = collisionConfiguration.getCollisionAlgorithmCreateFunc(BroadphaseNativeType.forValue(i), BroadphaseNativeType.forValue(j));
                assert (this.doubleDispatch[i][j] != null);
            }
        }
    }

    public void registerCollisionCreateFunc(int proxyType0, int proxyType1, CollisionAlgorithmCreateFunc createFunc) {
        this.doubleDispatch[proxyType0][proxyType1] = createFunc;
    }

    public NearCallback getNearCallback() {
        return this.nearCallback;
    }

    public void setNearCallback(NearCallback nearCallback) {
        this.nearCallback = nearCallback;
    }

    public CollisionConfiguration getCollisionConfiguration() {
        return this.collisionConfiguration;
    }

    public void setCollisionConfiguration(CollisionConfiguration collisionConfiguration) {
        this.collisionConfiguration = collisionConfiguration;
    }

    @Override
    public CollisionAlgorithm findAlgorithm(CollisionObject body0, CollisionObject body1, PersistentManifold sharedManifold) {
        CollisionAlgorithmConstructionInfo ci = this.tmpCI;
        ci.dispatcher1 = this;
        ci.manifold = sharedManifold;
        CollisionAlgorithmCreateFunc createFunc = this.doubleDispatch[body0.getCollisionShape().getShapeType().ordinal()][body1.getCollisionShape().getShapeType().ordinal()];
        CollisionAlgorithm algo = createFunc.createCollisionAlgorithm(ci, body0, body1);
        algo.internalSetCreateFunc(createFunc);
        return algo;
    }

    @Override
    public void freeCollisionAlgorithm(CollisionAlgorithm algo) {
        CollisionAlgorithmCreateFunc createFunc = algo.internalGetCreateFunc();
        algo.internalSetCreateFunc(null);
        createFunc.releaseCollisionAlgorithm(algo);
        algo.destroy();
    }

    @Override
    public PersistentManifold getNewManifold(Object b0, Object b1) {
        CollisionObject body0 = (CollisionObject)b0;
        CollisionObject body1 = (CollisionObject)b1;
        PersistentManifold manifold = this.manifoldsPool.get();
        manifold.init(body0, body1, 0);
        manifold.index1a = this.manifoldsPtr.size();
        this.manifoldsPtr.add(manifold);
        return manifold;
    }

    @Override
    public void releaseManifold(PersistentManifold manifold) {
        this.clearManifold(manifold);
        int findIndex = manifold.index1a;
        assert (findIndex < this.manifoldsPtr.size());
        Collections.swap(this.manifoldsPtr, findIndex, this.manifoldsPtr.size() - 1);
        this.manifoldsPtr.getQuick((int)findIndex).index1a = findIndex;
        this.manifoldsPtr.removeQuick(this.manifoldsPtr.size() - 1);
        this.manifoldsPool.release(manifold);
    }

    @Override
    public void clearManifold(PersistentManifold manifold) {
        manifold.clearManifold();
    }

    @Override
    public boolean needsCollision(CollisionObject body0, CollisionObject body1) {
        assert (body0 != null);
        assert (body1 != null);
        boolean needsCollision = true;
        if (!this.staticWarningReported && (body0.isStaticObject() || body0.isKinematicObject()) && (body1.isStaticObject() || body1.isKinematicObject())) {
            this.staticWarningReported = true;
            System.err.println("warning CollisionDispatcher.needsCollision: static-static collision!");
        }
        if (!body0.isActive() && !body1.isActive()) {
            needsCollision = false;
        } else if (!body0.checkCollideWith(body1)) {
            needsCollision = false;
        }
        return needsCollision;
    }

    @Override
    public boolean needsResponse(CollisionObject body0, CollisionObject body1) {
        boolean hasResponse = body0.hasContactResponse() && body1.hasContactResponse();
        hasResponse = hasResponse && (!body0.isStaticOrKinematicObject() || !body1.isStaticOrKinematicObject());
        return hasResponse;
    }

    @Override
    public void dispatchAllCollisionPairs(OverlappingPairCache pairCache, DispatcherInfo dispatchInfo, Dispatcher dispatcher) {
        this.collisionPairCallback.init(dispatchInfo, this);
        pairCache.processAllOverlappingPairs(this.collisionPairCallback, dispatcher);
    }

    @Override
    public int getNumManifolds() {
        return this.manifoldsPtr.size();
    }

    @Override
    public PersistentManifold getManifoldByIndexInternal(int index) {
        return this.manifoldsPtr.getQuick(index);
    }

    @Override
    public ObjectArrayList<PersistentManifold> getInternalManifoldPointer() {
        return this.manifoldsPtr;
    }

    private static class CollisionPairCallback
    extends OverlapCallback {
        private DispatcherInfo dispatchInfo;
        private CollisionDispatcher dispatcher;

        private CollisionPairCallback() {
        }

        public void init(DispatcherInfo dispatchInfo, CollisionDispatcher dispatcher) {
            this.dispatchInfo = dispatchInfo;
            this.dispatcher = dispatcher;
        }

        @Override
        public boolean processOverlap(BroadphasePair pair) {
            this.dispatcher.getNearCallback().handleCollision(pair, this.dispatcher, this.dispatchInfo);
            return false;
        }
    }
}

