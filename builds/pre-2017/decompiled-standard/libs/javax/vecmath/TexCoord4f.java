/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class TexCoord4f
extends Tuple4f
implements Serializable {
    static final long serialVersionUID = -3517736544731446513L;

    public TexCoord4f(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public TexCoord4f(float[] fArray) {
        super(fArray);
    }

    public TexCoord4f(TexCoord4f texCoord4f) {
        super(texCoord4f);
    }

    public TexCoord4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public TexCoord4f(Tuple4d tuple4d) {
        super(tuple4d);
    }

    public TexCoord4f() {
    }
}

