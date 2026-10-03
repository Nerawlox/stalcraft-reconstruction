/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;
import javax.vecmath.Tuple3b;

public class Color3b
extends Tuple3b
implements Serializable {
    static final long serialVersionUID = 6632576088353444794L;

    public Color3b(byte by, byte by2, byte by3) {
        super(by, by2, by3);
    }

    public Color3b(byte[] byArray) {
        super(byArray);
    }

    public Color3b(Color3b color3b) {
        super(color3b);
    }

    public Color3b(Tuple3b tuple3b) {
        super(tuple3b);
    }

    public Color3b(Color color) {
        super((byte)color.getRed(), (byte)color.getGreen(), (byte)color.getBlue());
    }

    public Color3b() {
    }

    public final void set(Color color) {
        this.x = (byte)color.getRed();
        this.y = (byte)color.getGreen();
        this.z = (byte)color.getBlue();
    }

    public final Color get() {
        int n = this.x & 0xFF;
        int n2 = this.y & 0xFF;
        int n3 = this.z & 0xFF;
        return new Color(n, n2, n3);
    }
}

