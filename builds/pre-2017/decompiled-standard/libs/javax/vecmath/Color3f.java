/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;

public class Color3f
extends Tuple3f
implements Serializable {
    static final long serialVersionUID = -1861792981817493659L;

    public Color3f(float f, float f2, float f3) {
        super(f, f2, f3);
    }

    public Color3f(float[] fArray) {
        super(fArray);
    }

    public Color3f(Color3f color3f) {
        super(color3f);
    }

    public Color3f(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public Color3f(Tuple3d tuple3d) {
        super(tuple3d);
    }

    public Color3f(Color color) {
        super((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f);
    }

    public Color3f() {
    }

    public final void set(Color color) {
        this.x = (float)color.getRed() / 255.0f;
        this.y = (float)color.getGreen() / 255.0f;
        this.z = (float)color.getBlue() / 255.0f;
    }

    public final Color get() {
        int n = Math.round(this.x * 255.0f);
        int n2 = Math.round(this.y * 255.0f);
        int n3 = Math.round(this.z * 255.0f);
        return new Color(n, n2, n3);
    }
}

