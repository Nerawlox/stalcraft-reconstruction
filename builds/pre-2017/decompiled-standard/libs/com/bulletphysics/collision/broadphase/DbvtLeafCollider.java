/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.Dbvt;
import com.bulletphysics.collision.broadphase.DbvtAabbMm;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.broadphase.DbvtProxy;

public class DbvtLeafCollider
extends Dbvt.ICollide {
    public DbvtBroadphase pbp;
    public DbvtProxy ppx;

    public DbvtLeafCollider(DbvtBroadphase p, DbvtProxy px) {
        this.pbp = p;
        this.ppx = px;
    }

    @Override
    public void Process(Dbvt.Node na) {
        Dbvt.Node nb = this.ppx.leaf;
        if (nb != na) {
            DbvtProxy pa = (DbvtProxy)na.data;
            DbvtProxy pb = (DbvtProxy)nb.data;
            if (DbvtAabbMm.Intersect(pa.aabb, pb.aabb)) {
                if (pa.hashCode() > pb.hashCode()) {
                    DbvtProxy tmp = pa;
                    pa = pb;
                    pb = tmp;
                }
                this.pbp.paircache.addOverlappingPair(pa, pb);
            }
        }
    }
}

