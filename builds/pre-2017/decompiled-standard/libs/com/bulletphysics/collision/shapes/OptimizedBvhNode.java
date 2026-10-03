/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import java.io.Serializable;
import javax.vecmath.Vector3f;

public class OptimizedBvhNode
implements Serializable {
    private static final long serialVersionUID = 1L;
    public final Vector3f aabbMinOrg = new Vector3f();
    public final Vector3f aabbMaxOrg = new Vector3f();
    public int escapeIndex;
    public int subPart;
    public int triangleIndex;

    public void set(OptimizedBvhNode n) {
        this.aabbMinOrg.set(n.aabbMinOrg);
        this.aabbMaxOrg.set(n.aabbMaxOrg);
        this.escapeIndex = n.escapeIndex;
        this.subPart = n.subPart;
        this.triangleIndex = n.triangleIndex;
    }
}

