/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;

public class Color4f
extends Tuple4f
implements Serializable {
    static final long serialVersionUID = 8577680141580006740L;

    public Color4f(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public Color4f(float[] fArray) {
        super(fArray);
    }

    public Color4f(Color4f color4f) {
        super(color4f);
    }

    public Color4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Color4f(Tuple4d tuple4d) {
        super(tuple4d);
    }

    public Color4f(Color color) {
        super((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }

    public Color4f() {
    }

    public final void set(Color color) {
        this.x = (float)color.getRed() / 255.0f;
        this.y = (float)color.getGreen() / 255.0f;
        this.z = (float)color.getBlue() / 255.0f;
        this.w = (float)color.getAlpha() / 255.0f;
    }

    public final Color get() {
        int n = Math.round(this.x * 255.0f);
        int n2 = Math.round(this.y * 255.0f);
        int n3 = Math.round(this.z * 255.0f);
        int n4 = Math.round(this.w * 255.0f);
        return new Color(n, n2, n3, n4);
    }
}

