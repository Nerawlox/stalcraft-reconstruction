/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dbvt;
import com.bulletphysics.collision.broadphase.DbvtAabbMm;
import com.bulletphysics.collision.broadphase.DbvtProxy;
import com.bulletphysics.collision.broadphase.DbvtTreeCollider;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.HashedOverlappingPairCache;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class DbvtBroadphase
extends BroadphaseInterface {
    public static final float DBVT_BP_MARGIN = 0.05f;
    public static final int DYNAMIC_SET = 0;
    public static final int FIXED_SET = 1;
    public static final int STAGECOUNT = 2;
    public final Dbvt[] sets = new Dbvt[2];
    public DbvtProxy[] stageRoots = new DbvtProxy[3];
    public OverlappingPairCache paircache;
    public float predictedframes;
    public int stageCurrent;
    public int fupdates;
    public int dupdates;
    public int pid;
    public int gid;
    public boolean releasepaircache;

    public DbvtBroadphase() {
        this(null);
    }

    public DbvtBroadphase(OverlappingPairCache paircache) {
        this.sets[0] = new Dbvt();
        this.sets[1] = new Dbvt();
        this.releasepaircache = paircache == null;
        this.predictedframes = 2.0f;
        this.stageCurrent = 0;
        this.fupdates = 1;
        this.dupdates = 1;
        this.paircache = paircache != null ? paircache : new HashedOverlappingPairCache();
        this.gid = 0;
        this.pid = 0;
        for (int i = 0; i <= 2; ++i) {
            this.stageRoots[i] = null;
        }
    }

    public void collide(Dispatcher dispatcher) {
        DbvtTreeCollider collider;
        this.sets[0].optimizeIncremental(1 + this.sets[0].leaves * this.dupdates / 100);
        this.sets[1].optimizeIncremental(1 + this.sets[1].leaves * this.fupdates / 100);
        this.stageCurrent = (this.stageCurrent + 1) % 2;
        DbvtProxy current = this.stageRoots[this.stageCurrent];
        if (current != null) {
            DbvtProxy next;
            collider = new DbvtTreeCollider(this);
            do {
                next = current.links[1];
                this.stageRoots[current.stage] = DbvtBroadphase.listremove(current, this.stageRoots[current.stage]);
                this.stageRoots[2] = DbvtBroadphase.listappend(current, this.stageRoots[2]);
                Dbvt.collideTT(this.sets[1].root, current.leaf, collider);
                this.sets[0].remove(current.leaf);
                current.leaf = this.sets[1].insert(current.aabb, current);
                current.stage = 2;
            } while ((current = next) != null);
        }
        collider = new DbvtTreeCollider(this);
        Dbvt.collideTT(this.sets[0].root, this.sets[1].root, collider);
        Dbvt.collideTT(this.sets[0].root, this.sets[0].root, collider);
        ObjectArrayList<BroadphasePair> pairs = this.paircache.getOverlappingPairArray();
        if (pairs.size() > 0) {
            int ni = pairs.size();
            for (int i = 0; i < ni; ++i) {
                BroadphasePair p = pairs.getQuick(i);
                DbvtProxy pa = (DbvtProxy)p.pProxy0;
                DbvtProxy pb = (DbvtProxy)p.pProxy1;
                if (DbvtAabbMm.Intersect(pa.aabb, pb.aabb)) continue;
                if (pa.hashCode() > pb.hashCode()) {
                    DbvtProxy tmp = pa;
                    pa = pb;
                    pb = tmp;
                }
                this.paircache.removeOverlappingPair(pa, pb, dispatcher);
                --ni;
                --i;
            }
        }
        ++this.pid;
    }

    private static DbvtProxy listappend(DbvtProxy item, DbvtProxy list) {
        item.links[0] = null;
        item.links[1] = list;
        if (list != null) {
            list.links[0] = item;
        }
        list = item;
        return list;
    }

    private static DbvtProxy listremove(DbvtProxy item, DbvtProxy list) {
        if (item.links[0] != null) {
            item.links[0].links[1] = item.links[1];
        } else {
            list = item.links[1];
        }
        if (item.links[1] != null) {
            item.links[1].links[0] = item.links[0];
        }
        return list;
    }

    @Override
    public BroadphaseProxy createProxy(Vector3f aabbMin, Vector3f aabbMax, BroadphaseNativeType shapeType, Object userPtr, short collisionFilterGroup, short collisionFilterMask, Dispatcher dispatcher, Object multiSapProxy) {
        DbvtProxy proxy = new DbvtProxy(userPtr, collisionFilterGroup, collisionFilterMask);
        DbvtAabbMm.FromMM(aabbMin, aabbMax, proxy.aabb);
        proxy.leaf = this.sets[0].insert(proxy.aabb, proxy);
        proxy.stage = this.stageCurrent;
        proxy.uniqueId = ++this.gid;
        this.stageRoots[this.stageCurrent] = DbvtBroadphase.listappend(proxy, this.stageRoots[this.stageCurrent]);
        return proxy;
    }

    @Override
    public void destroyProxy(BroadphaseProxy absproxy, Dispatcher dispatcher) {
        DbvtProxy proxy = (DbvtProxy)absproxy;
        if (proxy.stage == 2) {
            this.sets[1].remove(proxy.leaf);
        } else {
            this.sets[0].remove(proxy.leaf);
        }
        this.stageRoots[proxy.stage] = DbvtBroadphase.listremove(proxy, this.stageRoots[proxy.stage]);
        this.paircache.removeOverlappingPairsContainingProxy(proxy, dispatcher);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setAabb(BroadphaseProxy broadphaseProxy, Vector3f vector3f, Vector3f vector3f2, Dispatcher dispatcher) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void absproxy;
            $Stack.push$javax$vecmath$Vector3f();
            DbvtProxy proxy = (DbvtProxy)absproxy;
            DbvtAabbMm aabb = DbvtAabbMm.FromMM((Vector3f)aabbMin, (Vector3f)aabbMax, new DbvtAabbMm());
            if (proxy.stage == 2) {
                this.sets[1].remove(proxy.leaf);
                proxy.leaf = this.sets[0].insert(aabb, proxy);
            } else if (DbvtAabbMm.Intersect(proxy.leaf.volume, aabb)) {
                Vector3f delta = $Stack.get$javax$vecmath$Vector3f();
                delta.add((Tuple3f)aabbMin, (Tuple3f)aabbMax);
                delta.scale(0.5f);
                delta.sub(proxy.aabb.Center($Stack.get$javax$vecmath$Vector3f()));
                delta.scale(this.predictedframes);
                this.sets[0].update(proxy.leaf, aabb, delta, 0.05f);
            } else {
                this.sets[0].update(proxy.leaf, aabb);
            }
            this.stageRoots[proxy.stage] = DbvtBroadphase.listremove(proxy, this.stageRoots[proxy.stage]);
            proxy.aabb.set(aabb);
            proxy.stage = this.stageCurrent;
            this.stageRoots[this.stageCurrent] = DbvtBroadphase.listappend(proxy, this.stageRoots[this.stageCurrent]);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void calculateOverlappingPairs(Dispatcher dispatcher) {
        this.collide(dispatcher);
    }

    @Override
    public OverlappingPairCache getOverlappingPairCache() {
        return this.paircache;
    }

    @Override
    public void getBroadphaseAabb(Vector3f aabbMin, Vector3f aabbMax) {
        DbvtAabbMm bounds = new DbvtAabbMm();
        if (!this.sets[0].empty()) {
            if (!this.sets[1].empty()) {
                DbvtAabbMm.Merge(this.sets[0].root.volume, this.sets[1].root.volume, bounds);
            } else {
                bounds.set(this.sets[0].root.volume);
            }
        } else if (!this.sets[1].empty()) {
            bounds.set(this.sets[1].root.volume);
        } else {
            DbvtAabbMm.FromCR(new Vector3f(0.0f, 0.0f, 0.0f), 0.0f, bounds);
        }
        aabbMin.set(bounds.Mins());
        aabbMax.set(bounds.Maxs());
    }

    @Override
    public void printStats() {
    }
}

