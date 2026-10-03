/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2i;

public class Point2i
extends Tuple2i
implements Serializable {
    static final long serialVersionUID = 9208072376494084954L;

    public Point2i(int n, int n2) {
        super(n, n2);
    }

    public Point2i(int[] nArray) {
        super(nArray);
    }

    public Point2i(Tuple2i tuple2i) {
        super(tuple2i);
    }

    public Point2i() {
    }
}

