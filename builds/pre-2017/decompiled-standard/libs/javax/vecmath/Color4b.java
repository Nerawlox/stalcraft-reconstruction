/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;
import javax.vecmath.Tuple4b;

public class Color4b
extends Tuple4b
implements Serializable {
    static final long serialVersionUID = -105080578052502155L;

    public Color4b(byte by, byte by2, byte by3, byte by4) {
        super(by, by2, by3, by4);
    }

    public Color4b(byte[] byArray) {
        super(byArray);
    }

    public Color4b(Color4b color4b) {
        super(color4b);
    }

    public Color4b(Tuple4b tuple4b) {
        super(tuple4b);
    }

    public Color4b(Color color) {
        super((byte)color.getRed(), (byte)color.getGreen(), (byte)color.getBlue(), (byte)color.getAlpha());
    }

    public Color4b() {
    }

    public final void set(Color color) {
        this.x = (byte)color.getRed();
        this.y = (byte)color.getGreen();
        this.z = (byte)color.getBlue();
        this.w = (byte)color.getAlpha();
    }

    public final Color get() {
        int n = this.x & 0xFF;
        int n2 = this.y & 0xFF;
        int n3 = this.z & 0xFF;
        int n4 = this.w & 0xFF;
        return new Color(n, n2, n3, n4);
    }
}

