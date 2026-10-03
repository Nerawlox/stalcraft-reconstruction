/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple3i;

public class Point3i
extends Tuple3i
implements Serializable {
    static final long serialVersionUID = 6149289077348153921L;

    public Point3i(int n, int n2, int n3) {
        super(n, n2, n3);
    }

    public Point3i(int[] nArray) {
        super(nArray);
    }

    public Point3i(Tuple3i tuple3i) {
        super(tuple3i);
    }

    public Point3i() {
    }
}

