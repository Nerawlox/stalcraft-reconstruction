/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.dispatch.UnionFind;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.util.ObjectArrayList;
import java.util.Comparator;

public class SimulationIslandManager {
    private final UnionFind unionFind = new UnionFind();
    private final ObjectArrayList<PersistentManifold> islandmanifold = new ObjectArrayList();
    private final ObjectArrayList<CollisionObject> islandBodies = new ObjectArrayList();
    private static final Comparator<PersistentManifold> persistentManifoldComparator = new Comparator<PersistentManifold>(){

        @Override
        public int compare(PersistentManifold lhs, PersistentManifold rhs) {
            return SimulationIslandManager.getIslandId(lhs) < SimulationIslandManager.getIslandId(rhs) ? -1 : 1;
        }
    };

    public void initUnionFind(int n) {
        this.unionFind.reset(n);
    }

    public UnionFind getUnionFind() {
        return this.unionFind;
    }

    public void findUnions(Dispatcher dispatcher, CollisionWorld colWorld) {
        ObjectArrayList<BroadphasePair> pairPtr = colWorld.getPairCache().getOverlappingPairArray();
        for (int i = 0; i < pairPtr.size(); ++i) {
            BroadphasePair collisionPair = pairPtr.getQuick(i);
            CollisionObject colObj0 = (CollisionObject)collisionPair.pProxy0.clientObject;
            CollisionObject colObj1 = (CollisionObject)collisionPair.pProxy1.clientObject;
            if (colObj0 == null || !colObj0.mergesSimulationIslands() || colObj1 == null || !colObj1.mergesSimulationIslands()) continue;
            this.unionFind.unite(colObj0.getIslandTag(), colObj1.getIslandTag());
        }
    }

    public void updateActivationState(CollisionWorld colWorld, Dispatcher dispatcher) {
        this.initUnionFind(colWorld.getCollisionObjectArray().size());
        int index = 0;
        for (int i = 0; i < colWorld.getCollisionObjectArray().size(); ++i) {
            CollisionObject collisionObject = colWorld.getCollisionObjectArray().getQuick(i);
            collisionObject.setIslandTag(index);
            collisionObject.setCompanionId(-1);
            collisionObject.setHitFraction(1.0f);
            ++index;
        }
        this.findUnions(dispatcher, colWorld);
    }

    public void storeIslandActivationState(CollisionWorld colWorld) {
        int index = 0;
        for (int i = 0; i < colWorld.getCollisionObjectArray().size(); ++i) {
            CollisionObject collisionObject = colWorld.getCollisionObjectArray().getQuick(i);
            if (!collisionObject.isStaticOrKinematicObject()) {
                collisionObject.setIslandTag(this.unionFind.find(index));
                collisionObject.setCompanionId(-1);
            } else {
                collisionObject.setIslandTag(-1);
                collisionObject.setCompanionId(-2);
            }
            ++index;
        }
    }

