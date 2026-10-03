/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.io.Serializable;
import javax.vecmath.Tuple2f;

public class TexCoord2f
extends Tuple2f
implements Serializable {
    static final long serialVersionUID = 7998248474800032487L;

    public TexCoord2f(float f, float f2) {
        super(f, f2);
    }

    public TexCoord2f(float[] fArray) {
        super(fArray);
    }

    public TexCoord2f(TexCoord2f texCoord2f) {
        super(texCoord2f);
    }

    public TexCoord2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public TexCoord2f() {
    }
}

