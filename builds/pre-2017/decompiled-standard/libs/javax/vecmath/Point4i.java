/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple4i;

public class Point4i
extends Tuple4i
implements Serializable {
    static final long serialVersionUID = 620124780244617983L;

    public Point4i(int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4);
    }

    public Point4i(int[] nArray) {
        super(nArray);
    }

    public Point4i(Tuple4i tuple4i) {
        super(tuple4i);
    }

    public Point4i() {
    }
}