    private static int getIslandId(PersistentManifold lhs) {
        CollisionObject rcolObj0 = (CollisionObject)lhs.getBody0();
        CollisionObject rcolObj1 = (CollisionObject)lhs.getBody1();
        int islandId = rcolObj0.getIslandTag() >= 0 ? rcolObj0.getIslandTag() : rcolObj1.getIslandTag();
        return islandId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void buildIslands(Dispatcher dispatcher, ObjectArrayList<CollisionObject> collisionObjects) {
        BulletStats.pushProfile("islandUnionFindAndQuickSort");
        try {
            this.islandmanifold.clear();
            this.getUnionFind().sortIslands();
            int numElem = this.getUnionFind().getNumElements();
            int endIslandIndex = 1;
            int startIslandIndex = 0;
            while (startIslandIndex < numElem) {
                CollisionObject colObj0;
                int i;
                int idx;
                int islandId = this.getUnionFind().getElement((int)startIslandIndex).id;
                for (endIslandIndex = startIslandIndex + 1; endIslandIndex < numElem && this.getUnionFind().getElement((int)endIslandIndex).id == islandId; ++endIslandIndex) {
                }
                boolean allSleeping = true;
                for (idx = startIslandIndex; idx < endIslandIndex; ++idx) {
                    i = this.getUnionFind().getElement((int)idx).sz;
                    colObj0 = collisionObjects.getQuick(i);
                    if (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() != -1) {
                        // empty if block
                    }
                    assert (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() == -1);
                    if (colObj0.getIslandTag() != islandId) continue;
                    if (colObj0.getActivationState() == 1) {
                        allSleeping = false;
                    }
                    if (colObj0.getActivationState() != 4) continue;
                    allSleeping = false;
                }
                if (allSleeping) {
                    for (idx = startIslandIndex; idx < endIslandIndex; ++idx) {
                        i = this.getUnionFind().getElement((int)idx).sz;
                        colObj0 = collisionObjects.getQuick(i);
                        if (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() != -1) {
                            // empty if block
                        }
                        assert (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() == -1);
                        if (colObj0.getIslandTag() != islandId) continue;
                        colObj0.setActivationState(2);
                    }
                } else {
                    for (idx = startIslandIndex; idx < endIslandIndex; ++idx) {
                        i = this.getUnionFind().getElement((int)idx).sz;
                        colObj0 = collisionObjects.getQuick(i);
                        if (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() != -1) {
                            // empty if block
                        }
                        assert (colObj0.getIslandTag() == islandId || colObj0.getIslandTag() == -1);
                        if (colObj0.getIslandTag() != islandId || colObj0.getActivationState() != 2) continue;
                        colObj0.setActivationState(3);
                    }
                }
                startIslandIndex = endIslandIndex;
            }
            int maxNumManifolds = dispatcher.getNumManifolds();
            for (int i = 0; i < maxNumManifolds; ++i) {
                PersistentManifold manifold = dispatcher.getManifoldByIndexInternal(i);
                CollisionObject colObj0 = (CollisionObject)manifold.getBody0();
                CollisionObject colObj1 = (CollisionObject)manifold.getBody1();
                if ((colObj0 == null || colObj0.getActivationState() == 2) && (colObj1 == null || colObj1.getActivationState() == 2)) continue;
                if (colObj0.isKinematicObject() && colObj0.getActivationState() != 2) {
                    colObj1.activate();
                }
                if (colObj1.isKinematicObject() && colObj1.getActivationState() != 2) {
                    colObj0.activate();
                }
                if (!dispatcher.needsResponse(colObj0, colObj1)) continue;
                this.islandmanifold.add(manifold);
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void buildAndProcessIslands(Dispatcher dispatcher, ObjectArrayList<CollisionObject> collisionObjects, IslandCallback callback) {
        this.buildIslands(dispatcher, collisionObjects);
        int endIslandIndex = 1;
        int numElem = this.getUnionFind().getNumElements();
        BulletStats.pushProfile("processIslands");
        try {
            int numManifolds = this.islandmanifold.size();
            MiscUtil.quickSort(this.islandmanifold, persistentManifoldComparator);
            int startManifoldIndex = 0;
            int endManifoldIndex = 1;
            int startIslandIndex = 0;
            while (startIslandIndex < numElem) {
                int curIslandId;
                int islandId = this.getUnionFind().getElement((int)startIslandIndex).id;
                boolean islandSleeping = false;
                for (endIslandIndex = startIslandIndex; endIslandIndex < numElem && this.getUnionFind().getElement((int)endIslandIndex).id == islandId; ++endIslandIndex) {
                    int i = this.getUnionFind().getElement((int)endIslandIndex).sz;
                    CollisionObject colObj0 = collisionObjects.getQuick(i);
                    this.islandBodies.add(colObj0);
                    if (colObj0.isActive()) continue;
                    islandSleeping = true;
                }
                int numIslandManifolds = 0;
                int startManifold_idx = -1;
                if (startManifoldIndex < numManifolds && (curIslandId = SimulationIslandManager.getIslandId(this.islandmanifold.getQuick(startManifoldIndex))) == islandId) {
                    startManifold_idx = startManifoldIndex;
                    for (endManifoldIndex = startManifoldIndex + 1; endManifoldIndex < numManifolds && islandId == SimulationIslandManager.getIslandId(this.islandmanifold.getQuick(endManifoldIndex)); ++endManifoldIndex) {
                    }
                    numIslandManifolds = endManifoldIndex - startManifoldIndex;
                }
                if (!islandSleeping) {
                    callback.processIsland(this.islandBodies, this.islandBodies.size(), this.islandmanifold, startManifold_idx, numIslandManifolds, islandId);
                }
                if (numIslandManifolds != 0) {
                    startManifoldIndex = endManifoldIndex;
                }
                this.islandBodies.clear();
                startIslandIndex = endIslandIndex;
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    public static abstract class IslandCallback {
        public abstract void processIsland(ObjectArrayList<CollisionObject> var1, int var2, ObjectArrayList<PersistentManifold> var3, int var4, int var5, int var6);
    }
}

