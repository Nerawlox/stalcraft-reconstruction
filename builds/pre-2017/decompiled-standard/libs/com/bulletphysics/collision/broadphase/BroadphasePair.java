/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import java.util.Comparator;

public class BroadphasePair {
    public BroadphaseProxy pProxy0;
    public BroadphaseProxy pProxy1;
    public CollisionAlgorithm algorithm;
    public Object userInfo;
    public static final Comparator<BroadphasePair> broadphasePairSortPredicate = new Comparator<BroadphasePair>(){

        @Override
        public int compare(BroadphasePair a, BroadphasePair b) {
            boolean result2 = a.pProxy0.getUid() > b.pProxy0.getUid() || a.pProxy0.getUid() == b.pProxy0.getUid() && a.pProxy1.getUid() > b.pProxy1.getUid() || a.pProxy0.getUid() == b.pProxy0.getUid() && a.pProxy1.getUid() == b.pProxy1.getUid();
            return result2 ? -1 : 1;
        }
    };

    public BroadphasePair() {
    }

    public BroadphasePair(BroadphaseProxy pProxy0, BroadphaseProxy pProxy1) {
        this.pProxy0 = pProxy0;
        this.pProxy1 = pProxy1;
        this.algorithm = null;
        this.userInfo = null;
    }

    public void set(BroadphasePair p) {
        this.pProxy0 = p.pProxy0;
        this.pProxy1 = p.pProxy1;
        this.algorithm = p.algorithm;
        this.userInfo = p.userInfo;
    }

    public boolean equals(BroadphasePair p) {
        return this.pProxy0 == p.pProxy0 && this.pProxy1 == p.pProxy1;
    }
}

